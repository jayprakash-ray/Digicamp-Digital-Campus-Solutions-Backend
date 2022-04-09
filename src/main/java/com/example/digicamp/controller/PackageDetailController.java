package com.example.digicamp.controller;

import com.example.digicamp.model.PackageDetail;
import com.example.digicamp.repository.PackageDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageDetailController {

    @Autowired
    private PackageDetailRepository packageDetailRepository;



}
