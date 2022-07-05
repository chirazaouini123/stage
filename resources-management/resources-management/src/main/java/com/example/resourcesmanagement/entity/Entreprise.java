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

public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String domaine;
    private Integer nombreEmployee;
    private String addresse;
    private String siteWeb;
    private String contact;
    private  String email;
    @ManyToOne
    private DomaineEntreprise domaineEntreprise;




}
