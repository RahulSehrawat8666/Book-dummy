package com.bookcatalog.ratingservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "BOOK_RATING")
public class BookRatingEntity implements Cloneable {

	@EmbeddedId
	private BookUserIdEntity bookUserId;
	/*
	 * @Min(value = 0)
	 * 
	 * @Max(value = 5)
	 */
	private int rating;

	public BookRatingEntity() {

	}

	public BookRatingEntity(BookUserIdEntity bookUserId, int rating) {
		super();
		this.bookUserId = bookUserId;
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public BookUserIdEntity getBookUserId() {
		return bookUserId;
	}

	public void setBookUserId(BookUserIdEntity bookUserId) {
		this.bookUserId = bookUserId;
	}

	@Override
	public String toString() {
		return "BookRatingEntity [bookUserId=" + bookUserId + ", rating=" + rating + "]";
	}

}
