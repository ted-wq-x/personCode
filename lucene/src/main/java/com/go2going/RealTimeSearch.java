package com.go2going;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  RealTimeSearch<br>
 * 描述：实时查询，index时，不要手动commit
 *
 * @author wangqiang
 * 创建时间：  2017/11/28 0028 11:23
 */
public class RealTimeSearch {

    private static final URL dir = SmartCn.class.getClass().getResource("/luceneIndexDir");

    private static IndexWriter writer;
    private static ReferenceManager<IndexSearcher> manager;

    static {
        try {
            Directory directory = FSDirectory.open(Paths.get(dir.toURI()));
            IndexWriterConfig config = new IndexWriterConfig(new SmartChineseAnalyzer());
            writer = new IndexWriter(directory, config);

             manager = new SearcherManager(writer, new SearcherFactory());

            ControlledRealTimeReopenThread<IndexSearcher> timeReopenThread = new ControlledRealTimeReopenThread<>
                    (writer, manager, 5, 0.025);
            timeReopenThread.setName("controlledRealTimeReopenThread");
            timeReopenThread.setDaemon(true);
            timeReopenThread.start();


            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    if (writer != null) {
                        writer.close();
                    }

                    if (manager != null) {
                        manager.close();
                    }

                    if (timeReopenThread != null) {
                        timeReopenThread.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void index(List<Document> list){
        try {
            writer.addDocuments(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void index(Document document){
        try {
            writer.addDocument(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void search( ) {
        IndexSearcher searcher = null;
        try {
            searcher = manager.acquire();
            TopDocs name = searcher.search(new QueryParser("name", new SmartChineseAnalyzer()).parse("王强"), 10);

            for (ScoreDoc scoreDoc : name.scoreDocs) {
                Document doc = searcher.doc(scoreDoc.doc);
                System.out.println(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                manager.release(searcher);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        /*for (int i = 1; i < 10; i++) {
            Document document = new Document();
            document.add(new TextField("name","王强", Field.Store.YES));
            document.add(new StringField("id",i+"", Field.Store.YES));
            index(document);

            Thread.sleep(6000);

           search();
            System.out.println("-----------------------------");
        }
*/

        search();
    }
}
