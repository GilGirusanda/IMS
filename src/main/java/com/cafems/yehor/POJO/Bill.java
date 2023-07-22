package com.cafems.yehor.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(name="Bill.getAllBills",
        query="SELECT b FROM Bill b ORDER BY b.id DESC")

@NamedQuery(name="Bill.getBillByUserName",
        query="SELECT b FROM Bill b WHERE b.createdBy=:currentUser ORDER BY b.id DESC")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="bill")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="bill_id_seq")
    @SequenceGenerator(name = "bill_id_seq", sequenceName = "bill_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name="uuid")
    private String uuid;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="contact_number")
    private String contactNumber;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="total")
    private Float total;

    @Column(name="product_details")
    private String productDetails;

    @Column(name="created_by")
    private String createdBy;

}
