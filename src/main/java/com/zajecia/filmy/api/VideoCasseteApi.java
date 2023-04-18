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
    VideoCassetteManager videoCassetteManager;

    @Autowired
    public VideoCasseteApi(VideoCassetteManager videoCassetteManager) {
        videoCassetteManager = videoCassetteManager;
    }

    @GetMapping("/all")
    public ArrayList<VideoCassete> getVideoCassetes() {
        return cassetes;
    }

    @GetMapping
    public VideoCassete getById(@RequestParam int index) {
        Optional<VideoCassete> first = cassetes
                .stream()
                .filter(element -> element.getIdentyfikator() == index)
                .findFirst();
        return first.get();

    }
    @PostMapping
    public boolean addVideo(@RequestBody VideoCassete cassete){
        return cassetes.add(cassete);
    }
    @PutMapping
    public boolean updateVideo(@RequestBody VideoCassete cassete){
        return cassetes.add(cassete);
    }

    @DeleteMapping
    public boolean removeVideoCassete(@RequestParam int index) {
        return cassetes.removeIf(v -> v.getIdentyfikator() == index);
    }

}
