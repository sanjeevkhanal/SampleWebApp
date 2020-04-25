package com.example.sampleapp.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private String name;
    @NonNull private String streetName;
    @NonNull private String city;
    @NonNull private String state;
    @NonNull private String zip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id.equals(publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
