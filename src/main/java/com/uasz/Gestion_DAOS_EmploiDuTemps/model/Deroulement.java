package com.uasz.Gestion_DAOS_EmploiDuTemps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deroulement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String objectifs;
    // private Date date;
    @Column(length = 500)
    private String description;
    @OneToOne
    private Seance seance;
}
