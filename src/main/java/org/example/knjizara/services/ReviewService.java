package org.example.knjizara.services;

import org.example.knjizara.model.Review;
import org.example.knjizara.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            review.setReviewerName(reviewDetails.getReviewerName());
            review.setRating(reviewDetails.getRating());
            review.setComment(reviewDetails.getComment());
            review.setYear(reviewDetails.getYear());
            review.setBook(reviewDetails.getBook());
            return reviewRepository.save(review);
        }
        return null;
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public boolean isValidRating(Integer rating) {
        return rating != null && rating >= 1 && rating <= 5;
    }
}
