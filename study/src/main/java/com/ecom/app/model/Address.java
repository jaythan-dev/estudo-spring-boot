package com.ecom.app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Addresses_table")
@Data
@NoArgsConstructor
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String cidade;
    private String estado;
    private String pais;
    private String codigo_postal;
}
