package com.springdatajpa20.Service;

import com.springdatajpa20.DTO.AgentsDTO;
import com.springdatajpa20.DTO.BulkAgentsDTO;
import com.springdatajpa20.DTO.BulkAgentsIdDTO;
import com.springdatajpa20.Entity.Agents;
import com.springdatajpa20.Exception.AgentsNotFoundException;
import com.springdatajpa20.Repository.AgentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springdatajpa20.Exception.AgentsAlreadyFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgentsService {

    @Autowired
    private AgentsRepository agentsRepository;

    @Autowired
    private ModelMapper modelMapper;
    public ResponseEntity<List<AgentsDTO>> getAllAgents() {
        List<Agents> agents = agentsRepository.findAll();
        List<AgentsDTO> agentsDTOS = agents
                .stream()
                .map(Agents -> modelMapper.map(Agents, AgentsDTO.class))
                .collect(Collectors.toList());
        /*for (Agents a: agents){
            agentsDTOS.add(modelMapper.map(a, AgentsDTO.class));
        }*/
        return new ResponseEntity<>(agentsDTOS,HttpStatus.OK);
    }

    public ResponseEntity<?> saveAgents(AgentsDTO agentsDTO) throws AgentsAlreadyFoundException {
        if(agentsRepository.existsByEmail(agentsDTO.getEmail())){
            throw new AgentsAlreadyFoundException("agent already registered!!!");
        }else {
            Agents agents = modelMapper.map(agentsDTO, Agents.class);
            agentsRepository.save(agents);
            return new ResponseEntity<>(agents, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> saveAllAgents(BulkAgentsDTO agentsDTOs) {

            List<Agents> agents = agentsDTOs
                    .getAgentsDTOS()
                    .stream()
                    .map(agentsDTO1 -> modelMapper.map(agentsDTO1, Agents.class))
                    .toList();
            agentsRepository.saveAll(agents);

            return new ResponseEntity<>(agents, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<AgentsDTO> getAgents(Integer agentCode) throws AgentsNotFoundException {
        Optional<Agents> agents = agentsRepository.findByAgentCode(agentCode);
        if(agents.isPresent()) {
            AgentsDTO agentsDTO = modelMapper.map(agents.get(), AgentsDTO.class);
            return new ResponseEntity<>(agentsDTO, HttpStatus.OK);
        }else {
            throw new AgentsNotFoundException("Agents detail not available");
        }
    }

    public ResponseEntity<List<AgentsDTO>> getAllByNamesAgents(BulkAgentsIdDTO bulkAgentsIdDTO) {
        List<Agents> agents = agentsRepository.findAllById(bulkAgentsIdDTO.getAgentsCode());

        List<AgentsDTO> agentsDTOS = agents
                .stream()
                .map(agents1 -> modelMapper.map(agents1, AgentsDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(agentsDTOS, HttpStatus.OK);
    }
}
