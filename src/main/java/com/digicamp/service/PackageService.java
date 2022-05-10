package com.digicamp.service;

import com.digicamp.dao.PackageDao;
import com.digicamp.dao.RoleDao;
import com.digicamp.dao.UserDao;
import com.digicamp.entity.Package;
import com.digicamp.entity.Role;
import com.digicamp.entity.User;
import com.digicamp.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    @Autowired
    private PackageDao packageDao;
    @Autowired
    private UserDao userDao;
    public Package createPackage(Package pkg){
        return packageDao.save(pkg);
    }

    public List<Package> getAllPackages(){
        List<Package> packages = (List<Package>) packageDao.findAll();
        return packages;
    }

    public List<Package> getMyPackages(String id){
        User user = userDao.getMobileByEmail(id);
        List<Package> packages = (List<Package>) packageDao.findAllByMobile(Long.parseLong(user.getMobile1()), Long.parseLong(user.getMobile2()));
        return packages;
    }

    public Package updatePackage(Package pkg){
        return packageDao.save(pkg);
    }

}
