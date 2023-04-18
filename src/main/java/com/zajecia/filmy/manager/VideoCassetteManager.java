package com.zajecia.filmy.manager;

import dao.VideoCasseteRepo;
import dao.entity.VideoCassete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {
    private final VideoCasseteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCasseteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassete> getVideoCassetteById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassete> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassete save(VideoCassete videoCassette) {
        return (VideoCassete) videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new VideoCassete(1L, "The Shawshank Redemption", LocalDate.of(1994, 9, 14)));
        save(new VideoCassete(2L, "The Godfather", LocalDate.of(1972, 3, 24)));
        save(new VideoCassete(3L, "The Dark Knight", LocalDate.of(2008, 7, 14)));

    }
}
