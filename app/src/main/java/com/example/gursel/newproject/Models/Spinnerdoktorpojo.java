package com.example.gursel.newproject.Models;

public class Spinnerdoktorpojo{
	private String result;
	private boolean tf;
	private String kdoktor;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setKdoktor(String kdoktor){
		this.kdoktor = kdoktor;
	}

	public String getKdoktor(){
		return kdoktor;
	}

	@Override
 	public String toString(){
		return 
			"Spinnerdoktorpojo{" + 
			"result = '" + result + '\'' + 
			",tf = '" + tf + '\'' + 
			",kdoktor = '" + kdoktor + '\'' + 
			"}";
		}
}
