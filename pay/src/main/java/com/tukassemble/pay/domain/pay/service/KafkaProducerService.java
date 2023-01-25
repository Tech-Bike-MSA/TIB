package com.tukassemble.pay.domain.pay.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class KafkaProducerService {
  private final KafkaTemplate<String, String> kafkaProducerTemplate;

  public void sendMessage(String topic, String message) {
    ListenableFuture<SendResult<String, String>> sendResult =
        kafkaProducerTemplate.send(topic, message);
    sendResult.addCallback(
        new ListenableFutureCallback<>() {
          @Override
          public void onSuccess(SendResult<String, String> result) {
            log.info(
                "successfully sent a message {} with offset {}",
                message,
                result.getRecordMetadata().offset());
          }

          @Override
          public void onFailure(Throwable ex) {
            log.error("fail to send a message {} because of {}", message, ex.getMessage());
            throw new MessagingException("fail to send a message", ex);
          }
        });
  }
}
