package com.tukassemble.bike.domain.rental.domain.entity;

import com.tukassemble.bike.domain.management.domain.entity.Bike;
import com.tukassemble.bike.global.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "rental")
public class Rental extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Bike bike;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "rental_status", nullable = false)
    private RentalStatus rentalStatus;

    @Builder
    public Rental(Bike bike, Long userId, RentalStatus rentalStatus) {
        this.bike = bike;
        this.userId = userId;
        this.rentalStatus = rentalStatus;
    }
}