package com.example.ericsimpleservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Book 1", "Author 1", 2000));
        books.add(new Book(2, "Book 2", "Author 2", 2000));
        books.add(new Book(3, "Book 3", "Author 3", 2000));
        books.add(new Book(4, "Book 4", "Author 4", 2000));
        books.add(new Book(5, "Book 5", "Author 5", 2000));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        // get book with id or null
        for (Book book : books) {
            if (book.getId() == id) {
                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {
        int newId = books.size() + 1;
        book.setId(newId);
        books.add(book);

        return ResponseEntity.status(201).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBooks(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBooks(@PathVariable int id, @RequestBody Book book) {
        for (Book book1 : books) {
            if (book1.getId() == id) {
                book1.setTitle(book.getTitle());
                book1.setAuthor(book.getAuthor());
                book1.setPrice(book.getPrice());
                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }





    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}


