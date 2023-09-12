package com.springdatajpa20.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerCode;
    private String customerName;
    private String customerCity;
    private String workingArea;
    private Integer grade;
    private double openingAmt;
    private double receiveAmt;
    private double paymentAmt;
    private double outstandingAmt;
    private String phoneNo;

}