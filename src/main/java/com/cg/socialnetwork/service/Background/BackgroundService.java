package com.cg.socialnetwork.service.Background;

import com.cg.socialnetwork.model.Background;
import com.cg.socialnetwork.repository.BackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BackgroundService implements IBackgroundService{

    @Autowired
    private BackgroundRepository backgroundRepository;

    @Override
    public Iterable<Background> findAll() {
        return backgroundRepository.findAll();
    }

    @Override
    public Optional<Background> findById(long id) {
        return backgroundRepository.findById(id);
    }

    @Override
    public Background save(Background background) {
        return backgroundRepository.save(background);
    }

    @Override
    public void deleteById(long id) {
        backgroundRepository.deleteById(id);
    }
}
