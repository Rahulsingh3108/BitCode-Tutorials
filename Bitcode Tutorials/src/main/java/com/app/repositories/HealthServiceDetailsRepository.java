package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.HealthServiceDetails;
import com.app.pojos.HealthServiceEntity;

@Repository
public interface HealthServiceDetailsRepository extends JpaRepository<HealthServiceDetails, Long> {
	List<HealthServiceDetails> findAllByHealthServiceEntity(HealthServiceEntity healthServiceEntity);
}
