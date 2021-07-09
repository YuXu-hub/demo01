package com.yx.menu.dao;

import com.yx.menu.entity.MenuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsDao extends ElasticsearchRepository<MenuEs,Integer> {
}
