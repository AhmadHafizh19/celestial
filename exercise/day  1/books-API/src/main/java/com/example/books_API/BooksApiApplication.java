package com.example.books_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/books")
public class BooksApiApplication {

	private Map<Integer, BooksRequest> booksDatabase = new HashMap<>();
	private int idCounter = 1;

	public static void main(String[] args) {
		SpringApplication.run(BooksApiApplication.class, args);
	}

	@GetMapping
	public BooksRequest getBooks(@RequestParam int id) {
		return booksDatabase.getOrDefault(id, new BooksRequest());
	}

	@PostMapping
	public String postBooks(@RequestBody BooksRequest bookRequest) {
		int id = idCounter++;
		bookRequest.setId(id);
		booksDatabase.put(id, bookRequest);
		return String.format("Book '%s' created with ID: %d", bookRequest.getTitle(), id);
	}

	@PutMapping("/{id}")
	public String putBooks(@PathVariable int id, @RequestBody BooksRequest bookRequest) {
		if (booksDatabase.containsKey(id)) {
			bookRequest.setId(id);
			booksDatabase.put(id, bookRequest);
			return String.format("Book with ID %d updated to '%s'", id, bookRequest.getTitle());
		} else {
			return String.format("Book with ID %d not found", id);
		}
	}

	@DeleteMapping("/{id}")
	public String deleteBooks(@PathVariable int id) {
		if (booksDatabase.containsKey(id)) {
			booksDatabase.remove(id);
			return String.format("Book with ID %d deleted", id);
		} else {
			return String.format("Book with ID %d not found", id);
		}
	}
}