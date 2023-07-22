package com.cafems.yehor.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWrapper {

    Integer id;
    String name;
    String description;
    Boolean status;
    Float price;
    Integer categoryId;
    String categoryName;

    public ProductWrapper(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public ProductWrapper(Integer id, String name, String description, Float price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
