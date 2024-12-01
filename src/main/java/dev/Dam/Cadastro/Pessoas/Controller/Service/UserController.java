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
    public UserDTO criateUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    // Mostrar todos os usuários (READ)
    @GetMapping("/listar")
    public List<UserDTO> listUsers() {
        return userService.listUsers();
    }

    //localhost
    // Procurar usuário por ID (READ)
    @GetMapping("/listar/{id}")
    public UserDTO showAllUsersByID(@PathVariable Long id) {
        return userService.listUserByID(id);
    }

    // Alterar dados dos usuários (UPDATE)
    // Sempre que o usuario for passar uma variável, tem que isar chaves
    //E também o @PathVariable
    @PutMapping("/alterar/{id}")
    public UserDTO changeUsersByID(@PathVariable Long id, @RequestBody UserDTO updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // Deletar usuários (DELETE)
    //@PathVariable - Serve para colocar uma variávio que o usuário deseja inserir
    @DeleteMapping("/deletar/{id}")
    public void deleteUsersByID(@PathVariable Long id) {
        userService.deleteUsersByID(id);
    }

}