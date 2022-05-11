package com.digicamp.controllers;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import com.digicamp.entity.Package;
import com.digicamp.entity.Role;
import com.digicamp.service.PackageService;
import com.digicamp.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController {
    private static final Logger logger = LogManager.getLogger(PackageController.class);

    @Autowired
    private PackageService packageService;

    @PostMapping("")
    public Package createPackage(@RequestBody Package pkg){
        logger.info("createPackage called!");
        if(pkg.getOwnerName()==null){
            logger.warn("createPackage has no ownerName");
            return null;
        }else if(pkg.getMobileNo()==null){
            logger.warn("createPackage has no mobileNumber");
            return null;
        }
        return packageService.createPackage(pkg);
    }

    @GetMapping("")
    public List<Package> getAllPackages(){
        logger.info("getAllPackages called!");
        return packageService.getAllPackages();
    }

    @GetMapping("/{id}")
    public List<Package> getMyPackages(@PathVariable String id){
        logger.info("getMyPackages called!");
        return packageService.getMyPackages(id);
    }

    @PutMapping("")
    public Package updatePackage(@RequestBody Package pkg){
        logger.info("updatePackage called!");
        return packageService.updatePackage(pkg);
    }

    @DeleteMapping("/{id}")
    public void deletePackage(@PathVariable int id){
        logger.info("deletePackage called!");
        packageService.deletePackage(id);
    }
}
