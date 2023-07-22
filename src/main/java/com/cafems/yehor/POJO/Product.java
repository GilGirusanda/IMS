package com.cafems.yehor.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(name="Product.getAllProduct",
        query="SELECT new com.cafems.yehor.wrapper.ProductWrapper(p.id, p.name, p.description,  p.status, p.price, p.category.id, p.category.name) FROM Product p")

@NamedQuery(name="Product.updateProductStatus",
        query="UPDATE Product p SET p.status=:status WHERE p.id=:id")

@NamedQuery(name="Product.getProductByCategory",
        query="SELECT new com.cafems.yehor.wrapper.ProductWrapper(p.id, p.name) FROM Product p WHERE p.category.id=:id AND p.status=true")

@NamedQuery(name="Product.getProductById",
        query="SELECT new com.cafems.yehor.wrapper.ProductWrapper(p.id, p.name, p.description, p.price) FROM Product p WHERE p.id=:id")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="product")
public class Product implements Serializable {

    private static final long serialVersionUID = 123456L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_fk", nullable = false)
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "status")
    private Boolean status;

}
