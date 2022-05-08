package com.digicamp.controllers;

import com.digicamp.entity.LostAndFound;
import com.digicamp.service.LostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost-found")
public class LostAndFoundController {
    @Autowired
    private LostAndFoundService lostAndFoundService;

    @GetMapping("")
    public List<LostAndFound> getAllItems(){
        return lostAndFoundService.getAllItems();
    }

    @GetMapping("/not-collected")
    public List<LostAndFound> getNotCollectedItems(){
        return lostAndFoundService.getNotCollectedItems();
    }

    @PostMapping("")
    public LostAndFound addItem(@RequestBody LostAndFound lostAndFound){
        return lostAndFoundService.addItem(lostAndFound);
    }
    @GetMapping("/{id}")
    public LostAndFound getItem(@PathVariable int id){
        return lostAndFoundService.getItem(id);
    }

    @PutMapping("/{id}")
    public LostAndFound getItem(@RequestBody LostAndFound lostAndFound, @PathVariable int id){
        lostAndFound.setLostOrFound(id);
        return lostAndFoundService.updateItem(lostAndFound);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        lostAndFoundService.deleteItem(id);
    }
}