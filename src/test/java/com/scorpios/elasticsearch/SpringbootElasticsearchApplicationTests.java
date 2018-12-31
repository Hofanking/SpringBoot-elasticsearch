package com.scorpios.elasticsearch;

import com.scorpios.elasticsearch.bean.Article;
import com.scorpios.elasticsearch.bean.MyBook;
import com.scorpios.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;


    @Test
    public void test02() {

        MyBook myBook = new MyBook(1, "红楼梦", "曹雪芹");
        bookRepository.index(myBook);

    }


    @Test
    public void contextLoads() {

        Article article = new Article(1, "西游记", "吴承恩", "师徒四人西天取经");

        //构建一个索引功能:在scorpios索引下，类型为article
        Index build = new Index.Builder(article).index("scorpios").type("article").build();

        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testSearch() {

        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"取经\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //构建搜索
        Search build = new Search.Builder(json).addIndex("scorpios").addType("article").build();

        try {
            SearchResult result = jestClient.execute(build);
            System.out.println("搜索结果：" + result.getJsonString());
            System.out.println("搜索结果：" + result.getSourceAsString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

