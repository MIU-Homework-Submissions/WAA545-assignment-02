package com.merhawifissehaye.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/books")
public class BooksController {
    ArrayList<Book> books = new ArrayList<>();

    BooksController() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Lord of the Rings", "978-0618640157", "J. R. R. Tolkien", 12.99));
        books.add(new Book(2, "The Hobbit", "978-0547928227", "J. R. R. Tolkien", 12.99));
        books.add(new Book(3, "The Silmarillion", "978-0618391110", "J. R. R. Tolkien", 12.99));
        books.add(new Book(4, "The Power of Now", "978-0618391111", "Eckhart Tolle", 12.99));
        this.books = books;
    }

    @GetMapping("")
    public String index(Model model) {
        // return a collection of books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Lord of the Rings", "978-0618640157", "J. R. R. Tolkien", 12.99));
        books.add(new Book(2, "The Hobbit", "978-0547928227", "J. R. R. Tolkien", 12.99));
        books.add(new Book(3, "The Silmarillion", "978-0618391110", "J. R. R. Tolkien", 12.99));
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable int id, @RequestParam(required = false) String search, Model model) {
        // return a collection of books
        Book book = books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("search", search);
        return "book_view";
    }
}
