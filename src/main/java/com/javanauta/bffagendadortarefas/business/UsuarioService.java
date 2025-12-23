package com.javanauta.bffagendadortarefas.business;

import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequets;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequets;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequets;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequets dto){

        return client.salvaUsuario(dto);
    }


    public String loginUsuario(LoginDTORequest dto){

        return client.login(dto);
    }


    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token){

        return client.buscaUsuarioPorEmail(email, token);
    }


    public void deletaUsuarioPorEmail(String email , String token){

        client.deleteUsuarioPorEmail(email, token);

    }


    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequets dto){

        return client.atualizaDadoUsuario(dto, token);
    }


    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequets dto, String token) {

        return client.atualizaEndereco(dto, idEndereco, token);
    }


    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequets dto, String token){

        return client.atualizaTelefone(dto, idTelefone, token);
    }


    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequets dto){

        return client.cadastroEndereco(dto, token);
    }


    public TelefoneDTOResponse cadastroTelefone(String token, TelefoneDTORequets dto){

        return client.cadastroTelefone(dto, token);
    }
}

