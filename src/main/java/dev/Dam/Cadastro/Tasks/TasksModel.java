package dev.Dam.Cadastro.Tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Dam.Cadastro.Pessoas.Controller.Service.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_Tasks")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class TasksModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private Long id;
    private String name;
    private String difficulty;

    //@OneToMany - Muitos usuarios para mesma task
    @OneToMany(mappedBy = "tasks")
    @JsonIgnore //Ignora a serialização
    private List<UserModel> user;


}
