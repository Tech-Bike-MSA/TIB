package com.tukassemble.bike.domain.management.dto;


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
public class BikeInfo {
    private String serialCode;
    private ModelType modelType;
    private UseStatus useStatus;
}
