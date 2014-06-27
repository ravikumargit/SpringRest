package com.ravi.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravi.rest.model.Activity;
import com.ravi.rest.service.ActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	private ActivityService actvityService;

	@ResponseBody
	@RequestMapping(value ="/{activityId}", method=RequestMethod.GET)
	public String getActivityName(@PathVariable String activityId){
		
		return actvityService.getActivityNameByID(Integer.parseInt(activityId));
		
	}
	
	@ResponseBody
	@RequestMapping(value ="/all", method=RequestMethod.GET)
	public List<Activity> getActivities(){
		System.out.println("Coming to getActivities");
		return actvityService.getActivities();
		
	}
	
	
	@RequestMapping(value ="/{activityId}/{activityName}", method=RequestMethod.POST)
	public void createActivity(@PathVariable String activityId, @PathVariable String activityName){
		System.out.println("Coming to Create Activity");
		 actvityService.createActivity(Integer.parseInt(activityId), activityName);
		 System.out.println("Actvity created : ID is :"+activityId);
	}
	
	@RequestMapping(value ="/test.do", method=RequestMethod.GET)
	public String getSample(){
		System.out.println("Coming");
		//actvityService.getActivityNameByID(Integer.parseInt(activityId));
		return "index";
	}
}
