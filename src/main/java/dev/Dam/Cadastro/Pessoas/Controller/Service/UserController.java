package dev.Dam.Cadastro.Pessoas.Controller.Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vinda", description= "Essa rota da uma mensagem de boas vindas")
    public String boasVindas() {
        return "Esta é a primeira mensagem nessa rota";
    }

    // Adicionar usuário (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo usuário", description = "Essa rota cria um novo usuário e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar usuário")
    })

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
    @Operation(summary = "Lista o usuário por Id", description = "Essa rota lista um usuário pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado")
    })
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
    @Operation(summary = "Altera o usuário por Id", description = "Essa rota altera um usuário pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado, não foi possível alterar")
    })

    public ResponseEntity<?> changeUsersByID(
            @Parameter(description = "Cliente mando o Id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Cliente manda os dados do usuário a ser atualizado no no corpo da requisição")
            @RequestBody UserDTO updatedUser) {

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