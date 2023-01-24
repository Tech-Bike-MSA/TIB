package com.tukassemble.user.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

  @KafkaListener(topics = "my-topic", groupId = "consumerGroupId")
  public void updateQty(String kafkaMessage) {
    log.info("Kafka Message: ->" + kafkaMessage);

    Map<Object, Object> map = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
      log.info(map.toString());
    } catch (JsonProcessingException ex) {
      ex.printStackTrace();
    }
  }
}
