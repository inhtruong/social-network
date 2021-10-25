package com.cg.socialnetwork.model.dto;


import com.cg.socialnetwork.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RoleDTO {


    private Long id = new Long (1);

    private String code;

    public Role toRole() {
        return new Role()
                .setId(id)
                .setCode(code);
    }

}