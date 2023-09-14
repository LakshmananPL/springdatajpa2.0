package com.springdatajpa20.Controller;

import com.springdatajpa20.DTO.AgentsDTO;
import com.springdatajpa20.DTO.BulkAgentsDTO;
import com.springdatajpa20.DTO.BulkAgentsIdDTO;
import com.springdatajpa20.Entity.Agents;
import com.springdatajpa20.Exception.AgentsNotFoundException;
import com.springdatajpa20.Service.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springdatajpa20.Exception.AgentsAlreadyFoundException;

import java.util.List;

@RestController
public class AgentsController {

    @Autowired
    private AgentsService agentsService;

    @GetMapping("/getAllAgents")
    public ResponseEntity<List<AgentsDTO>> getAllAgents(){
        return agentsService.getAllAgents();
    }

    @GetMapping("/getAgents/{agentCode}")
    public ResponseEntity<AgentsDTO> getAgents(@PathVariable("agentCode") Integer agentCode ) throws AgentsNotFoundException
    {
        return agentsService.getAgents(agentCode);
    }

    @GetMapping("/getAllAgents/ByAgentCode")
    public ResponseEntity<List<AgentsDTO>> getAllAgentsByNames(@RequestBody BulkAgentsIdDTO bulkAgentsNamesDTO) throws AgentsNotFoundException
    {
        return agentsService.getAllByNamesAgents(bulkAgentsNamesDTO);
    }

    @GetMapping("/getAllAgents/{page}/{size}")
    public ResponseEntity<Page<AgentsDTO>> getAllAgentsByPagination(@PathVariable("page") Integer page,
                                                                 @PathVariable("size") Integer size) throws AgentsNotFoundException
    {
        return agentsService.getAllByPagination(page, size);
    }

    @GetMapping("/getAllAgents/{field}")
    public ResponseEntity<List<AgentsDTO>> getAllAgentsBySorting(@PathVariable("field") String field) throws AgentsNotFoundException
    {
        return agentsService.getAllBySorting(field);
    }

    @GetMapping("/getAllAgents/{page}/{size}/{field}")
    public ResponseEntity<Page<AgentsDTO>> getAllAgentsByPagingAndSorting(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size,
            @PathVariable("field") String field) throws AgentsNotFoundException
    {
        return agentsService.getAllByPagingAndSorting(page,size,field);
    }

    @GetMapping("/getAllAgents/OrderBy/{AgentName}")
    public ResponseEntity<List<AgentsDTO>> getAllAgentsByNamesAndOrderBy(@PathVariable("agentName") String agentName) throws AgentsNotFoundException
    {
        return agentsService.getAllByNamesAgentsAndOrderBy(agentName);
    }
    @GetMapping("/getAllAgents/ByCustomerName/{customerName}")
    public ResponseEntity<List<AgentsDTO>> getAllAgentsByCustomerName(@PathVariable("customerName") String customerName) throws AgentsNotFoundException
    {
        return agentsService.getAllByCustomerName(customerName);
    }

    @PostMapping("/saveAgents")
    public ResponseEntity<?> saveAgents(@RequestBody AgentsDTO agentsDTO) throws AgentsAlreadyFoundException {
        return agentsService.saveAgents(agentsDTO);
    }

    @PostMapping("/saveAllAgents")
    public ResponseEntity<?> saveAllAgents(@RequestBody BulkAgentsDTO agentsDTOs) throws AgentsAlreadyFoundException {
        return agentsService.saveAllAgents(agentsDTOs);
    }
}
