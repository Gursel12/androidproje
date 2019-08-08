package com.example.gursel.newproject.Models;

public class Tedavipojo{
	private String result;
	private boolean tf;
	private Object islem;
	private Object tarih;

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

	public void setKislem(Object kislem){
		this.islem = kislem;
	}

	public Object getKislem(){
		return islem;
	}

	public void setKtarih(Object ktarih){
		this.tarih = ktarih;
	}

	public Object getKtarih(){
		return tarih;
	}

	@Override
 	public String toString(){
		return 
			"Tedavipojo{" + 
			"result = '" + result + '\'' + 
			",tf = '" + tf + '\'' + 
			",kislem = '" + islem + '\'' +
			",ktarih = '" + tarih + '\'' +
			"}";
		}
}
