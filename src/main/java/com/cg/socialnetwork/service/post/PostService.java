package com.cg.socialnetwork.service.post;//package com.cg.service.PostService;
//


import com.cg.socialnetwork.model.Post;
import com.cg.socialnetwork.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public Iterable<Post> findAll() {
        return iPostRepository.findAll();
    }

    @Override
    public Optional<Post> findById(long id) {
        return iPostRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return iPostRepository.save(post);
    }

    @Override
    public void deleteById(long id) {
        iPostRepository.deleteById(id);
    }
}
