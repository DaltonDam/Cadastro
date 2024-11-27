package dev.Dam.Cadastro.Tasks;

import org.springframework.web.bind.annotation.*;

//A restcontroller fica em todos os controles
@RestController
@RequestMapping("tarefas") //cria as rotas
public class TasksController {

    // GET -- Mandar um requisição para mostrar as missoes
    @GetMapping("/listar")
    public String listTask() {
        return "Tarefas listadas com sucesso";
    }

    // POST -- Mandar um requisição para criar as missoes
    @PostMapping("/criar")
    public String createTask() {
        return "Tarefa criada com sucesso";
    }

    // PUT -- Mandar um requisição para alterar as missoes
    @PutMapping("/alterar")
    public String changeTask() {
        return "Tarefa alterada com sucesso";
    }

    // DELETE -- Mandar um requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public String deleteTask() {
        return "Tarefa deletada com sucesso";
    }

}
