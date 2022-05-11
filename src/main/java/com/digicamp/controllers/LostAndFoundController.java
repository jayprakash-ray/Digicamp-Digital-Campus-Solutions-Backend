package com.digicamp.controllers;

import com.digicamp.entity.LostAndFound;
import com.digicamp.service.LostAndFoundService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost-found")
public class LostAndFoundController {
    private static final Logger logger = LogManager.getLogger(LostAndFoundController.class);

    @Autowired
    private LostAndFoundService lostAndFoundService;

    @GetMapping("")
    public List<LostAndFound> getAllItems(){
        logger.info("getAllItems called!");
        return lostAndFoundService.getAllItems();
    }

    @GetMapping("/not-collected")
    public List<LostAndFound> getNotCollectedItems(){
        logger.info("getNotCollectedItems called!");
        return lostAndFoundService.getNotCollectedItems();
    }

    @PostMapping("")
    public LostAndFound addItem(@RequestBody LostAndFound lostAndFound){
        logger.info("addItem called!");
        return lostAndFoundService.addItem(lostAndFound);
    }
    @GetMapping("/{id}")
    public LostAndFound getItem(@PathVariable int id){
        logger.info("getItem called!");
        return lostAndFoundService.getItem(id);
    }

    @PutMapping("/{id}")
    public LostAndFound updateItem(@RequestBody LostAndFound lostAndFound, @PathVariable int id){
        logger.info("updateItem called!");
        lostAndFound.setLostOrFound(id);
        return lostAndFoundService.updateItem(lostAndFound);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        logger.info("deleteItem called!");
        lostAndFoundService.deleteItem(id);
    }
}