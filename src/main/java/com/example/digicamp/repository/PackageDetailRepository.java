package com.example.digicamp.repository;


import com.example.digicamp.model.PackageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PackageDetailRepository extends JpaRepository<PackageDetail , Long> {

//    all crud database methods
}
