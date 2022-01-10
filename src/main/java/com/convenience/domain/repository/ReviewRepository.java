package com.convenience.domain.repository;

import com.convenience.domain.Review;
import com.convenience.web.dto.ReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}

