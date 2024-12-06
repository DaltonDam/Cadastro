package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios/ui")
public class UserControllerUI {
    private final UserService userService;

    public UserControllerUI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public String listUsers(Model model) {
        List<UserDTO> user = userService.listUsers();
        model.addAttribute("user", user);
        return "ListUsers"; //Necessário retornar o nome da pagina que renderiza

    }

    @GetMapping("/deletar/{id}")
    public String deleteUsersByID(@PathVariable Long id) {
        userService.deleteUsersByID(id);
        return "redirect:/usuarios/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String ListUsersByID(@PathVariable Long id, Model model) {
        UserDTO user = userService.listUserByID(id);
        if(user != null) {
            model.addAttribute("user", user);
            return "userEdit";
        } else {
            model.addAttribute("Message", "User not found");
            return "ListUsers";
        }
    }

    @PostMapping("/alterar/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserDTO updatedUserDTO, Model model) {
        // Chama o método do serviço para atualizar o usuário
        UserDTO updatedUser = userService.updateUser(id, updatedUserDTO);

        if (updatedUser != null) {
            // Se a atualização foi bem-sucedida, redireciona para a página de detalhes do usuário
            return "redirect:/usuarios/ui/detalhar/" + id;

        } else {
            // Se houve erro, exibe uma mensagem e retorna para a página de edição
            model.addAttribute("Message", "Error updating user");
            return "userEdit";  // Retorna à página de edição com a mensagem de erro
        }
    }



    @GetMapping("/detalhar/{id}")
    public String detalharUsuario(@PathVariable("id") Long id, Model model) {
        UserDTO user = userService.listUserByID(id); // Exemplo, ajuste conforme seu serviço
        model.addAttribute("user", user);
        return "userDetails"; // Nome do arquivo HTML da página de detalhes
    }

    @GetMapping("/adicionar")
    public String showAddUserForm() {
        return "userAdd"; // Nome do arquivo HTML do formulário de adição
    }

    @PostMapping("/adicionar")
    public String addUser(@RequestParam String name, @RequestParam int age,
                          @RequestParam String email, @RequestParam String rank) {
        // Criar um novo UserDTO
        UserDTO newUser = new UserDTO();
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setEmail(email);
        newUser.setRank(rank);

        // Adicionar o novo usuário através do serviço
        userService.createUser(newUser);

        // Redirecionar para a página de listagem
        return "redirect:/usuarios/ui/listar";
    }

}
