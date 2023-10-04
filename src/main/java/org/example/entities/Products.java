package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    public   Long productId;

    @Column(name="product_name")
    public String pName;

    public String category;

    @Column(name="is_available")
    public  boolean isAvailable;

    public int cost;


@OneToMany(mappedBy = "products")
    public List<Orders> ordersList;

}
