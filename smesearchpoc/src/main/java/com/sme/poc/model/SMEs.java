package com.sme.poc.model;


import java.lang.reflect.Array;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "smebar")
public class SMEs {

	@Id
	private String id;

	private String name;
	private String jobTitle;
	private List<String> skills;
	private List<String> clientEngagement;

	public SMEs() {
	}

	public SMEs(String name, String jobTitle, List<String> skills, List<String> clientEngagement) {
		
		this.name = name;
		this.jobTitle = jobTitle;
		this.skills = skills;
		this.clientEngagement = clientEngagement;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<String> getSkills() {
		return this.skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getClientEngagement() {
		return this.clientEngagement;
	}

	public void setClientEngagement(List<String> clientEngagement) {
		this.clientEngagement = clientEngagement;
	}
	

}
