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
    private VideoCasseteRepo videoCasseteRepo;

    @Autowired
    public VideoCassetteManager(VideoCasseteRepo videoCasseteRepo) {
        this.videoCasseteRepo = videoCasseteRepo;
    }

    public Optional<VideoCassete> findAllById(long id) {
        return videoCasseteRepo.findById(id);
    }

    public Iterable<VideoCassete> findAll() {
        return videoCasseteRepo.findAll();
    }

    public VideoCassete save(VideoCassete videoCassete) {
        return (VideoCassete) videoCasseteRepo.save(videoCassete);
    }

    public void delete(long id) {
        videoCasseteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new VideoCassete(4,"tytul44", LocalDate.of(2000,1,1)));
        save(new VideoCassete(5,"tytul55", LocalDate.of(2000,1,1)));
    }
}
