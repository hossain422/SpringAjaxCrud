package com.example.OnePage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<PageModel, Integer> {
    List<PageModel> findAllByOrderByIdDesc();
}
