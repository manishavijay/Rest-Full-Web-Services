package com.meetUps.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meetUps.dao.MeetUpsDao;
import com.meetUps.model.MeetUps;
import com.meetUps.model.MeetUpsRegistration;



@RestController
public class MeetUpsController {
	
	@Autowired
	MeetUpsDao meetUpsDao;
	@RequestMapping(value="/addmeetups",headers="Accept=application/json",method=RequestMethod.POST)
	public void addMeetUps(@RequestBody MeetUps meetUps)
	{
		meetUpsDao.addMeetUps(meetUps); 
	}
	@RequestMapping(value="/viewAllMeetUps",headers="Accept=application/json",method=RequestMethod.GET)
	public  List<MeetUps> viewMeetUps()
	{
		return meetUpsDao.viewMeetUps();
	}
	@RequestMapping(value="/deleteMeetUps/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	public void deleteMeetUps(@PathVariable int id)
	{
		meetUpsDao.deleteMeetUps(id);
	}
	@RequestMapping(value="/updateMeetUps",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateJob(@RequestBody MeetUps meetUp)
	{
		meetUpsDao.updateMeetUps(meetUp);
	}
	

	@RequestMapping(value="/viewMeetUp/{presenter}",headers="Accept=application/json",method=RequestMethod.GET)
	public  List<MeetUps> viewMeetUp(@PathVariable String presenter)
	{
		
		System.out.println(presenter);
		return meetUpsDao.viewMeetUp(presenter);
	}
	@RequestMapping(value="/registerMeetUps",headers="Accept=application/json",method=RequestMethod.POST)
	public void registerMeetUps(@RequestBody MeetUpsRegistration meetUpRegistration)
	{
		meetUpsDao.registerMeetUps(meetUpRegistration);
	}

}
