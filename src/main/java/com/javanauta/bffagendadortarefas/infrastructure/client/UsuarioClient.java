package com.javanauta.bffagendadortarefas.infrastructure.client;


import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequets;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequets;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequets;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient (name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader(value = "Authorization", required = false) String token);


    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequets dto);


    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest dto);


    @DeleteMapping("/{email}")
    void deleteUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required = false) String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadoUsuario(@RequestBody UsuarioDTORequets dto,
                                           @RequestHeader(value = "Authorization", required = false) String token);


    @PutMapping("endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequets dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required = false) String token);


    @PutMapping("telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequets dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required = false) String token);


    @PostMapping("endereco")
    EnderecoDTOResponse cadastroEndereco(@RequestBody EnderecoDTORequets dto,
                                         @RequestHeader(value = "Authorization", required = false) String token);


    @PostMapping("telefone")
    TelefoneDTOResponse cadastroTelefone(@RequestBody TelefoneDTORequets dto,
                                         @RequestHeader(value = "Authorization", required = false) String token);
}
