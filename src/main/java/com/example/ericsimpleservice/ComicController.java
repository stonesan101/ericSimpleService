package com.example.ericsimpleservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicController {

    private final List<Comic> comics = new ArrayList<>();

    ComicController() {
    comics.add(new Comic(1, "Batman", "DC Comics", "Bob Kane", 1, 400));
    comics.add(new Comic(2, "Superman", "DC Comics", "Jerry Siegel", 1, 500));
    comics.add(new Comic(3, "Spider-Man", "Marvel Comics", "Stan Lee", 1, 2000));
    comics.add(new Comic(4, "X-Men", "Marvel Comics", "Stan Lee", 1, 3000));
    comics.add(new Comic(5, "The Avengers", "Marvel Comics", "Stan Lee", 1, 1000));
    }

    @GetMapping
    public List<Comic> getComics() {
        return comics;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comic> getComic(@PathVariable int id) {
        for (Comic comic : comics) {
            if (comic.getId() == id) {
                return ResponseEntity.ok(comic);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Comic> addComic(@RequestBody Comic comic) {
        int newId = comics.size() + 1;
        comic.setId(newId);
        comics.add(comic);
        return ResponseEntity.status(201).body(comic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comic> deleteComic(@PathVariable int id) {
        for (Comic comic : comics) {
            if (comic.getId() == id) {
                comics.remove(comic);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comic> updateComic(@PathVariable int id, @RequestBody Comic comic) {
        for (Comic c : comics) {
            if (c.getId() == id) {
                c.setTitle(comic.getTitle());
                c.setPublisher(comic.getPublisher());
                c.setAuthor(comic.getAuthor());
                c.setEdition(comic.getEdition());
                c.setPrice(comic.getPrice());
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.notFound().build();
    }

}