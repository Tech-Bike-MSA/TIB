package com.tukassemble.pay.global.config;

import com.tukassemble.pay.domain.pay.dto.PaymentMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConfigConsumer {
  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private String consumerBootstrapServers;

  @Value("${spring.kafka.consumer.group-id}")
  private String consumerGroupId;

  @Bean
  public Map<String, Object> consumerConfig() {
    Map<String, Object> properties = new HashMap<>();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerBootstrapServers);
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
    return properties;
  }

  @Bean
  public ConsumerFactory<String, PaymentMessage> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(
        consumerConfig(),
        new ErrorHandlingDeserializer<>(new StringDeserializer()),
        new ErrorHandlingDeserializer<>(new JsonDeserializer<>(PaymentMessage.class)));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, PaymentMessage>
      kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, PaymentMessage> kafkaListenerContainerFactory =
        new ConcurrentKafkaListenerContainerFactory<>();
    kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
    return kafkaListenerContainerFactory;
  }
}
