package com.tukassemble.pay.domain.pay.service;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import com.tukassemble.pay.domain.pay.domain.repository.PaymentRepository;
import com.tukassemble.pay.domain.pay.dto.PaymentMessage;
import com.tukassemble.pay.domain.pay.mapper.PaymentMapper;
import java.time.Duration;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final PaymentMapper paymentMapper;

  private final Integer COST_PER_MIN = 100;
  private final Float POINT_PERCENTAGE = 0.01f;

  public Payment pay(PaymentMessage paymentMessage) {
    Integer paymentAmount =
        getPaymentAmountByUseTime(paymentMessage.getRentaledAt(), paymentMessage.getReturnedAt());
    Boolean isPaymentSuccess = tryPay(paymentMessage.getUserId(), paymentAmount);
    Integer earnedPoint = getEarnedPoint(paymentAmount, isPaymentSuccess);
    Payment payment =
        paymentMapper.toEntity(paymentMessage, paymentAmount, earnedPoint, isPaymentSuccess);
    paymentRepository.save(payment);
    return payment;
  }

  private Boolean tryPay(Long userId, Integer paymentAmount) {
    // 실제 결제 모듈이 있다면 여기서 결제, 결제 성공 시 true, 실패 시 false
    // 임시로 10% 확률로 결제 실패 하도록 설정
    Boolean isPaymentSuccess = Math.random() >= 0.1f;
    return isPaymentSuccess;
  }

  private Integer getEarnedPoint(Integer paymentAmount, Boolean isPaymentSuccess) {
    if (isPaymentSuccess) return Math.round(paymentAmount * POINT_PERCENTAGE);
    return 0;
  }

  private Integer getPaymentAmountByUseTime(LocalDateTime rentaledAt, LocalDateTime returnedAt) {
    Duration diff = Duration.between(rentaledAt, returnedAt);
    return (int) Math.ceil(diff.toMinutes() * COST_PER_MIN);
  }
}
