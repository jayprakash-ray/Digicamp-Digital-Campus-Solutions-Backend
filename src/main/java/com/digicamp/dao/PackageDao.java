package com.digicamp.dao;

import com.digicamp.entity.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDao extends CrudRepository<Package, Integer> {

}