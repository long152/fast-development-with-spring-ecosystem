package com.example.fastdevelopment.controller;

import com.example.fastdevelopment.entity.Book;
import com.example.fastdevelopment.proxy.BookProxy;
import com.example.fastdevelopment.proxy.BookProxy.BookResponse;
import com.example.fastdevelopment.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository repository;
    private final BookProxy bookProxy;

    @GetMapping
    public List<Book> getAll() {
        return repository.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        BookResponse bookResponse = bookProxy.getByIsbn(isbn);
        Optional<Book> bookOpt = repository.findByTitle(bookResponse.getTitle());
        if (bookOpt.isPresent()) {
            return bookOpt.get();
        }
        return repository.save(new Book(bookResponse.getTitle(), bookResponse.getPublicationDate()));
    }
}
