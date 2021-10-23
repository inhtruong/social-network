package com.cg.socialnetwork.service.like;//package com.cg.service.LikeService;


import com.cg.socialnetwork.model.Like;
import com.cg.socialnetwork.model.dto.LikeDTO;
import com.cg.socialnetwork.service.IGeneralService;

import java.util.Optional;

public interface ILikeService extends IGeneralService<Like> {
    public Optional<LikeDTO> findAllTest();
}
