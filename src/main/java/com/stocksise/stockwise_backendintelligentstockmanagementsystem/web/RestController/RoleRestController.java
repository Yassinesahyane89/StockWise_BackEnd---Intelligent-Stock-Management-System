package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.RoleWithPermissionRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.RoleResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.RoleWithPermissionV1ResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleRestController {
    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    // get all roles
    @GetMapping("/all")
    public ResponseEntity<?> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        if(roles.isEmpty()) {
            return ResponseMessage.notFound("No role found");
        }else {
            List<RoleResponseDTO> roleResponseDTOS = new ArrayList<>();
            for(Role role : roles) {
                roleResponseDTOS.add(RoleResponseDTO.fromRole(role));
            }
            return ResponseMessage.ok(roleResponseDTOS, "Success");
        }
    }

    // get role by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id) {
        return ResponseMessage.ok(RoleWithPermissionV1ResponseDTO.fromRole(roleService.getRoleById(id)), "Success");
    }

    // add role
    @PostMapping("/new-role")
    public ResponseEntity<?> addRole(@RequestBody RoleWithPermissionRequestDTO role) {
        return ResponseMessage.created(RoleWithPermissionV1ResponseDTO.fromRole(roleService.addRole(role)), "Role added successfully");
    }

    // update role
    @PutMapping("/update-role/{id}")
    public ResponseEntity<?> updateRole(@RequestBody RoleWithPermissionRequestDTO role, @PathVariable Long id) {
        Role updatedRole = roleService.updateRole(role, id);
        return ResponseMessage.ok(RoleWithPermissionV1ResponseDTO.fromRole(updatedRole), "Role updated successfully");
    }

    // delete role
    @DeleteMapping("/delete-role/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseMessage.ok(null,"Role deleted successfully");
    }

    // get all permissions
    @GetMapping("/permissions")
    public ResponseEntity<?> getAllPermissions() {
        return ResponseMessage.ok(roleService.getAllPermissions(), "Success");
    }
}
