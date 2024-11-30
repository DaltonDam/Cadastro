package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//SERVICE É A CAMADA DE LÓGICA

//@Autowired //Construtor
@Service // Indica que esta é uma camada de serviço
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
    public UserDTO createUser(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
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
