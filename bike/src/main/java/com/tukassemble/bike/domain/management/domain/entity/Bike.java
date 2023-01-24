package com.tukassemble.bike.domain.management.domain.entity;

import com.tukassemble.bike.global.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "bike")
public class Bike extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "serial_code", nullable = false)
    private String serialCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "model_type", nullable = false)
    private ModelType modelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "use_status", nullable = false)
    private UseStatus useStatus;

    @Embedded
    private Location location;

    @Builder
    public Bike(ModelType modelType, UseStatus useStatus, Location location) {
        this.serialCode = String.valueOf(UUID.randomUUID());
        this.modelType = modelType;
        this.useStatus = useStatus;
        this.location = location;
    }
}
