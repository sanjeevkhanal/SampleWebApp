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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String firstName;
    @NonNull private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(@NonNull String firstName, @NonNull String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
