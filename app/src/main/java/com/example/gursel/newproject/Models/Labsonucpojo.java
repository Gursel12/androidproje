package com.example.gursel.newproject.Models;

public class Labsonucpojo{

	private String test;

	private String tarih;

	private String guid;


	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "Labsonucpojo{" +
				"test='" + test + '\'' +
				", tarih='" + tarih + '\'' +
				", guid='" + guid + '\'' +
				'}';
	}
}
