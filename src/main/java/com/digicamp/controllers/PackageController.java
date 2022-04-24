package com.digicamp.controllers;
import com.digicamp.entity.Package;
import com.digicamp.entity.Role;
import com.digicamp.service.PackageService;
import com.digicamp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController {

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
