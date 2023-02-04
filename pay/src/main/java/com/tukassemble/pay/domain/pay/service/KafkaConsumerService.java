package com.tukassemble.pay.domain.pay.service;

import com.tukassemble.pay.domain.pay.domain.entity.Payment;
import com.tukassemble.pay.domain.pay.dto.PaymentMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
  private final PaymentService paymentService;

  @KafkaListener(
      groupId = "${spring.kafka.consumer.group-id}",
      topics = "${spring.kafka.topic.name}")
  public void pay(PaymentMessage paymentMessage) {
    Payment paymentResult = paymentService.pay(paymentMessage);
    if (paymentResult.getIsPaid()) {
      // point 적립 message pub 넣기
      // kafkaProducerService.sendMessage(POINT_EARN_TOPIC, pointMessage);
      log.info("point earn message pub");
    }
  }
}
