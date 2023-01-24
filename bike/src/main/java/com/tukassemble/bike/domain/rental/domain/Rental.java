package com.tukassemble.bike.domain.rental.domain;

import com.sun.istack.NotNull;
import com.tukassemble.bike.global.domain.BaseTimeEntity;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rental extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //    @NotNull
  //    @OneToOne
  //    private Bike bike;

  @NotNull private Long userId;
}
