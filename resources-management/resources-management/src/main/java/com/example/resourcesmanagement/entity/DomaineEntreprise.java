package com.example.resourcesmanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Data
@Getter
@Setter
public class DomaineEntreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libellé;
}
