package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PeriodsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long duration;

    private PeriodsType period;

    private String description;

    private Boolean status;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate updatedAt;
}
