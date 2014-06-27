package com.ravi.rest.dao;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.ravi.rest.model.Activity;

public class ActivityDao {
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert; 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getActivityNameByID(int activityID){
		

		String sql = "SELECT ACTIVITYNAMENAME FROM ACTIVITY WHERE ACTIVITYID = ?";
		String actvityName = getJdbcTemplate().queryForObject(sql, new Object[] { activityID }, String.class);
		return actvityName;
		
	}
	
	public List<Activity> getActivities(){
		

		String sql = "SELECT * FROM ACTIVITY";
		List<Activity> activities = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Activity>(Activity.class));
		return activities;
		
	}
	
	public void createActivity(int activityId, String activityName){
		

		String sql = "INSERT INTO ACTIVITY VALUES (?,?)";
		int returnvalue =  getJdbcTemplate().update(sql, new Object[] {activityId, activityName});
		System.out.println("Insert Status :"+returnvalue);
		
		
	}	
	
		
}
