package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PermissionEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionCategory;

    @Enumerated(EnumType.STRING)
    private PermissionEnum name;

    @OneToMany(mappedBy = "permission")
    private List<RolePermission> rolePermissions;
}
