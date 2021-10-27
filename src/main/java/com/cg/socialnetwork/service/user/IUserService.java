package com.cg.socialnetwork.service.User;
import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.SearchDTO;
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

    Iterable<SearchDTO> findByNameContaining(String keyword);

    Iterable<User> findAllByFullNameContaining(String keyword);

    UserDTO findUserByEmail(String email);

}
