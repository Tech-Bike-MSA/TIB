package com.tukassemble.bike.domain.management.controller;

import com.tukassemble.bike.domain.management.dto.BikeInfo;
import com.tukassemble.bike.domain.management.dto.BikeRegisterRequest;
import com.tukassemble.bike.domain.management.service.BikeManageService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bike")
public class BikeManageController {

  private final BikeManageService bikeManageService;

  @PostMapping
  public ResponseEntity<BikeInfo> register(@Valid @RequestBody BikeRegisterRequest request) {
    BikeInfo bikeInfo = bikeManageService.register(request);

    return ResponseEntity.ok().body(bikeInfo);
  }
}
