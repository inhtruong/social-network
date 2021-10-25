package com.cg.socialnetwork.service.role;


import com.cg.socialnetwork.model.Role;
import com.cg.socialnetwork.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
