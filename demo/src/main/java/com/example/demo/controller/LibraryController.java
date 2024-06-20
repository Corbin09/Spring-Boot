package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import com.example.demo.model.Book;
import java.util.Optional;

@RestController
@RequestMapping("/lib")
public class LibraryController {
    @Autowired
    private com.example.demo.repository.BookRepository BookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return BookRepository.findAll(); 
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        try{
            Book newBook = BookRepository.save(book);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Optional<Book> updateBook = BookRepository.findById(id);
        if(updateBook.isPresent()){
            Book existingBook = updateBook.get();
            existingBook.setAuthor(book.getAuthor());
            existingBook.setTitle(book.getTitle());
            return new ResponseEntity<>(BookRepository.save(existingBook), HttpStatus.OK);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        try{
            BookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}