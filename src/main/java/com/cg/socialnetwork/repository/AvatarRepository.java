package com.cg.socialnetwork.repository;

import com.cg.socialnetwork.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
