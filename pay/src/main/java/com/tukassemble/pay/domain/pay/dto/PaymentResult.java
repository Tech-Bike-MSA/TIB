package com.tukassemble.pay.domain.pay.dto;

import com.tukassemble.pay.domain.pay.domain.entity.PaymentStatus;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResult {
    private Long id;
    private Long userId;
    private Long rentalId;
    private Long payAmount;
    private PaymentStatus paymentStatus;
}
