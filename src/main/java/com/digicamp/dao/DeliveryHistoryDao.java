package com.digicamp.dao;

import com.digicamp.entity.DeliveryHistory;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryHistoryDao extends CrudRepository<DeliveryHistory,Integer> {
}
