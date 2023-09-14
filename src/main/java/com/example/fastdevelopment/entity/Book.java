package com.example.fastdevelopment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private LocalDate publicationDate;

    @ToString.Exclude
    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    public Book(String title, LocalDate publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

    @Override
    public int hashCode() {
        return 2023;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        return id != null && id.equals(((Book) obj).getId());
    }
}
