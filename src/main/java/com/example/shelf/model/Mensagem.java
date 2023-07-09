package com.example.shelf.model;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem{
    private String mensagem;
    private Object object;
}
