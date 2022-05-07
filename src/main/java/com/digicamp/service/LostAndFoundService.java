package com.digicamp.service;

import com.digicamp.dao.LostAndFoundDao;
import com.digicamp.entity.LostAndFound;
import com.digicamp.exception.APIRequestException;
//import org.jcp.xml.dsig.internal.SignerOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostAndFoundService {
    @Autowired
    private LostAndFoundDao lostAndFoundDao;

    public List<LostAndFound> getAllItems(){
        return (List<LostAndFound>) lostAndFoundDao.findAll();
    }

    public LostAndFound addItem(LostAndFound lostAndFound){
        System.out.println("lostAndFound: "+lostAndFound);
        try{
            return lostAndFoundDao.save(lostAndFound);
        } catch (Exception e) {
            throw new APIRequestException("Invalid Request Body!");
        }
    }

    public LostAndFound getItem(int id){
        return lostAndFoundDao.findById(id).get();
    }

    public LostAndFound updateItem(LostAndFound lostAndFound){
        return lostAndFoundDao.save(lostAndFound);
    }

    public void deleteItem(int id){
        lostAndFoundDao.deleteById(id);
    }


}
