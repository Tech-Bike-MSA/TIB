package com.tukassemble.pay.domain.pay.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentRequest {
  @NotNull(message = "대여 ID는 필수 입력값 입니다.")
  private Long rentalId;

  @NotNull(message = "유저 ID는 필수 입력값 입니다.")
  private Long userId;

  @NotNull(message = "바이크 ID는 필수 입력값 입니다.")
  private Long bikeId;

  @NotNull(message = "대여 시간은 필수 입력값 입니다.")
  private LocalDateTime rentaledAt;

  @NotNull(message = "반환 시간은 필수 입력값 입니다.")
  private LocalDateTime returnedAt;
}
