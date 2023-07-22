package com.cafems.yehor.dao;

import com.cafems.yehor.POJO.Product;
import com.cafems.yehor.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    List<ProductWrapper> getAllProduct();

    List<ProductWrapper> getProductByCategory(Integer id);

    @Modifying
    @Transactional
    void updateProductStatus(@Param("status") Boolean status, @Param("id") Integer id);

    ProductWrapper getProductById(Integer id);

}
