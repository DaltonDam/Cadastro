package dev.Dam.Cadastro.Pessoas.Controller.Service;

import dev.Dam.Cadastro.Tasks.TasksModel;
import jakarta.persistence.*;

import java.util.List;

//Entity ele transforma uma classe em ma entidade no Banco de Dados
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    //@ManyToOne - O usuário só pode ter uma única task
    @ManyToOne
    @JoinColumn(name = "tasks_id") //Foreing key ou chave es
    private TasksModel tasks;

    public UserModel() {
    }

    public UserModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
