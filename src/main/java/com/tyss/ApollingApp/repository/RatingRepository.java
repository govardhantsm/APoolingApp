package com.tyss.ApollingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.ApollingApp.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
