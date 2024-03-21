package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.userStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private userStatus status;

    @ManyToOne
    private Role role;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private LocalDate updatedAt;

}
