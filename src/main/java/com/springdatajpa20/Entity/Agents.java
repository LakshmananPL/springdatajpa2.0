package com.springdatajpa20.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer agentCode;

    @Column(name = "agent_name")
    private String agentName;
    private String workingArea;
    private double commission;
    private String phoneNo;
    private String country;

    //@Id
    private String email;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Customers.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_code_fk" , referencedColumnName = "agentCode")
    private List<Customers> customersList;

}

