package com.tukassemble.bike.domain.management.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ModelType {
  GEAR_THREE("기어 3단"),
  GEAR_TWO("기어 2단"),
  GEAR_ONE("기어 1단"),
  ;

  private final String description;
}
