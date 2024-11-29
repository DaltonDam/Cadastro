package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Autowired //Construtor
@Service // Indica que esta é uma camada de serviço
public class UserService {
    private UserRepository userRepository;

    // Injeta o repositório via construtor
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    // Lista todos os usuários
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    //Listar todos os users por ID
    public UserModel listUserByID(Long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.orElse(null);
    }

    //Criar um novo ninja
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    //Deletar usuário - Tem que ser um método void
    public void deleteUsersByID(Long id) {
        userRepository.deleteById(id);
    }

    //Atualizar usuário
    public UserModel updateUser(Long id, UserModel updatedUser) {
        if(userRepository.existsById(id)) {
            updatedUser.setId(id); //.setId - Só funciona se instalar o plugin do lombok
            return userRepository.save(updatedUser);
        }
        return null;

    }
}
