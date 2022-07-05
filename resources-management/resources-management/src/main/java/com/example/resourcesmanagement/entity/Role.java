package com.example.resourcesmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @Enumerated(EnumType.STRING)
    private ERole libellé;
}
