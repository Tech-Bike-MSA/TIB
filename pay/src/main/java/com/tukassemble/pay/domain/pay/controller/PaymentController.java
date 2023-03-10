package com.tukassemble.pay.domain.pay.controller;

import com.tukassemble.pay.domain.pay.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/pay")
public class PaymentController {
  private final PaymentService paymentService;

  //  @PostMapping
  //  public ResponseEntity<PaymentResult> pay(@Valid @RequestBody PaymentRequest paymentRequest) {
  //    PaymentResult paymentResult = paymentService.pay(paymentRequest);
  //    return ResponseEntity.ok(paymentResult);
  //  }
}
