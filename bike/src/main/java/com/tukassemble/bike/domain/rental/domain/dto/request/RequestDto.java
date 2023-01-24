package com.tukassemble.bike.domain.rental.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

  @NotNull private Long userId;

  @NotNull private Long bikeId;
}
