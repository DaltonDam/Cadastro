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
    public UserModel criateUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    // Mostrar todos os usuários (READ)
    @GetMapping("/listar")
    public List<UserModel> listUsers() {
        return userService.listUsers();
    }

    //localhost
    // Procurar usuário por ID (READ)
    @GetMapping("/listar/{id}")
    public UserModel showAllUsersByID(@PathVariable Long id) {
        return userService.listUserByID(id);
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