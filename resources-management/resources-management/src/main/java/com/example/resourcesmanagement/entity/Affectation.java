package com.example.resourcesmanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table
@Data
@Getter
@Setter
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    @ManyToOne
    Resources resources;
    @ManyToOne
    Projet projet;
}
