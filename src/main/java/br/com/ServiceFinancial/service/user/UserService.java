package br.com.ServiceFinancial.service.user;

import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.entity.UserEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDTO getUserById(Long userId) {
        log.info("UserService.GetUserById - Start - UserId: [{}] ", userId);
        var userEntity = this.searchUserById(userId);
        var response = modelMapper.map(userEntity, UserResponseDTO.class);
        log.info("UserService.GetUserById - End - UserId: [{}], UserResponseDTO: [{}] ", userId, response);
        return response;
    }

    public UserResponseDTO createUser(UserRequestDTO request) {
        log.info("UserService.CreateUser - Start - UserRequestDTO: [{}] ", request);
        var usersEntity = modelMapper.map(request, UserEntity.class);
        var entity = this.createUserDb(usersEntity);
        var response = modelMapper.map(entity, UserResponseDTO.class);
        log.info("UserService.CreateUser - End - UserRequestDTO: [{}], UserResponseDTO: [{}] ", request, response);
        return response;
    }

    public void deleteUserById(Long userId) {
        log.info("UserService.deleteUserById - Start - UserId: [{}] ", userId);
        var userEntity = this.searchUserById(userId);
        this.removeUserEntity(userEntity);
        log.info("UserService.deleteUserById - End - UserId: [{}] - [Deleted]", userId);
    }
}
