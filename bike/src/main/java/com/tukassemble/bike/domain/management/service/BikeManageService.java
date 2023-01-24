package com.tukassemble.bike.domain.management.service;


import com.tukassemble.bike.domain.management.domain.entity.Bike;
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

        Bike newBike = Bike.builder()
                .useStatus(bikeRegisterRequest.getUseStatus())
                .modelType(bikeRegisterRequest.getModelType())
                .location(bikeRegisterRequest.getLocation())
                .build();
        bikeRepository.save(newBike);

        return bikeMapper.mapToBikeInfo(newBike);
    }


}
