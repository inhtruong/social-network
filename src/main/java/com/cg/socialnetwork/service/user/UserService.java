package com.cg.socialnetwork.service.User;

import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.UserPrinciple;
import com.cg.socialnetwork.model.dto.SearchDTO;
import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserDTO> userList() {
        return userRepository.userList();
    }

    @Override
    public Optional<UserDTO> findByIdDTO(Long id) {
        return userRepository.findByIdDTO(id);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Iterable<SearchDTO> findByNameContaining(String keyword) {
        return userRepository.findByNameContaining(keyword);
    }

    @Override
    public Iterable<User> findAllByFullNameContaining(String keyword) {
        return userRepository.findAllByFullNameContaining(keyword);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        return UserPrinciple.build(userOptional.get());
    }
}
