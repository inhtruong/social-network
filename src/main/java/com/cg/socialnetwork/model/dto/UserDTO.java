package com.cg.socialnetwork.model.dto;


import com.cg.socialnetwork.model.User;
import com.cg.socialnetwork.model.enumModel.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String repassword;
    private String dateOfBirth;
    private String email;
    private Gender gender;
    private Boolean status = true;
    private int country;
    private int city;
    private String image;
    private String background;
    private RoleDTO role;
    private String fullName;


    public UserDTO(Long id, String firstName, String lastName , String email, Gender gender, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public UserDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDTO(Long id, String image, String background) {
        this.id = id;
        this.image = image;
        this.background = background;
    }

    public Boolean checkEqual(){
        return password.equals(repassword);
    }

    public User toUserSignUp() throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
        return new User(email, password, firstName, lastName, date, gender, status);
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setEmail(email)
                .setPassword(password)
                .setRole(role.toRole());
    }
}