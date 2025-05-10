package br.com.fiap.voluta.controller;

import br.com.fiap.voluta.dto.LoginDTO;
import br.com.fiap.voluta.dto.LoginRespostaDTO;
import br.com.fiap.voluta.model.Usuario;
import br.com.fiap.voluta.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticar")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRespostaDTO> login(@Valid @RequestBody LoginDTO dto) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(dto.apelido(), dto.senha());
        var autenticacao = this.authenticationManager.authenticate(usuarioSenha);

        String token = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new LoginRespostaDTO(token));
    }
}
