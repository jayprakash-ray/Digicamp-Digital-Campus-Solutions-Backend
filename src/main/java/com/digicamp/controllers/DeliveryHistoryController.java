package com.digicamp.controllers;

import com.digicamp.entity.DeliveryHistory;
import com.digicamp.entity.Package;
import com.digicamp.service.DeliveryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/history")
public class DeliveryHistoryController {

    @Autowired
    private DeliveryHistoryService deliveryHistoryService;

    @PostMapping("")
    public DeliveryHistory createDelivery(@RequestBody DeliveryHistory deliveryHistory){
        return deliveryHistoryService.createDelivery(deliveryHistory);
    }

    @GetMapping("")
    public List<DeliveryHistory> getAllPackages(){
        return deliveryHistoryService.getAllDeliveryHistory();
    }
}
