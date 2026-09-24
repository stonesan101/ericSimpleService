package com.example.ericsimpleservice;

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
    public Comic getComic(@PathVariable int id) {
        return comics.stream()
                .filter(comic -> comic.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Comic addComic(@RequestBody Comic comic) {
        int newId = comics.size() + 1;
        comic.setId(newId);
        comics.add(comic);
        return comic;
    }

    @DeleteMapping("/{id}")
    public void deleteComic(@PathVariable int id) {
        comics.removeIf(comic -> comic.getId() == id);
    }

    @PutMapping("/{id}")
    public Comic updateComic(@PathVariable int id, @RequestBody Comic comic) {
        for (Comic c : comics) {
            if (c.getId() == id) {
                c.setTitle(comic.getTitle());
                c.setPublisher(comic.getPublisher());
                c.setAuthor(comic.getAuthor());
                c.setEdition(comic.getEdition());
                c.setPrice(comic.getPrice());
                return c;
            }
        }
        return null;
    }

}