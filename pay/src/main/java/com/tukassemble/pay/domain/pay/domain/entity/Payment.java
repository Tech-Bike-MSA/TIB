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

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "rental_id", nullable = false)
  private Long rentalId;

  @Column(name = "pay_amount", nullable = false)
  private Long payAmount;

  @Enumerated(EnumType.STRING)
  @Column(name = "payment_status", nullable = false)
  private PaymentStatus paymentStatus;

  @Builder
  public Payment(Long userId, Long rentalId, Long payAmount, PaymentStatus paymentStatus) {
    this.userId = userId;
    this.rentalId = rentalId;
    this.payAmount = payAmount;
    this.paymentStatus = paymentStatus;
  }
}
