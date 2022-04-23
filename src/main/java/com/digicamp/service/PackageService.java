package com.digicamp.service;

import com.digicamp.dao.PackageDao;
import com.digicamp.dao.RoleDao;
import com.digicamp.entity.Package;
import com.digicamp.entity.Role;
import com.digicamp.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    @Autowired
    private PackageDao packageDao;

    public Package createPackage(Package pkg){
        try{
            return packageDao.save(pkg);
        } catch (Exception e){

            throw new APIRequestException("A Package is already present with ID: " + pkg.getPid());
        }
    }

    public List<Package> getAllPackages(){
        List<Package> packages = (List<Package>) packageDao.findAll();
        return packages;
    }

}
