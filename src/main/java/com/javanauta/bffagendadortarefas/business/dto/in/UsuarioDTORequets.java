package com.javanauta.bffagendadortarefas.business.dto.in;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequets {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTORequets> enderecos;
    private List<TelefoneDTORequets> telefones;
}


