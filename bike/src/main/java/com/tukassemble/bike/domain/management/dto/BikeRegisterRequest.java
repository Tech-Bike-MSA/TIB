package com.tukassemble.bike.domain.management.dto;

import com.tukassemble.bike.domain.management.domain.entity.Location;
import com.tukassemble.bike.domain.management.domain.entity.ModelType;
import com.tukassemble.bike.domain.management.domain.entity.UseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BikeRegisterRequest {

    ModelType modelType;
    UseStatus useStatus;
    Location location;
}
