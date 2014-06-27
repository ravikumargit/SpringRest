package com.ravi.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.rest.dao.ActivityDao;
import com.ravi.rest.model.Activity;


@Service
public class ActivityService {
	
	@Autowired
	private ActivityDao activityDao;
	
	

	public String getActivityNameByID(int activityID){
	
		return activityDao.getActivityNameByID(activityID);
		
	}
	
	
	public List<Activity> getActivities(){
		
		return activityDao.getActivities();
		
	}
	
	
	public void createActivity(int activityId, String activityName){
		
		activityDao.createActivity(activityId, activityName);
		
	}
	

}
