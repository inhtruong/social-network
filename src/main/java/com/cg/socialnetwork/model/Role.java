package com.cg.socialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "roles")
@Accessors(chain = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String code;

    private String name;

    @OneToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    private List<User> users;

    public Role(Long id){
        this.id = id;
    }
}
