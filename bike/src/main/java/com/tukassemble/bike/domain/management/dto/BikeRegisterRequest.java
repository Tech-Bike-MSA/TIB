package com.tukassemble.bike.domain.management.dto;

import com.tukassemble.bike.domain.management.domain.entity.ModelType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BikeRegisterRequest {

  @NotNull(message = "모델 타입은 필수 입력값입니다")
  ModelType modelType;
}
