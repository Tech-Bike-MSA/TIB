package com.tukassemble.pay.domain.pay.mapper;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import com.tukassemble.pay.domain.pay.domain.entity.PaymentStatus;
import com.tukassemble.pay.domain.pay.dto.PaymentRequest;
import com.tukassemble.pay.domain.pay.dto.PaymentResult;

public class PaymentMapper {

  public Payment toEntity(
      PaymentRequest paymentRequest, Long payAmount, PaymentStatus paymentStatus) {
    return Payment.builder()
        .userId(paymentRequest.getUserId())
        .rentalId(paymentRequest.getRentalId())
        .payAmount(payAmount)
        .paymentStatus(paymentStatus)
        .build();
  }

  public PaymentResult toDto(Payment payment) {
    return PaymentResult.builder()
        .id(payment.getId())
        .userId(payment.getUserId())
        .rentalId(payment.getRentalId())
        .payAmount(payment.getPayAmount())
        .paymentStatus(payment.getPaymentStatus())
        .build();
  }
}
