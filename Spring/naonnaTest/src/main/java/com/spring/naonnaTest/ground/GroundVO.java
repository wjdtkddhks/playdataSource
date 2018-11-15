package com.spring.naonnaTest.ground;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class GroundVO {
	private String ground_Name;
	private String ground_admin;
	private String ground_addr;
	private String ground_city;
	private String grass;
	private String shower;
	private String parking;
	private String light;
	private String week_morning;
	private String week_evening;
	private String weekend_morning;
	private String weekend_evening;
	private String review;	
	private String rule;
	private String ground_people;
	private String ground_size;	
	private String photo1;
	private String photo2;
	private String photo3;
		
	
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public String getPhoto3() {
		return photo3;
	}
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	public String getPhoto() {
		return photo1;
	}
	public void setPhoto(String photo) {
		this.photo1 = photo;
	}
	public String getGround_Name() {
		return ground_Name;
	}
	public void setGround_Name(String ground_Name) {
		this.ground_Name = ground_Name;
	}
	public String getGround_admin() {
		return ground_admin;
	}
	public void setGround_admin(String ground_admin) {
		this.ground_admin = ground_admin;
	}
	public String getGround_addr() {
		return ground_addr;
	}
	public void setGround_addr(String ground_addr) {
		this.ground_addr = ground_addr;
	}
	public String getGround_city() {
		return ground_city;
	}
	public void setGround_city(String ground_city) {
		this.ground_city = ground_city;
	}
	public String getGrass() {
		return grass;
	}
	public void setGrass(String grass) {
		this.grass = grass;
	}
	public String getShower() {
		return shower;
	}
	public void setShower(String shower) {
		this.shower = shower;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getLight() {
		return light;
	}
	public void setLight(String light) {
		this.light = light;
	}
	public String getWeek_morning() {
		return week_morning;
	}
	public void setWeek_morning(String week_morning) {
		this.week_morning = week_morning;
	}
	public String getWeek_evening() {
		return week_evening;
	}
	public void setWeek_evening(String week_evening) {
		this.week_evening = week_evening;
	}
	public String getWeekend_morning() {
		return weekend_morning;
	}
	public void setWeekend_morning(String weekend_morning) {
		this.weekend_morning = weekend_morning;
	}
	public String getWeekend_evening() {
		return weekend_evening;
	}
	public void setWeekend_evening(String weekend_evening) {
		this.weekend_evening = weekend_evening;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getGround_people() {
		return ground_people;
	}
	public void setGround_people(String ground_people) {
		this.ground_people = ground_people;
	}
	public String getGround_size() {
		return ground_size;
	}
	public void setGround_size(String ground_size) {
		this.ground_size = ground_size;
	}
	
	
	
}
