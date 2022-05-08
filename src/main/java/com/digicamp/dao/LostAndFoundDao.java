package com.digicamp.dao;

import com.digicamp.entity.LostAndFound;
import com.digicamp.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LostAndFoundDao extends CrudRepository<LostAndFound, Integer> {
    @Query("SELECT l FROM LostAndFound l WHERE l.isCollected=0")
    public List<LostAndFound> getNotCollectedItems();
}
