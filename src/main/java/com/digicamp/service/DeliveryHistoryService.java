package com.digicamp.service;

import com.digicamp.dao.DeliveryHistoryDao;
import com.digicamp.entity.DeliveryHistory;
import com.digicamp.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryHistoryService {
    @Autowired
    private DeliveryHistoryDao deliveryHistoryDao;

    public DeliveryHistory createDelivery(DeliveryHistory deliveryHistory){
        try{
            return deliveryHistoryDao.save(deliveryHistory);
        } catch (Exception e){

            throw new APIRequestException("Bad Request BodY!");
        }
    }

    public List<DeliveryHistory> getAllDeliveryHistory(){
        List<DeliveryHistory> deliveryHistories = (List<DeliveryHistory>) deliveryHistoryDao.findAll();
        return deliveryHistories;
    }
}
