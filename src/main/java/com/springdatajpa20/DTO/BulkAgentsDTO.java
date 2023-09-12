package com.springdatajpa20.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulkAgentsDTO {
    private List<AgentsDTO> agentsDTOS = new ArrayList<>();
}
