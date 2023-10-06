package com.tyss.ApollingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.util.Status;

public interface PresentationRepository extends JpaRepository<Presentation, Integer> {
    

	List<Presentation> findByPresenterUserId(int id) ;
	
	@Query("select p from Presentation p where (p.status=ACTIVE)")
   List<Presentation> findActivePresentation() ;
	
	@Query("select p from Presentation p where p.presenter.userId=?1 and (p.status=COMPLETED)")
	List<Presentation> findCompletedPresentation(int id) ;
	
	@Query("select p from Presentation p where p.status=ONGOING")
	List<Presentation> findOngoingPresentation() ;
}                      
