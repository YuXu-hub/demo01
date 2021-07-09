package com.yx.menu.dao;

import com.yx.menu.entity.Msg;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDao extends MongoRepository<Msg,String> {
}
