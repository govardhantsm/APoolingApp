package com.tyss.ApollingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tyss.ApollingApp.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	@Query(value = "SELECT r FROM Rating r WHERE r.voter.userId =?1")
	public List<Rating> findRatingByVoterId(int id);
	
	@Query(value = "SELECT r FROM Rating r WHERE r.presentation.presentationId =?1")
	public List<Rating> findRatingByPresentationId(int id);
	
	@Query(value = "SELECT r FROM Rating r WHERE r.presentation.presentationId=?1 AND r.voter.userId =?2")
	public List<Rating> findRatingByPresentationIdAndVoterId(int id1,int id2);
	@Modifying
	@Query(value = "delete FROM Rating r WHERE r.presentation.presentationId =?1")
	public void deleteRatingByPresentationId(int id);
	
	@Query(value = "SELECT r FROM Rating r WHERE r.presentation.presentationId =?1AND r.status=?2")
	public List<Rating> findRatingByPresentationIdAndStatus(int id , boolean status);
}
