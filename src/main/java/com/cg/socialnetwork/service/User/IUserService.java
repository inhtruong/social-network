package com.cg.socialnetwork.service.user;//package com.cg.service.User;
//


import com.cg.socialnetwork.model.User;
//import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Iterable<UserDTO> userList();

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
