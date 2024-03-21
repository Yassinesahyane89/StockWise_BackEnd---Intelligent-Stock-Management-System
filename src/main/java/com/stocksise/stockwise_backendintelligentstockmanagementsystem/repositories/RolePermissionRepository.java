package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
