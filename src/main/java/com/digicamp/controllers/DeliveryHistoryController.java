package com.digicamp.controllers;

import com.digicamp.entity.Package;
import com.digicamp.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/history")
public class DeliveryHistoryController {

    @Autowired
    private PackageService packageService;

    @PostMapping("")
    public Package createPackage(@RequestBody Package pkg){
        return packageService.createPackage(pkg);
    }

    @GetMapping("")
    public List<Package> getAllPackages(){
        return packageService.getAllPackages();
    }
}
