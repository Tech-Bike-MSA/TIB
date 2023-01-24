package com.tukassemble.pay.domain.pay.dto;

import javax.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentRequest {
  @NotNull(message = "유저 ID는 필수 입력값 입니다.")
  private Long userId;

  @NotNull(message = "렌탈 ID는 필수 입력값 입니다.")
  private Long rentalId;

  @NotNull(message = "사용 시간은 필수 입력값 입니다.")
  private Long useTime;
}
