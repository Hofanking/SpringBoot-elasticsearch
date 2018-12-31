package com.scorpios.elasticsearch.repository;

import com.scorpios.elasticsearch.bean.MyBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Think
 * @Title: BookRepository
 * @ProjectName springboot-elasticsearch
 * @Description: TODO
 * @date 2018/12/1616:30
 */
public interface BookRepository extends ElasticsearchRepository<MyBook, Integer> {
}
