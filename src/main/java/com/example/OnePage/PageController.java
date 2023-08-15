package com.example.OnePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @Autowired
    PageService service;
    @Autowired
    PageRepository repo;

    @GetMapping("students")
    public String index(Model model){
        model.addAttribute("data_list", service.getAllData());
        return "index";
    }
    @PostMapping("store_data")
    public ResponseEntity<String> store_data(@ModelAttribute PageModel data){
        repo.save(data);
        return ResponseEntity.ok("Data inserted successfully");
//        return "redirect:/students";
    }
    @RequestMapping("delete_data/{id}")
    public ResponseEntity<String> delete_student(@PathVariable("id") int id){
        repo.deleteById(id);
        return ResponseEntity.ok("Data Deleted successfully");
//        return "redirect:/students";
    }
}
