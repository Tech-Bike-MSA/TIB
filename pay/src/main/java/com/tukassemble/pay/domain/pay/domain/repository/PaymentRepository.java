package com.tukassemble.pay.domain.pay.domain.repository;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
