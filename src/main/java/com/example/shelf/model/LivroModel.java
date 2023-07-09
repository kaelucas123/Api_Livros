package com.example.shelf.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "livros")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroModel implements Serializable {
        private static final long serialVersion = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String autor;
        private Date data_publicacao;
}
