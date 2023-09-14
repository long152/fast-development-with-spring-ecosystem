package com.example.fastdevelopment.proxy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name = "BookProxy", url = "http://localhost:3000", path = "/books")
public interface BookProxy {

    @GetMapping("/{isbn}")
    BookResponse getByIsbn(@PathVariable String isbn);


    @Getter
    public static class BookResponse {
        @JsonProperty("id")
        private String isbn;
        private String title;
        private LocalDate publicationDate;
    }
}
