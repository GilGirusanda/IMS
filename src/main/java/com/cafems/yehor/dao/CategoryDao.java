package com.cafems.yehor.dao;

import com.cafems.yehor.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    List<Category> getAllCategory();

}
