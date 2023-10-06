package com.tyss.ApollingApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.Rating;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.exceptions.RatingNotFoundException;
import com.tyss.ApollingApp.repository.RatingRepository;

@Repository
public class RatingDao {
	@Autowired
    RatingRepository ratingRepository ;
	
	@Autowired
	PresentationDao presentationDao ; 
	
	@Autowired
	UserDao userDao ;
	
	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating) ;
	}
	
	public Rating findRatingById(int id) {
		return ratingRepository.findById(id).get() ;
	}
	
	public List<Rating> findRatingsByPresentationId(int id) {
		Presentation presentation = presentationDao.findByPresentationId(id) ;
		return presentation.getRatings() ;
	}
	
	public List<Rating> findRatingsByUserId(int id) {
		User user = userDao.findById(id).get() ;
		return user.getRatings() ;
	}
	
	public Rating findByPresentationIdandRatingId(int pid,int uid)
	{
		List<Rating> list =findRatingsByPresentationId(pid);
		
		if(list!=null )
		{
			for(Rating rating : list)
			{
				if(rating.getVoter().getUserId()==uid)
				{
					return rating;
				}
			}
		}
		return null;
	}
	
	public List<Rating> findRatingByPresentationIdAndStatus(int id)
	{
		return ratingRepository.findRatingByPresentationIdAndStatus(id);
	}
}
