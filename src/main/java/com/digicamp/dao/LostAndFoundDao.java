package com.digicamp.dao;

import com.digicamp.entity.LostAndFound;
import org.springframework.data.repository.CrudRepository;

public interface LostAndFoundDao extends CrudRepository<LostAndFound, Integer> {
}
