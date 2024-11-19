package dev.Dam.Cadastro.Tasks;

import dev.Dam.Cadastro.Pessoas.Controller.Service.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_Tasks")
public class TasksModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String difficulty;

    //@OneToMany - Muitos usuarios para mesma task
    @OneToMany(mappedBy = "tasks")
    private List<UserModel> users;


}
