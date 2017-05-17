package com.meetUps.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meetUps.model.MeetUps;
import com.meetUps.model.MeetUpsRegistration;


@Transactional
@Repository

public class MeetUpsDaoImpl implements MeetUpsDao {

	@Autowired
	SessionFactory sessionFactory;
	public void addMeetUps(MeetUps meetUp) {
		Session session=sessionFactory.getCurrentSession();
		session.save(meetUp);
	}
	public List<MeetUps> viewMeetUps() {
		Session session=sessionFactory.getCurrentSession();
		return session.createCriteria(MeetUps.class).list();
	}
	public void deleteMeetUps(int id) {
		Session session=sessionFactory.getCurrentSession();
		MeetUps meetUp=(MeetUps) session.get(MeetUps.class, new Integer(id));
		session.delete(meetUp);
		
	}
	public void updateMeetUps(MeetUps meetUp) {
		Session session=sessionFactory.getCurrentSession();
		session.update(meetUp);
		
	}
	public List<MeetUps> viewMeetUp(String presenter) {
		List<MeetUps> meetup = new ArrayList();
		Session session=sessionFactory.getCurrentSession();
		List <MeetUps> meetUps= session.createCriteria(MeetUps.class).list();
		Iterator it = meetUps.iterator();
		while(it.hasNext())
		{
			MeetUps m=(MeetUps) it.next();
			if(m.getPresenter().equals(presenter))
				meetup.add(m);
		}
		return meetup;
	}
	public void registerMeetUps(MeetUpsRegistration meetUpRegistration) {
		Session session=sessionFactory.getCurrentSession();
		session.save(meetUpRegistration);
	}
	

}
