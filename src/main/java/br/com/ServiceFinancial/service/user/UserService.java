package br.com.ServiceFinancial.service.user;

import br.com.ServiceFinancial.dto.users.UserRequestDTO;
import br.com.ServiceFinancial.dto.users.UserResponseDTO;
import br.com.ServiceFinancial.entity.UserEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDTO createUser(UserRequestDTO request) {
        log.info("UserService.createUser - Start - UserRequestDTO: [{}]", request);
        var entity = modelMapper.map(request, UserEntity.class);
        var newEntity = this.saveUser(entity);
        var response = modelMapper.map(newEntity, UserResponseDTO.class);
        log.info("UserService.createUser - End - CategoryResponseDTO: [{}]", request);
        return response;
    }

    public UserResponseDTO getUserById(Long id) {
        log.info("UserService.getUserById - Start - Id: [{}]", id);
        var newEntity = this.searchUserById(id);
        var response = modelMapper.map(newEntity, UserResponseDTO.class);
        log.info("UserService.getUserById - End - Id: [{}], UserResponseDTO: [{}]", id, response);
        return response;
    }

    public void deleteUserById(Long id) {
        log.info("UserService.deleteUserById - Start - Id: [{}]", id);
        var entity = this.searchUserById(id);
        this.removeUser(entity);
        log.info("UserService.deleteUserById - End - id: [{}] - Deleted", id);
    }
}
