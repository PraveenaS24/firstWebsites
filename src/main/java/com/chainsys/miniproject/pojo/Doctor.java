package com.chainsys.miniproject.pojo;

import java.util.Date;

public class Doctor {
	
			private int doc_id;
			private String doc_name;
			private Date DOB;
			private String speciality;
			private String city;
			private long phone_no;
			private float fees;
			
			public int getDoc_id() {
				return doc_id;
			}
			public void setDoc_id(int doc_id) {
				this.doc_id = doc_id;
			}
			
			public Date getDOB() {
				return DOB;
			}
			public void setDOB(Date dOB) {
				DOB = dOB;
			}
			public String getSpeciality() {
				return speciality;
			}
			public void setSpeciality(String speciality) {
				this.speciality = speciality;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public long getPhone_no() {
				return phone_no;
			}
			public void setPhone_no(long phone_no) {
				this.phone_no = phone_no;
			}
			public float getFees() {
				return fees;
			}
			public void setFees(float fees) {
				this.fees = fees;
			}
			public String getDoc_name() {
				return doc_name;
			}
			public void setDoc_name(String doc_name) {
				this.doc_name = doc_name;
			}
			
		}

