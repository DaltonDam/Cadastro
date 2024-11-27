package dev.Dam.Cadastro.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

//Manda tudo pro banco de dados ORM
public interface TasksRepository extends JpaRepository<TasksModel, Long> {


}
