package com.tukassemble.rental.domain.rental.service;


import com.tukassemble.rental.domain.rental.domain.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalService {

  private final RentalRepository rentalRepository;
  private final BikeRepository bikeRepository;

  // 렌트와 동시에 bike의 상태를 고쳐준다
  public ResponseDto rentBike(RequestDto dto) {
    Bike bike = bikeRepository.findById(dto.getBikeId()).orElseThrow();

    if (!(bike.getUseStatus().name().equals(UseStatus.CAN_USE.name()))) {
      return ResponseDto.builder().msg("FAILED").build();
    }

    Rental newRental = Rental.builder().bike(bike).userId(dto.getUserId()).build();
    rentalRepository.save(newRental);
    bike.updateBike(UseStatus.IN_USE);
    bikeRepository.save(bike);

    return ResponseDto.builder().msg("SUCCESS").build();
  }

  // 결제를 동기적으로 결과를 받아서 결과에 따라서
  // user의 role을 바꿔준다. (동기적으로 처리)
  public ResponseDto returnBike(RequestDto dto) {

    Bike bike = bikeRepository.findById(dto.getBikeId()).orElseThrow();

    if (!(bike.getUseStatus().name().equals(UseStatus.IN_USE.name()))) {
      return ResponseDto.builder().msg("FAILED").build();
    }

    Rental newRental = Rental.builder().bike(bike).userId(dto.getUserId()).build();
    newRental.returnBike();
    rentalRepository.save(newRental);
    bike.updateBike(UseStatus.CAN_USE);
    bikeRepository.save(bike);

    // Pub/Sub Logic

    return ResponseDto.builder().msg("SUCCESS").build();
  }
}
