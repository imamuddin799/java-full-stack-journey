package org.jsp.spring_ioc_container_annotations.setter_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Movie {

	String name;
	String publishDate;
	String actorName;
	public String getName() {
		return name;
	}
	@Value(value = "Karan Arjun")
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishDate() {
		return publishDate;
	}
	
	@Value(value = "1994")
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getActorName() {
		return actorName;
	}
	
	@Value(value = "Shahrukh Khan")
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
}