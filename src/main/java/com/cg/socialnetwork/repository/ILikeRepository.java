package com.cg.socialnetwork.repository;//package com.cg.repository;
//

import com.cg.socialnetwork.model.Like;
import com.cg.socialnetwork.model.dto.LikeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILikeRepository extends JpaRepository<Like, Long> {

    @Query(value = "SELECT NEW com.cg.socialnetwork.model.dto.LikeDTO (l.id.account, l.id.post, l.reaction)  " +
            "FROM Like l WHERE l.id.post.id = 1")
    public Optional<LikeDTO> findAllTest();
}
