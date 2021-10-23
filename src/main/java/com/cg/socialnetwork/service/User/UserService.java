package com.cg.socialnetwork.service.user;//package com.cg.service.User;
//

import com.cg.socialnetwork.model.User;
//import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements com.cg.socialnetwork.service.user.IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public Iterable<UserDTO> findAllUserDTO() {
//        return userRepository.findAllUserDTO();
//    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
