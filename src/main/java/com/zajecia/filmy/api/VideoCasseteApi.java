package com.zajecia.filmy.api;

import com.zajecia.filmy.manager.VideoCassetteManager;
import dao.VideoCasseteRepo;
import dao.entity.VideoCassete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetes")
public class VideoCasseteApi {
    private final VideoCassetteManager videoCassetteManager;

    public VideoCasseteApi(VideoCassetteManager videoCassetteManager) {
        this.videoCassetteManager = videoCassetteManager;
    }

    @GetMapping("/all")
    public Iterable<VideoCassete> getVideoCassettes() {
        return videoCassetteManager.findAll();
    }

    @GetMapping
    public Optional<VideoCassete> getCassetteById(@RequestParam int id) {
        return videoCassetteManager.getVideoCassetteById((long) id);
    }

    @PostMapping
    public VideoCassete addVideo(@RequestBody VideoCassete videoCassette) {
        return videoCassetteManager.save(videoCassette);
    }

    @PutMapping
    public VideoCassete updateVideo(@RequestParam int id, @RequestBody VideoCassete videoCassette) {
        return videoCassetteManager.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam int id) {
        videoCassetteManager.deleteById((long)id);
    }

}
