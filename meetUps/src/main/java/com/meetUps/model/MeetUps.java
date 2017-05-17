package com.meetUps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class MeetUps {
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int meetUpId;
	@NotEmpty(message="title Should not be empty")
	private String title;
	@NotEmpty(message="presenter Should not be empty")
	private String presenter;
	@NotEmpty(message="description Should not be empty")
	private String description;
	@NotEmpty(message="guest Should not be empty")
	private String guest;
	@NotEmpty(message="date Should not be empty")
	private String date;
	@NotEmpty(message="startTime Should not be empty")
	private String startTime;
	@NotEmpty(message="endTime Should not be empty")
	private String endTime;
	public int getMeetUpId() {
		return meetUpId;
	}
	public void setMeetUpId(int meetUpId) {
		this.meetUpId = meetUpId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
