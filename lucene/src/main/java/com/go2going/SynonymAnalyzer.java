package com.go2going;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.cn.smart.HMMChineseTokenizer;
import org.apache.lucene.analysis.synonym.SynonymGraphFilterFactory;
import org.apache.lucene.analysis.util.FilesystemResourceLoader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 中文同义词分词器
 *
 * @author BlueT
 * 2017/9/24 16:23
 */
public class SynonymAnalyzer extends Analyzer {


    @Override
    protected TokenStreamComponents createComponents(String s) {
        Tokenizer tokenizer = new HMMChineseTokenizer();
        Map<String, String> map = new HashMap<>();
        map.put("synonyms", "synonyms.txt");

        SynonymGraphFilterFactory factory = new SynonymGraphFilterFactory(map);
        //同义词的加载
        try {
            factory.inform(new FilesystemResourceLoader(Paths.get("C:\\Users\\BlueT\\workspace\\personCode\\lucene\\src\\main\\resources")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TokenStream tokenStream = factory.create(tokenizer);

        return new TokenStreamComponents(tokenizer,tokenStream);
    }

}



