package com.example.sampleapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String title;
    @NonNull private String isbn;

    @OneToOne
    @NonNull private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(@NonNull String title, @NonNull String isbn, @NonNull Publisher publisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
