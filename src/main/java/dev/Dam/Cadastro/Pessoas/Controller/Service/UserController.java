package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Esta é a primeira mensagem nessa rota";
    }

}

/*

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Olha a mensagem"
    }

}

 */
