package dev.Dam.Cadastro.Pessoas.Controller.Service;

import dev.Dam.Cadastro.Tasks.TasksModel;
import org.springframework.data.jpa.repository.JpaRepository;

//Manda tudo pro banco de dados ORM
public interface TasksRepository extends JpaRepository<TasksModel, Long> {


}
