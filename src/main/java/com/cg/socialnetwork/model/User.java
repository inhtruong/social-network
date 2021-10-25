package com.cg.socialnetwork.model;

import com.cg.socialnetwork.model.enumModel.Gender;
import com.cg.socialnetwork.model.enumModel.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "background_id",referencedColumnName = "id")
    private Media background;


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

    public User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
