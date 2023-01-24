package com.tukassemble.bike.domain.management.service;

import com.tukassemble.bike.domain.management.domain.entity.Bike;
import com.tukassemble.bike.domain.management.domain.entity.Location;
import com.tukassemble.bike.domain.management.domain.entity.UseStatus;
import com.tukassemble.bike.domain.management.domain.repository.BikeRepository;
import com.tukassemble.bike.domain.management.dto.BikeRegisterRequest;
import com.tukassemble.bike.domain.management.dto.BikeInfo;
import com.tukassemble.bike.domain.management.dto.mapper.BikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BikeManageService {

  private final BikeRepository bikeRepository;
  private final BikeMapper bikeMapper;

  public BikeInfo register(BikeRegisterRequest bikeRegisterRequest) {

    Bike newBike =
        Bike.builder()
            .useStatus(UseStatus.CAN_USE)
            .modelType(bikeRegisterRequest.getModelType())
            .location(new Location(0.0, 0.0))
            .build();
    Bike savedBike = bikeRepository.save(newBike);

    return bikeMapper.mapToBikeInfo(savedBike);
  }
}
