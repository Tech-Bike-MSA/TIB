package com.tukassemble.bike.domain.rental.domain.repository;

import com.tukassemble.bike.domain.rental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {}
