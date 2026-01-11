package com.AbAmAk.Pompa.entity;

import com.AbAmAk.Pompa.entity.enums.TrainerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "trainer_data")
public class TrainerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", unique = true, nullable = false)
    private AppUser appUser;

    @Column(name = "type", nullable = false)
    private TrainerType type;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "rating", nullable = false)
    @Min(value = 1)
    @Max(value = 5)
    private Integer rating;

    @Column(name = "ratingDesc")
    private String ratingDesc;
}