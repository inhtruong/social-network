package com.cg.socialnetwork.service.like;//package com.cg.service.LikeService;



import com.cg.socialnetwork.model.Like;
import com.cg.socialnetwork.model.dto.LikeDTO;
import com.cg.socialnetwork.repository.ILikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService implements ILikeService{
    @Autowired
    private ILikeRepository iLikeRepository;

    @Override
    public Iterable<Like> findAll() {
        return iLikeRepository.findAll();
    }

    @Override
    public Optional<Like> findById(long id) {
        return iLikeRepository.findById(id);
    }

    @Override
    public Like save(Like like) {
        return iLikeRepository.save(like);
    }

    @Override
    public void deleteById(long id) {
    iLikeRepository.deleteById(id);
    }

    @Override
    public Optional<LikeDTO> findAllTest() {
        return iLikeRepository.findAllTest();
    }
}
