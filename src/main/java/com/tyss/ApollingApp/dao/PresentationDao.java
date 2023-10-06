package com.tyss.ApollingApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.repository.PresentationRepository;

@Repository
public class PresentationDao {
	@Autowired
	PresentationRepository presentationRepository;

	@Autowired
	UserDao userDao;
	
	

	public Presentation savePresentation(Presentation presentation) {
		return presentationRepository.save(presentation);
	}

	public Presentation findByPresentationId(int id) {
		return presentationRepository.findById(id).get();
	}

	public void removePresentationById(int id) {
		presentationRepository.deleteById(id);
	}

	public List<Presentation> findPresentationsByUserId(int id) {
		User user = userDao.findById(id).get();
		return user.getPresentations();
	}
	
	public List<Presentation> findCompletedPresentation(int id){
		
		return presentationRepository.findCompletedPresentation(id);
	}
}
