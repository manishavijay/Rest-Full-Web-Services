package com.meetUps.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import com.meetUps.model.MeetUps;
import com.meetUps.model.MeetUpsRegistration;

@ComponentScan("com.meetUps")
@Repository
public interface MeetUpsDao {

	void addMeetUps(MeetUps meetUp);
	   List<MeetUps> viewMeetUps();
	   void deleteMeetUps(int id);
	   void updateMeetUps(MeetUps meetUp);
	   List<MeetUps>  viewMeetUp(String presenter);
	   void registerMeetUps(MeetUpsRegistration meetUpRegistration);

}
