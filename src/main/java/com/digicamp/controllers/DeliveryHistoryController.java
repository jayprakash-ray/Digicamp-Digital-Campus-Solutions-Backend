package com.digicamp.controllers;

import com.digicamp.DigiCampApplication;
import com.digicamp.entity.DeliveryHistory;
import com.digicamp.entity.Package;
import com.digicamp.service.DeliveryHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/history")
public class DeliveryHistoryController {
    private static final Logger logger = LogManager.getLogger(DeliveryHistoryController.class);
    @Autowired
    private DeliveryHistoryService deliveryHistoryService;

    @PostMapping("")
    public DeliveryHistory createDelivery(@RequestBody DeliveryHistory deliveryHistory){
        logger.info("createDelivery called!");
        return deliveryHistoryService.createDelivery(deliveryHistory);
    }

    @GetMapping("")
    public List<DeliveryHistory> getAllPackages(){
        logger.info("getAllPackages called!");
        return deliveryHistoryService.getAllDeliveryHistory();
    }
}
