package com.springdatajpa20.DTO;

import com.springdatajpa20.Entity.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentsDTO {

    private String agentName;
    private String workingArea;
    private double commission;
    private String phoneNo;
    private String country;

    private String email;
    private List<Customers> customersList = new ArrayList<>();
}
