package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.HealthServiceEntity;

public interface HealthServiceRepository extends JpaRepository<HealthServiceEntity, Long> {

}
