    package com.uasz.Gestion_DAOS.model.Maquette;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EC {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String libelle;
        private String Code;
        private int cm;
        private int td;
        private int tp;
        private int tpe;
        
        private int coefficient;
        private String description;
        private Date dateCreation;
        
        @ManyToOne
        private UE ue;

        
        @OneToMany(mappedBy = "ec")
        private List<Module> module;

    }
