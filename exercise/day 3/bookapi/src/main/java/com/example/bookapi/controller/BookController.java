package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {
  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping
  public Page<Book> getBooks(
    @RequestParam(defaultValue = "0")  int page,
    @RequestParam(defaultValue = "5") int size,
    @RequestParam(required = false) String title
  ) {
    return service.getBooks(page, size, title);
  }

  @PostMapping
  public ResponseEntity<Book> createBook( @RequestBody Book book) {
    return ResponseEntity.ok(service.saveBook(book));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id,  @RequestBody Book book) {
    return ResponseEntity.ok(service.updateBook(id, book));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    service.deleteBook(id);
    return ResponseEntity.noContent().build();
  }
}
