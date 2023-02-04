package com.tukassemble.pay.domain.pay.controller;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import com.tukassemble.pay.domain.pay.dto.PaymentMessage;
import com.tukassemble.pay.domain.pay.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/pay")
public class PaymentController {
  private final PaymentService paymentService;

  // pay 의 기능을 임시로 사용 해보기 위한 API
  @PostMapping
  public ResponseEntity<Payment> pay(@Valid @RequestBody PaymentMessage paymentMessage) {
    Payment paymentResult = paymentService.pay(paymentMessage);
    return ResponseEntity.ok(paymentResult);
  }
}
