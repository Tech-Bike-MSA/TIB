package com.tukassemble.bike.domain.management.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tukassemble.bike.domain.management.domain.entity.Bike;
import com.tukassemble.bike.domain.management.domain.entity.Location;
import com.tukassemble.bike.domain.management.domain.entity.UseStatus;
import com.tukassemble.bike.domain.management.domain.repository.BikeRepository;
import com.tukassemble.bike.domain.management.dto.BikeInfo;
import com.tukassemble.bike.domain.management.dto.BikeRegisterRequest;
import com.tukassemble.bike.domain.management.dto.mapper.BikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BikeManageService {

  private final BikeRepository bikeRepository;
  private final BikeMapper bikeMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public BikeInfo register(BikeRegisterRequest bikeRegisterRequest) {

    Bike newBike =
        Bike.builder()
            .useStatus(UseStatus.CAN_USE)
            .modelType(bikeRegisterRequest.getModelType())
            .location(new Location(0.0, 0.0))
            .build();
    Bike savedBike = bikeRepository.save(newBike);
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = "";
    try {
      jsonInString = mapper.writeValueAsString(bikeMapper.mapToBikeInfo(savedBike));
    } catch (JsonProcessingException ex) {
      ex.printStackTrace();
    }

    kafkaTemplate.send("my-topic", jsonInString);
    return bikeMapper.mapToBikeInfo(savedBike);
  }
}
