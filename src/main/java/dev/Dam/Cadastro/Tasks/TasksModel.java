package dev.Dam.Cadastro.Tasks;

import dev.Dam.Cadastro.Pessoas.Controller.Service.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_Tasks")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
