package com.example.gursel.newproject.Models;

public class Embrioresimpojo{
	private String result;
	private String dosya;
	private boolean tf;
	private String tarih;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setResim(String dosya){
		this.dosya = dosya;
	}

	public String getResim(){
		return dosya;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setTarih(String tarih){
		this.tarih = tarih;
	}

	public String getTarih(){
		return tarih;
	}

	@Override
 	public String toString(){
		return 
			"Embrioresimpojo{" + 
			"result = '" + result + '\'' + 
			",dosya = '" + dosya + '\'' +
			",tf = '" + tf + '\'' + 
			",tarih = '" + tarih + '\'' + 
			"}";
		}
}
