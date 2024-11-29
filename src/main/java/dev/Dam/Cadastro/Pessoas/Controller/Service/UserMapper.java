package dev.Dam.Cadastro.Pessoas.Controller.Service;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();

        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setImgUrl(userDTO.getImgUrl());
        userModel.setAge(userDTO.getAge());
        userModel.setTasks(userDTO.getTasks());
        userModel.setRank(userDTO.getRank());

        return userModel;

    }

    public UserDTO map(UserModel  userModel) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setImgUrl(userModel.getImgUrl());
        userDTO.setAge(userModel.getAge());
        userDTO.setTasks(userModel.getTasks());
        userDTO.setRank(userModel.getRank());

        return userDTO;

    }

}
