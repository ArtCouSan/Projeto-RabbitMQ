package br.com.microservice_b.endpoint.repository;

import br.com.microservice_b.endpoint.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {

    public List<Drone> findByRastreandoIsTrue();

}
