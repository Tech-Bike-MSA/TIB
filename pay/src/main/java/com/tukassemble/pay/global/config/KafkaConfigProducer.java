package com.tukassemble.pay.global.config;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfigProducer {
  @Value("${spring.kafka.producer.bootstrap-servers}")
  private String producerBootstrapServers;

  @Bean
  public Map<String, Object> kafkaProducerConfig() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerBootstrapServers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    return props;
  }

  @Bean
  public ProducerFactory<String, String> kafkaProducerFactory() {
    return new DefaultKafkaProducerFactory<>(kafkaProducerConfig());
  }

  @Bean
  public KafkaTemplate<String, String> kafkaProducerTemplate() {
    return new KafkaTemplate<>(kafkaProducerFactory());
  }
}
