package com.example.OnePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {
    @Autowired
    PageRepository repo;

    public List<PageModel> getAllData(){
        ArrayList<PageModel> dataList = new ArrayList<>();
        repo.findAllByOrderByIdDesc().forEach(data ->dataList.add(data));
        return dataList;
    }
    public PageModel edit_data(int id){
       return repo.findById(id).get();
    }
}
