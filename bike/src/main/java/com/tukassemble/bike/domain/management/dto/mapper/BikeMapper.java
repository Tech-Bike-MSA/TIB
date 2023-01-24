package com.tukassemble.bike.domain.management.dto.mapper;

import com.tukassemble.bike.domain.management.domain.entity.Bike;
import com.tukassemble.bike.domain.management.dto.BikeInfo;
import org.springframework.stereotype.Component;

@Component
public class BikeMapper {

  public BikeInfo mapToBikeInfo(Bike newBike) {
    return BikeInfo.builder()
        .serialCode(newBike.getSerialCode())
        .useStatus(newBike.getUseStatus())
        .modelType(newBike.getModelType())
        .build();
  }
}
