package br.com.frigorificos.pedidos.api.entity;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    private UUID id = UUID.randomUUID();
    private String nome;
    private Double valor;
}
