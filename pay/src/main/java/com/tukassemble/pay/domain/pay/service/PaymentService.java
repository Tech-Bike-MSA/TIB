package com.tukassemble.pay.domain.pay.service;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import com.tukassemble.pay.domain.pay.domain.entity.PaymentStatus;
import com.tukassemble.pay.domain.pay.domain.repository.PaymentRepository;
import com.tukassemble.pay.domain.pay.dto.PaymentRequest;
import com.tukassemble.pay.domain.pay.dto.PaymentResult;
import com.tukassemble.pay.domain.pay.mapper.PaymentMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final PaymentMapper paymentMapper;
  private final KafkaProducerService kafkaProducerService;

  private final Long costPerMin = 100L;
  private static final String PAYMENT_RESULT_TOPIC = "paymentResult";

  public PaymentResult pay(PaymentRequest paymentRequest) {
    Long paymentAmount = getPaymentAmountByUseTime(paymentRequest.getUseTime());
    Boolean isPaymentSuccess = tryPay(paymentRequest.getUserId(), paymentAmount);
    PaymentStatus paymentStatus = getPaymentStatus(isPaymentSuccess);
    Payment payment = paymentMapper.toEntity(paymentRequest, paymentAmount, paymentStatus);
    paymentRepository.save(payment);

    // 임시로 일단 결제 성공, 실패 여부만 전송
    kafkaProducerService.sendMessage(PAYMENT_RESULT_TOPIC, paymentStatus.getDescription());
    return paymentMapper.toDto(payment);
  }

  private Boolean tryPay(Long userId, Long paymentAmount) {
    // 실제 결제 모듈이 있다면 여기서 결제, 결제 성공 시 true, 실패 시 false
    Boolean isPaymentSuccess = true;
    return isPaymentSuccess;
  }

  private PaymentStatus getPaymentStatus(Boolean isPaymentSuccess) {
    if (isPaymentSuccess) return PaymentStatus.SUCCESS;
    return PaymentStatus.FAILURE;
  }

  private Long getPaymentAmountByUseTime(Long useTime) {
    return useTime * costPerMin;
  }
}
