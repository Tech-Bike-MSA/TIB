package com.tukassemble.pay.domain.pay.mapper;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import com.tukassemble.pay.domain.pay.dto.PaymentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentMapper {
  public Payment toEntity(
      PaymentRequest paymentRequest, Integer payAmount, Integer point, Boolean isPaid) {
    return Payment.builder()
        .rentalId(paymentRequest.getRentalId())
        .userId(paymentRequest.getUserId())
        .bikeId(paymentRequest.getBikeId())
        .payAmount(payAmount)
        .point(point)
        .isPaid(isPaid)
        .build();
  }
}
