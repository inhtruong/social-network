package com.cg.socialnetwork.repository;//package com.cg.repository;
//

import com.cg.socialnetwork.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactionRepository extends JpaRepository<Reaction, Long> {
}
