package com.spring.springajax;

import org.springframework.stereotype.Component;

/*create table people(
	    id varchar2(10) primary key,
	    name varchar2(20),
	    job varchar2(20),
	    address varchar2(40),
	    bloodtype varchar2(2)
	);*/

@Component
public class PeopleVO {
		private String id;
		private String name;
		private String job;
		private String address;
		private String bloodtype;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getBloodtype() {
			return bloodtype;
		}
		public void setBloodtype(String bloodtype) {
			this.bloodtype = bloodtype;
		}
		
}
