## git

### tips

1. 删除git上某个文件夹

如果直接git rm本地的文件夹也被删除，应该删缓冲。

`git rm -r --cached some-directorygit commit -m "Remove the now ignored directory some-directory"`

最后push~

