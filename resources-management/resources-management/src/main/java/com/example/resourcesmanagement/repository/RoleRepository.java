package com.example.resourcesmanagement.repository;

import com.example.resourcesmanagement.entity.ERole;
import com.example.resourcesmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByLibellé(ERole libelle);

}
