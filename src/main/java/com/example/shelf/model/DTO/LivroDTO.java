package com.example.shelf.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {
    private Long id;
    private String nome;
    private String autor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_publicacao;
}
