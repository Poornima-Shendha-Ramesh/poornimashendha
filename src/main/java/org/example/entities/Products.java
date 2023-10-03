package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public   Long id;
    @Column(name="pname")
    public String pName;

    public String category;

    @Column(name="isavailable")
    public  boolean isAvailable;


}
