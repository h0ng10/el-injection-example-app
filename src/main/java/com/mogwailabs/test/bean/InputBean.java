package com.mogwailabs.test.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "inputBean", eager = true)
@SessionScoped
@SuppressWarnings("serial")
public class InputBean implements Serializable {
   
	private String input;
	
	public String getInput() {
	    return input;
	}
	
	public void setInput(String input) {
	    this.input = input;
	}
   
}
