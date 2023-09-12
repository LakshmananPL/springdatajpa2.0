package com.springdatajpa20.Repository;

import com.springdatajpa20.Entity.Agents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgentsRepository extends JpaRepository<Agents, Integer> {
    boolean existsByEmail(String email);
    Optional<Agents> findByAgentCode(Integer agentCode);
    //List<Agents> findAllByAgentCode(List<Integer> agentsCode);
    //List<Agents> findAllByAgentName(List<Integer> agentCode);
}
