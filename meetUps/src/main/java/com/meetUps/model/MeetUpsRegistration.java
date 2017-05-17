package com.meetUps.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meetupregistration")
public class MeetUpsRegistration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int dummy;

private int meetUpId;
private int userId;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
//private boolean flag;

public int getMeetUpId() {
	return meetUpId;
}
public void setMeetUpId(int meetUpId) {
	this.meetUpId = meetUpId;
}

}
