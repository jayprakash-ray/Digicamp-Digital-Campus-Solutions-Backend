package com.digicamp.service;

import com.digicamp.DigiCampApplication;
import com.digicamp.dao.DeliveryHistoryDao;
import com.digicamp.entity.DeliveryHistory;
import com.digicamp.exception.APIRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryHistoryService {
    private static final Logger logger = LogManager.getLogger(DigiCampApplication.class);

    @Autowired
    private DeliveryHistoryDao deliveryHistoryDao;

    public DeliveryHistory createDelivery(DeliveryHistory deliveryHistory){
        try{
            return deliveryHistoryDao.save(deliveryHistory);
        } catch (Exception e){
            logger.error("Bad Request Body!");
            throw new APIRequestException("Bad Request Body!");
        }
    }

    public List<DeliveryHistory> getAllDeliveryHistory(){
        List<DeliveryHistory> deliveryHistories = (List<DeliveryHistory>) deliveryHistoryDao.findAll();
        return deliveryHistories;
    }
}
