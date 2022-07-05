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
public class Lisence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateObtention;
    private LocalDateTime dateExpiration;
    private Integer nombreInscrit;
    @ManyToOne
    private versionLisence version;

}
