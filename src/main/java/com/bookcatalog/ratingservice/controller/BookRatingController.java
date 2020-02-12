package com.bookcatalog.ratingservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcatalog.ratingservice.model.BookRating;
import com.bookcatalog.ratingservice.service.BookRatingServiceImpl;

@RestController
public class BookRatingController {

	@Autowired
	BookRatingServiceImpl bookRatingServiceImpl;

	@GetMapping(value = "api/bookcatalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<BookRating>> getBookRatingeDetails() {
		Collection<BookRating> listBookRating = bookRatingServiceImpl.getBookRatingDetails();
		return new ResponseEntity<Collection<BookRating>>(listBookRating, HttpStatus.OK);
	}
	
	@GetMapping(value = "api/bookcatalog/{userId}/{bookId}/rating",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookRating> getBookRatingDetailById(@PathVariable("userId") String userId,@PathVariable("bookId") int bookId){
		BookRating bookRating = bookRatingServiceImpl.getBookRatingDetailById(userId, bookId);
		return new ResponseEntity<BookRating>(bookRating,HttpStatus.OK);
	}

	@PostMapping(value = "api/bookcatalog/{userId}/{bookId}/rating", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBookRating(@PathVariable("userId") String userId,@PathVariable("bookId") int bookId, @RequestBody BookRating bookRating) {
		System.out.println("Hello");
		int rating = bookRatingServiceImpl.addBookRating(bookRating);
		System.out.println("[id]:" + rating);
		return new ResponseEntity<String>("Book added successfully with rating:" + rating, HttpStatus.CREATED);
	}
	
	@PutMapping(value= "api/bookcatalog/{userId}/{bookId}/rating" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookRating> updateBookRatingeDetails(@PathVariable("userId") String userId,@PathVariable("bookId") int bookId, @RequestBody BookRating bookRating){
        BookRating bookRating1 = bookRatingServiceImpl.updateBookRatingDetails(bookRating);
        return new ResponseEntity<BookRating>(bookRating1 , HttpStatus.CREATED);
    }
	
	@DeleteMapping(value= "api/bookcatalog/{userId}/{bookId}/rating")
	public ResponseEntity<String> deleteBookRating(@PathVariable("bookId") int bookId){
		bookRatingServiceImpl.deleteBookRatingDetails(bookId);	
		return new ResponseEntity<String>("Book deleted successfully with bookID:" + bookId, HttpStatus.ACCEPTED);
	}
}
