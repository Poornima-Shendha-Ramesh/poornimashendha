package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="customer_id")
   public Long custId;

   @Column(name="customer_name")
    public String name;

    @Column(name="contact_number")
    public String contactNumber;

    @Column(name="email_id")
    public String emailId;

@OneToMany(mappedBy = "customer")
    public  List<Orders> ordersList;


}
