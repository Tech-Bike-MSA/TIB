package com.tukassemble.bike.domain.management.dto;

import com.tukassemble.bike.domain.management.domain.entity.Location;
import com.tukassemble.bike.domain.management.domain.entity.ModelType;
import com.tukassemble.bike.domain.management.domain.entity.UseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BikeRegisterRequest {

    @NotNull(message = "모델 타입은 필수 입력값입니다")
    ModelType modelType;

}
