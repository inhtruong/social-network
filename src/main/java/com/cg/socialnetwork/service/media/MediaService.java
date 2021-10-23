package com.cg.socialnetwork.service.media;//package com.cg.service.ImageService;





import com.cg.socialnetwork.model.Media;
import com.cg.socialnetwork.repository.IMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private IMediaRepository iMediaRepository;

    @Override
    public Iterable<Media> findAll() {
        return iMediaRepository.findAll();
    }

    @Override
    public Optional<Media> findById(long id) {
        return iMediaRepository.findById(id);
    }

    @Override
    public Media save(Media image) {
        return iMediaRepository.save(image);
    }

    @Override
    public void deleteById(long id) {
    iMediaRepository.deleteById(id);
    }
}
