package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //para dizer que é a camada controller
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Esta é a primeira mensagem nessa rota";
    }

    // Adicionar usuário (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        UserDTO newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: " + newUser.getName() + " (ID): " + newUser.getId());

    }

    // Mostrar todos os usuários (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> listUsers() {
        List<UserDTO> user = userService.listUsers();
        return ResponseEntity.ok(user);
    }

    //localhost
    // Procurar usuário por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> showUsersByID(@PathVariable Long id) {
        UserDTO user = userService.listUserByID(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário de id: " + id + ", não existe.");
        }
    }


    // Alterar dados dos usuários (UPDATE)
    // Sempre que o usuario for passar uma variável, tem que isar chaves
    //E também o @PathVariable
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> changeUsersByID(@PathVariable Long id, @RequestBody UserDTO updatedUser) {
        UserDTO user = userService.updateUser(id, updatedUser);
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário de id: " + id + ", não existe.");
        }
    }

    // Deletar usuários (DELETE)
    //@PathVariable - Serve para colocar uma variávio que o usuário deseja inserir
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteUsersByID(@PathVariable Long id) {
        if(userService.listUserByID(id) != null) {
            userService.deleteUsersByID(id);
            return ResponseEntity.ok("Usuário do ID " + id + ", foi deletado.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O usuário com o ID " + id + " não existe.");
        }

    }

}