package com.tukassemble.pay.domain.pay.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum PaymentStatus {
  SUCCESS("결제 성공"),
  FAILURE("결제 실패"),
  ;

  private final String description;
}
