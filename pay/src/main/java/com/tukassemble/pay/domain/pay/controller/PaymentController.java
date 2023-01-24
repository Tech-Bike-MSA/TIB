package com.tukassemble.pay.domain.pay.controller;

import com.tukassemble.pay.domain.pay.dto.PaymentRequest;
import com.tukassemble.pay.domain.pay.dto.PaymentResult;
import com.tukassemble.pay.domain.pay.service.PaymentService;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/pay")
public class PaymentController {
  private final PaymentService paymentService;

  @PostMapping
  public ResponseEntity<PaymentResult> pay(@Valid @RequestBody PaymentRequest paymentRequest) {
    PaymentResult paymentResult = paymentService.pay(paymentRequest);
    // Bike State Change Message Pub 하는 코드 추가 하기
    return ResponseEntity.ok(paymentResult);
  }
}
