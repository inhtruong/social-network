package com.cg.socialnetwork.service.Avatar;

import com.cg.socialnetwork.model.Avatar;
import com.cg.socialnetwork.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvatarService implements IAvatarService{

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public Iterable<Avatar> findAll() {
        return avatarRepository.findAll();
    }

    @Override
    public Optional<Avatar> findById(long id) {
        return avatarRepository.findById(id);
    }

    @Override
    public Avatar save(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    @Override
    public void deleteById(long id) {
        avatarRepository.deleteById(id);
    }
}
