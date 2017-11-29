package com.go2going;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.synonym.SynonymGraphFilterFactory;
import org.apache.lucene.analysis.util.FilesystemResourceLoader;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author BlueT
 * 2017/9/24 16:32
 */
public class SmartCn {

    private static final URL dir = SmartCn.class.getClass().getResource("/luceneIndexDir");


    public static void writer()  {
        try (Directory directory = FSDirectory.open(Paths.get(dir.toURI()))){
            IndexWriterConfig config = new IndexWriterConfig(new SmartChineseAnalyzer());
            IndexWriter writer = new IndexWriter(directory, config);
            Document document = new Document();
            document.add(new TextField("name","王强", Field.Store.YES));
            document.add(new StoredField("age",25));
            writer.addDocument(document);
            writer.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static void reader()  {
        try (Directory directory = FSDirectory.open(Paths.get(String.valueOf(dir))); DirectoryReader open = DirectoryReader.open(directory);){

            IndexSearcher searcher = new IndexSearcher(open);
//            QueryBuilder phraseQuery = new QueryBuilder(new SmartChineseAnalyzer());
            QueryBuilder phraseQuery = new QueryBuilder(new SynonymAnalyzer());

            Query query = phraseQuery.createPhraseQuery("name", "王强");
//            Query query = new MatchAllDocsQuery();
            
            TopDocs search = searcher.search(query, 1000);

            ScoreDoc[] scoreDocs = search.scoreDocs;

            for (ScoreDoc scoreDoc : scoreDocs) {
                Document doc = searcher.doc(scoreDoc.doc);
                System.out.println(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void chineseAnalyzer() throws IOException {
        //设置停用词
        Set<String> stopWord = new HashSet<>(3);
        stopWord.add("的");
        stopWord.add("是");
        stopWord.add("我");
        CharArraySet set = new CharArraySet(stopWord, true);
        Analyzer analyzer = new SmartChineseAnalyzer(set);
        TokenStream tokenStream = analyzer.tokenStream("name", "我的名字是王强");

        tokenStream=synonymFilter(tokenStream);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            System.out.println(tokenStream.toString());
            tokenStream.clearAttributes();
        }
        tokenStream.end();
        tokenStream.close();



    }

    /**
     * 同义词过滤器
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static TokenStream synonymFilter(TokenStream inputStream) throws IOException {
        //同义词过滤器的配置
        Map<String, String> map = new HashMap<>();
        map.put("synonyms", "synonyms.txt");

        SynonymGraphFilterFactory factory = new SynonymGraphFilterFactory(map);
        //同义词的加载
        factory.inform(new FilesystemResourceLoader(Paths.get("C:\\Users\\BlueT\\workspace\\personCode\\lucene\\src\\main\\resources")));
        return factory.create(inputStream);
    }




    public static void main(String[] args) throws IOException {
//        writer();
//        chineseAnalyzer();
        reader();
    }

}
