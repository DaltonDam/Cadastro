package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //para dizer que é a camada controller
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
    public List<UserModel> listUsers() {
        return userService.listUsers();
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