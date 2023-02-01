package com.tukassemble.pay.domain.pay.domain.entity;

import com.tukassemble.pay.global.domain.BaseTimeEntity;
import javax.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "payment")
public class Payment extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "rental_id", nullable = false)
  private Long rentalId;

  @Column(name = "bike_id", nullable = false)
  private Long bikeId;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "pay_amount", nullable = false)
  private Integer payAmount;

  @Column(name = "is_paid", nullable = false)
  private Boolean isPaid;

  @Column(nullable = false)
  private Integer point;

  @Builder
  public Payment(Long rentalId, Long bikeId, Integer payAmount, Boolean isPaid, Long userId, Integer point) {
    this.rentalId = rentalId;
    this.bikeId = bikeId;
    this.payAmount = payAmount;
    this.isPaid = isPaid;
    this.userId = userId;
    this.point = point;
  }
}
