package com.example.sampleapp.bootstrap;

import com.example.sampleapp.model.Author;
import com.example.sampleapp.model.Book;
import com.example.sampleapp.model.Publisher;
import com.example.sampleapp.repositories.AuthorRepository;
import com.example.sampleapp.repositories.BookRepository;
import com.example.sampleapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {


        Publisher harper = new Publisher("Harper Collins", "1st Street", "New York", "NY", "123456");
        Publisher wrox = new Publisher("Wrox", "2nd Street", "New York", "NY", "123456");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harper);
        publisherRepository.save(wrox);


        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
