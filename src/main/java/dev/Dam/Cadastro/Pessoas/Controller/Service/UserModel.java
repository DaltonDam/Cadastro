package dev.Dam.Cadastro.Pessoas.Controller.Service;

import dev.Dam.Cadastro.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity ele transforma uma classe em uma entidade no Banco de Dados
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor //Lombok cria o construtor nas espreitas
@AllArgsConstructor
@Data //Todos os getters e os setters
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column(unique = true) //Cada email se torna único
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "age")
    private int age;

    //@ManyToOne - O usuário só pode ter uma única task
    @ManyToOne
    @JoinColumn(name = "tasks_id") //Foreing key ou chave e strangeira
    private TasksModel tasks;



}
