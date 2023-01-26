package com.github.dev.inventory.repository;

import com.github.dev.inventory.entity.Conveyor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConveyorRepository extends JpaRepository<Conveyor, UUID> { }
