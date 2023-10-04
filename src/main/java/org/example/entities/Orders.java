package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Join;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="orders_id")
  public Long orderId;

@ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="customer_id")
  public Customer customer;

@ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="product_id")
  public Products products;


}
