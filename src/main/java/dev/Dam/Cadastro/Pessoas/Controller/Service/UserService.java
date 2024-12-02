package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//SERVICE É A CAMADA DE LÓGICA

//@Autowired //Construtor
@Service // Indica que esta é uma camada de serviço
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Lista todos os usuários
    public List<UserDTO> listUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos os users por ID
    public UserDTO listUserByID(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.map(userMapper::map).orElse(null);
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

    //O antigo usava if and else
    //Atualizar usuário
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<UserModel> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            UserModel updatedUser = userMapper.map(userDTO);
            updatedUser.setId(id);
            UserModel savedUser = userRepository.save(updatedUser);
            return userMapper.map(savedUser);
        }
        return null;

    }
}
