package com.digicamp.dao;

import com.digicamp.entity.Package;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageDao extends CrudRepository<Package, Integer> {
    @Query("SELECT p from Package p WHERE p.mobileNo=?1 or p.mobileNo=?2")
    public List<Package> findAllByMobile(Long mobile1, Long mobile2);
}