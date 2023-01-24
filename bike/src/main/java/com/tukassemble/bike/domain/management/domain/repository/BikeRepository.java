package com.tukassemble.bike.domain.management.domain.repository;

import com.tukassemble.bike.domain.management.domain.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {}
