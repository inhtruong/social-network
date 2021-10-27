package com.cg.socialnetwork.repository;//package com.cg.repository;


import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.dto.SearchDTO;
import com.cg.socialnetwork.model.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new com.cg.socialnetwork.model.dto.UserDTO (c.id, c.firstName, " +
            "c.lastName, c.email, c.gender, c.status) from User c")
    Iterable<UserDTO> userList();

//    @Query(value = "select new com.cg.socialnetwork.model.dto.UserDTO (c.password, c.email) from User c")
//    Iterable<UserDTO> userList();

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

    @Query("SELECT new com.cg.socialnetwork.model.dto.SearchDTO(c.id, c.fullName) FROM User c WHERE c.fullName LIKE %:keyWord%")
    Iterable<SearchDTO> findByNameContaining(@Param("keyWord") String keyword);

    Iterable<User> findAllByFullNameContaining(String keyword);
}
