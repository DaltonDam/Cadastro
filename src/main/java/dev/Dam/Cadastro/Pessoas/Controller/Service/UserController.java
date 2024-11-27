package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Esta é a primeira mensagem nessa rota";
    }

    // Adicionar usuário (CREATE)
    @PostMapping("/criar")
    public String criateUser() {
        return "Usuário criado";
    }

    // Mostrar todos os usuários (READ)
    @GetMapping("/listar")
    public String showAllUsers() {
        return "Mostrar usuário";
    }

    // Procurar usuário por ID (READ)
    @GetMapping("/listarID")
    public String showAllUsersByID() {
        return "Mostrar usuário por id";
    }

    // Alterar dados dos usuários (UPDATE)
    @PutMapping("/alterarID")
    public String changeUsersByID() {
        return "Alterar usuário por id";
    }

    // Deletar usuários (DELETE)
    @DeleteMapping("/deletarID")
    public String deleteUsersByID() {
        return "Usuário deletado  por id";
    }

}