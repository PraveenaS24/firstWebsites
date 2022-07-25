package com.chainsys.miniproject.pojo;


import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	  @Override
	    public void valueBound(HttpSessionBindingEvent arg0) {
	        System.out.println("value bound"+arg0.getName());
	        System.out.println("value="+arg0.getValue().getClass().getName());
	    }
	    @Override
	    public void valueUnbound(HttpSessionBindingEvent arg0) {
	        System.out.println("value unbound"+arg0.getName());
	        
	    }
	    private String userId;
	    
	    public String getUserId() {
	        return userId;
	    }
	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    private String password;
	}