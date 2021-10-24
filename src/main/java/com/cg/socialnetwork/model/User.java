package com.cg.socialnetwork.model;

import com.cg.socialnetwork.model.dto.UserDTO;
import com.cg.socialnetwork.model.enumModel.Gender;
import com.cg.socialnetwork.model.enumModel.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean status;

//    @Column(columnDefinition = "integer default 1")
    private int city;

//    @Column(columnDefinition = "integer default 25")
    private int country;

    @ManyToOne
    @JoinColumn(name = "image_id",referencedColumnName = "id")
    private Media avatar;

//    @ManyToOne
//    @JoinColumn(name = "role_id",referencedColumnName = "id")
//    private Role role;

    @ManyToOne
    @JoinColumn(name = "background_id",referencedColumnName = "id")
    private Media background;

//    private boolean status = true;
//    @PrePersist
//    public void setAvatar(){
//        if(avatar == null){
//            avatar = new Media(1);
//        }
//    }

    public User(long id, String email, @NotBlank String password, @NotBlank String firstName,
                @NotBlank String lastName, Gender gender, int city, int country) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
        this.country = country;
    }

    public User(String email, @NotBlank String password, @NotBlank String firstName, @NotBlank String lastName, @NotBlank Date dateOfBirth, Gender gender, Boolean status) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.status = status;
    }

    public UserDTO toUserDTOAdmin(){
        return new UserDTO(id, firstName, lastName, email, gender, status);
    }
}
