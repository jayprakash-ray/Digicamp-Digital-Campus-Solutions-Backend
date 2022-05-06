package com.digicamp.dao;

import com.digicamp.entity.DeliveryHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryHistoryDao extends CrudRepository<DeliveryHistory,Integer> {
}
