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
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libell√©;
    private String allocateur;
    private String disponibilit√©;
    @ManyToOne
    private TypeResource typeResource;
}
