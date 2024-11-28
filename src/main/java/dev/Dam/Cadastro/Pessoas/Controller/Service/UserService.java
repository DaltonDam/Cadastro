package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Autowired //Construtor
@Service // Indica que esta é uma camada de serviço
public class UserService {
    private UserRepository repository;

    // Injeta o repositório via construtor
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Lista todos os usuários
    public List<UserModel> listUsers() {
        return repository.findAll();
    }
}
