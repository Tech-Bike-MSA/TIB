package com.tukassemble.rental.domain.rental.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

  @NotNull private Long userId;

  @NotNull private Long bikeId;
}
