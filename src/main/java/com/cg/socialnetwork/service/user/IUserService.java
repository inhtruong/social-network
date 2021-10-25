package com.cg.socialnetwork.service.user;


import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface IUserService extends IGeneralService<User>, UserDetailsService {
//    Iterable<UserDTO> findAllUserDTO();

    Iterable<UserDTO> userList();

    Optional<UserDTO> findByIdDTO(Long id);


    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);


    UserDTO findUserByEmail(String email);
}
