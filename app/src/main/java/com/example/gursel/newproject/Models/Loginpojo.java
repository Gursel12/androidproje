package com.example.gursel.newproject.Models;

public class Loginpojo{
	private Object pno;
	private Object sifre;
	private Object adi;
	private Object soyadi;
	private Object tckimlik;
	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setPno(Object pno){
		this.pno = pno;
	}

	public Object getPno(){
		return pno;
	}

	public void setSifre(Object sifre){
		this.sifre = sifre;
	}

	public Object getSifre(){
		return sifre;
	}

	public void setAdi(Object adi){
		this.adi = adi;
	}

	public Object getAdi(){
		return adi;
	}

	public void setSoyadi(Object soyadi){
		this.soyadi = soyadi;
	}

	public Object getSoyadi(){
		return soyadi;
	}

	public void setTckimlik(Object tckimlik){
		this.tckimlik = tckimlik;
	}

	public Object getTckimlik(){
		return tckimlik;
	}

	@Override
	public String toString() {
		return "Loginpojo{" +
				"pno=" + pno +
				", sifre=" + sifre +
				", adi=" + adi +
				", soyadi=" + soyadi +
				", tckimlik=" + tckimlik +
				", img=" + img +
				'}';
	}
}
