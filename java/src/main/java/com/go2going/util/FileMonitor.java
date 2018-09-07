package com.go2going.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

/**
 * 监控文件修改
 */
public class FileMonitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Scanner.class);
    private static int scannerId = 0;
    private final List<Listener> listeners = new ArrayList<>();
    private final Map<String, TimeNSize> prevScan = new HashMap<>();
    private final Map<String, TimeNSize> currentScan = new HashMap<>();
    private final List<File> scanDirs = new ArrayList<>();
    private final Map<String, Notification> notifications = new HashMap<>();
    private int scanInterval;
    private int scanCount = 0;
    private FilenameFilter filter;
    private volatile boolean running = false;
    private boolean reportExisting = true;
    private boolean reportDirs = true;
    private Timer timer;
    private TimerTask timerTask;
    private int scanDepth = 0;


    ///////////////////////////////////////////////////////////////////////////
    // get和set方法
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the scan interval
     *
     * @return interval between scans in seconds
     */
    public synchronized int getScanInterval() {
        return scanInterval;
    }

    /**
     * Set the scan interval
     *
     * @param scanInterval pause between scans in seconds, or 0 for no scan after the initial scan.
     */
    public synchronized void setScanInterval(int scanInterval) {
        this.scanInterval = scanInterval;
        schedule();
    }

    public synchronized void addScanDir(File dir) {
        scanDirs.add(dir);
    }

    public List<File> getScanDirs() {
        return Collections.unmodifiableList(scanDirs);
    }

    /**
     * first remove all dirs then add new dirs
     * @param dirs
     */
    public void setScanDirs(List<File> dirs) {
        scanDirs.clear();
        scanDirs.addAll(dirs);
    }

    /**
     * @return True if scanning is fully recursive (scandepth==-1)
     * @see #getScanDepth()
     */
    public boolean getRecursive() {
        return scanDepth == -1;
    }

    /**
     * @param recursive True if scanning is recursive
     * @see #setScanDepth(int)
     */
    public void setRecursive(boolean recursive) {
        scanDepth = recursive ? -1 : 0;
    }

    /**
     * Get the scanDepth.
     *
     * @return the scanDepth
     */
    public int getScanDepth() {
        return scanDepth;
    }

    /**
     * Set the scanDepth.
     *
     * @param scanDepth the scanDepth to set
     */
    public void setScanDepth(int scanDepth) {
        this.scanDepth = scanDepth;
    }

    /**
     * Get any filter applied to files in the scan dir.
     *
     * @return the filename filter
     */
    public FilenameFilter getFilenameFilter() {
        return filter;
    }

    /**
     * Apply a filter to files found in the scan directory.
     * Only files matching the filter will be reported as added/changed/removed.
     *
     * @param filter the filename filter to use
     */
    public void setFilenameFilter(FilenameFilter filter) {
        this.filter = filter;
    }

    /* ------------------------------------------------------------ */
    public boolean getReportExistingFilesOnStartup() {
        return reportExisting;
    }

    /* ------------------------------------------------------------ */

    /**
     * Whether or not an initial scan will report all files as being
     * added.
     *
     * @param reportExisting if true, all files found on initial scan will be
     *                       reported as being added, otherwise not
     */
    public void setReportExistingFilesOnStartup(boolean reportExisting) {
        this.reportExisting = reportExisting;
    }

    /* ------------------------------------------------------------ */

    /* ------------------------------------------------------------ */
    public boolean getReportDirs() {
        return reportDirs;
    }

    /* ------------------------------------------------------------ */

    /**
     * Set if found directories should be reported.
     *
     * @param dirs true to report directory changes as well
     */
    public void setReportDirs(boolean dirs) {
        reportDirs = dirs;
    }

    /* ------------------------------------------------------------ */

    /**
     * Add an added/removed/changed listener
     *
     * @param listener the listener to add
     */
    public synchronized void addListener(Listener listener) {
        if (listener == null)
            return;
        listeners.add(listener);
    }

    /**
     * Remove a registered listener
     *
     * @param listener the Listener to be removed
     */
    public synchronized void removeListener(Listener listener) {
        if (listener == null)
            return;
        listeners.remove(listener);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 方法
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Start the scanning action.
     */
    public synchronized void doStart() {
        if (running)
            return;

        running = true;

        if (reportExisting) {
            // if files exist at startup, report them
            scan();
            scan(); // scan twice so files reported as stable
        } else {
            //just register the list of existing files and only report changes
            scanFiles();
            prevScan.putAll(currentScan);
        }
        schedule();
    }

    /* ------------------------------------------------------------ */

    private void schedule() {
        if (!running) {
            return;
        }

        if (timer != null)
            timer.cancel();
        if (timerTask != null)
            timerTask.cancel();
        if (getScanInterval() > 0) {
            timer = new Timer("Scanner-" + scannerId++, true);
            timerTask =  new TimerTask() {
                @Override
                public void run() {
                    scan();
                }
            };
            timer.schedule(timerTask, 1010L * getScanInterval(), 1010L * getScanInterval());
        }
    }

    /**
     * Stop the scanning.
     */
    public synchronized void doStop() {
        if (!running) {
            return;
        }

        running = false;

        //关闭调度
        if (timer != null)
            timer.cancel();

        //取消任务
        if (timerTask != null)
            timerTask.cancel();
        timerTask = null;
        timer = null;

    }

    /* ------------------------------------------------------------ */

    /**
     * @param path tests if the path exists
     * @return true if the path exists in one of the scandirs
     */
    public boolean exists(String path) {
        for (File dir : scanDirs)
            if (new File(dir, path).exists())
                return true;
        return false;
    }

    /* ------------------------------------------------------------ */

    /**
     * Perform a pass of the scanner and report changes<br>
     * public for test
     */
    public synchronized void scan() {
        reportScanStart(++scanCount);
        scanFiles();
        reportDifferences(currentScan, prevScan);
        prevScan.clear();
        prevScan.putAll(currentScan);
        reportScanEnd(scanCount);

        for (Listener l : listeners) {
            try {
                if (l instanceof ScanListener)
                    ((ScanListener) l).scan();
            } catch (Exception | Error e) {
                LOGGER.warn("", e);
            }
        }
    }

    /**
     * Recursively scan all files in the designated directories.
     */
    private synchronized void scanFiles() {
        if (scanDirs.isEmpty())
            return;

        currentScan.clear();
        for (File dir : scanDirs) {
            if ((dir != null) && (dir.exists()))
                try {
                    scanFile(dir.getCanonicalFile(), currentScan, 0);
                } catch (IOException e) {
                    LOGGER.warn("Error scanning files.", e);
                }
        }
    }


    /**
     * Get last modified time on a single file or recurse if
     * the file is a directory.
     *
     * @param f           file or directory
     * @param scanInfoMap map of filenames to last modified times
     */
    private void scanFile(File f, Map<String, TimeNSize> scanInfoMap, int depth) {
        try {
            if (!f.exists())
                return;

            if (f.isFile() || depth > 0 && reportDirs && f.isDirectory()) {
                if (filter == null || filter.accept(f.getParentFile(), f.getName())) {
                    if (LOGGER.isDebugEnabled())
                        LOGGER.debug("scan accepted {}", f);
                    String name = f.getCanonicalPath();
                    scanInfoMap.put(name, new TimeNSize(f.lastModified(), f.isDirectory() ? 0 : f.length()));
                } else {
                    if (LOGGER.isDebugEnabled())
                        LOGGER.debug("scan rejected {}", f);
                }
            }

            // If it is a directory, scan if it is a known directory or the depth is OK.
            if (f.isDirectory() && (depth < scanDepth || scanDepth == -1 || scanDirs.contains(f))) {
                File[] files = f.listFiles();
                if (files != null) {
                    for (File file : files) {
                        scanFile(file, scanInfoMap, depth + 1);
                    }
                } else
                    LOGGER.warn("Error listing files in directory {}", f);
            }
        } catch (IOException e) {
            LOGGER.warn("Error scanning watched files", e);
        }
    }

    private void warn(Object listener, String filename, Throwable th) {
        LOGGER.warn(listener + " failed on '" + filename, th);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 触发事件
    ///////////////////////////////////////////////////////////////////////////


    /**
     * Report the adds/changes/removes to the registered listeners
     *
     * @param currentScan the info from the most recent pass
     * @param oldScan     info from the previous pass
     */
    private synchronized void reportDifferences(Map<String, TimeNSize> currentScan, Map<String, TimeNSize> oldScan) {
        // scan the differences and add what was found to the map of notifications:

        Set<String> oldScanKeys = new HashSet<String>(oldScan.keySet());

        // Look for new and changed files
        for (Map.Entry<String, TimeNSize> entry : currentScan.entrySet()) {
            String file = entry.getKey();
            if (!oldScanKeys.contains(file)) {
                Notification old = notifications.put(file, Notification.ADDED);
                //原先存在事件就替换掉
                if (old != null) {
                    switch (old) {
                        case REMOVED:
                        case CHANGED:
                            notifications.put(file, Notification.CHANGED);
                    }
                }
            } else if (!oldScan.get(file).equals(currentScan.get(file))) {
                Notification old = notifications.put(file, Notification.CHANGED);
                if (old != null) {
                    switch (old) {
                        case ADDED:
                            notifications.put(file, Notification.ADDED);
                    }
                }
            }
        }

        // Look for deleted files
        for (String file : oldScan.keySet()) {
            if (!currentScan.containsKey(file)) {
                Notification old = notifications.put(file, Notification.REMOVED);
                if (old != null) {
                    switch (old) {
                        case ADDED:
                            notifications.remove(file);
                    }
                }
            }
        }

        if (LOGGER.isDebugEnabled())
            LOGGER.debug("scanned " + scanDirs + ": " + notifications);

        // Process notifications
        // Only process notifications that are for stable files (ie same in old and current scan).
        List<String> bulkChanges = new ArrayList<>();
        for (Iterator<Map.Entry<String, Notification>> iter = notifications.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<String, Notification> entry = iter.next();
            String file = entry.getKey();

            // Is the file stable?
            // 稳定的文件才会被提醒，防止文件被频繁的修改导致提醒过多（如idea的自动保存）
            if (oldScan.containsKey(file)) {
                if (!oldScan.get(file).equals(currentScan.get(file)))
                    continue;
            } else if (currentScan.containsKey(file))
                continue;

            // File is stable so notify
            Notification notification = entry.getValue();
            iter.remove();
            bulkChanges.add(file);
            switch (notification) {
                case ADDED:
                    reportAddition(file);
                    break;
                case CHANGED:
                    reportChange(file);
                    break;
                case REMOVED:
                    reportRemoval(file);
                    break;
            }
        }
        if (!bulkChanges.isEmpty())
            reportBulkChanges(bulkChanges);
    }

    /**
     * Report a file addition to the registered FileAddedListeners
     *
     * @param filename the filename
     */
    private void reportAddition(String filename) {
        for (Listener l : listeners) {
            try {
                if (l instanceof DiscreteListener)
                    ((DiscreteListener) l).fileAdded(filename);
            } catch (Exception | Error e) {
                warn(l, filename, e);
            }
        }
    }

    /**
     * Report a file removal to the FileRemovedListeners
     *
     * @param filename the filename
     */
    private void reportRemoval(String filename) {
        Iterator<Listener> itor = listeners.iterator();
        while (itor.hasNext()) {
            Object l = itor.next();
            try {
                if (l instanceof DiscreteListener)
                    ((DiscreteListener) l).fileRemoved(filename);
            } catch (Exception | Error e) {
                warn(l, filename, e);
            }
        }
    }

    /**
     * Report a file change to the FileChangedListeners
     *
     * @param filename the filename
     */
    private void reportChange(String filename) {
        for (Listener l : listeners) {
            try {
                if (l instanceof DiscreteListener)
                    ((DiscreteListener) l).fileChanged(filename);
            } catch (Exception | Error e) {
                warn(l, filename, e);
            }
        }
    }

    private void reportBulkChanges(List<String> filenames) {
        for (Listener l : listeners) {
            try {
                if (l instanceof BulkListener)
                    ((BulkListener) l).filesChanged(filenames);
            } catch (Exception | Error e) {
                warn(l, filenames.toString(), e);
            }
        }
    }

    /**
     * signal any scan cycle listeners that a scan has started
     */
    private void reportScanStart(int cycle) {
        for (Listener listener : listeners) {
            try {
                if (listener instanceof ScanCycleListener) {
                    ((ScanCycleListener) listener).scanStarted(cycle);
                }
            } catch (Exception e) {
                LOGGER.warn(listener + " failed on scan start for cycle " + cycle, e);
            }
        }
    }

    /**
     * sign
     */
    private void reportScanEnd(int cycle) {
        for (Listener listener : listeners) {
            try {
                if (listener instanceof ScanCycleListener) {
                    ((ScanCycleListener) listener).scanEnded(cycle);
                }
            } catch (Exception e) {
                LOGGER.warn(listener + " failed on scan end for cycle " + cycle, e);
            }
        }
    }


    /**
     * 事件类型
     */
    public  enum Notification {
        ADDED, CHANGED, REMOVED
    }

    /**
     * Listener
     */
    public interface Listener {
    }


    public interface ScanListener extends Listener {
        public void scan();
    }


    /**
     * 对文件的增删改事件分开处理
     */
    public interface DiscreteListener extends Listener {
        public void fileChanged(String filename) throws Exception;

        public void fileAdded(String filename) throws Exception;

        public void fileRemoved(String filename) throws Exception;
    }

    /**
     * 对文件的增删改事件统一处理
     */
    public interface BulkListener extends Listener {
        public void filesChanged(List<String> filenames) throws Exception;
    }

    /**
     * Listener that notifies when a scan has started and when it has ended.
     */
    public interface ScanCycleListener extends Listener {
        public void scanStarted(int cycle) throws Exception;

        public void scanEnded(int cycle) throws Exception;
    }

    private static class TimeNSize {
        final long lastModified;
        final long size;

        TimeNSize(long lastModified, long size) {
            this.lastModified = lastModified;
            this.size = size;
        }

        @Override
        public int hashCode() {
            return (int) lastModified ^ (int) size;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof TimeNSize) {
                TimeNSize tns = (TimeNSize) o;
                return tns.lastModified == lastModified && tns.size == size;
            }
            return false;
        }

        @Override
        public String toString() {
            return "[lm=" + lastModified + ",s=" + size + "]";
        }
    }
}
