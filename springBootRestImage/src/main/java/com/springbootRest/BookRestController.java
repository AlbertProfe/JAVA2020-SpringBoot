package com.springbootRest;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class BookRestController {

	@Autowired
	BookRepository repository;

	@GetMapping("/books")
	public Iterable<Book> findAll() {

		return repository.findAll();
	}

	@PostMapping(path = "/books", consumes = "application/json")
	public void insertBook(@RequestBody Book book) {

		repository.save(book);
	}

	@DeleteMapping("/books/{title}")
	public void deleteBook(@PathVariable String title) {

		Optional<Book> book = repository.findById(title);

		if (book.isPresent()) {
			repository.delete(book.get());
		}

	}

	@PutMapping("/books/{title}")
	public void updateBook(@RequestBody Book book, @PathVariable String title) {

		Optional<Book> bookOp = repository.findById(title);

		if (bookOp.isPresent()) {
			book.setTitle(title);
			repository.save(book);
		}

	}

	@GetMapping("/books/{title}")
	public ResponseEntity<byte[]> findImage (@PathVariable("title") String title) throws SQLException {

		Optional<Book> book = repository.findById(title);
		byte[] imageBytes = null;
		if (book.isPresent()) {

			imageBytes = book.get().getImage().getBytes(1,
					(int) book.get().getImage().length());
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

}
