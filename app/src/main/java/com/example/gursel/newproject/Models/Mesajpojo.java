package com.example.gursel.newproject.Models;

public class Mesajpojo{
	private Object pno;
	private Object ksoyad;
	private Object mesajId;
	private Object ktarih;
	private Object kmesaj;
	private Object kdoktor;
	private Object kad;

	public void setPno(Object pno){
		this.pno = pno;
	}

	public Object getPno(){
		return pno;
	}

	public void setKsoyad(Object ksoyad){
		this.ksoyad = ksoyad;
	}

	public Object getKsoyad(){
		return ksoyad;
	}

	public void setMesajId(Object mesajId){
		this.mesajId = mesajId;
	}

	public Object getMesajId(){
		return mesajId;
	}

	public void setKtarih(Object ktarih){
		this.ktarih = ktarih;
	}

	public Object getKtarih(){
		return ktarih;
	}

	public void setKmesaj(Object kmesaj){
		this.kmesaj = kmesaj;
	}

	public Object getKmesaj(){
		return kmesaj;
	}

	public void setKdoktor(Object kdoktor){
		this.kdoktor = kdoktor;
	}

	public Object getKdoktor(){
		return kdoktor;
	}

	public void setKad(Object kad){
		this.kad = kad;
	}

	public Object getKad(){
		return kad;
	}

	@Override
 	public String toString(){
		return 
			"Mesajpojo{" + 
			"pno = '" + pno + '\'' + 
			",ksoyad = '" + ksoyad + '\'' + 
			",mesaj_id = '" + mesajId + '\'' + 
			",ktarih = '" + ktarih + '\'' + 
			",kmesaj = '" + kmesaj + '\'' + 
			",kdoktor = '" + kdoktor + '\'' + 
			",kad = '" + kad + '\'' + 
			"}";
		}
}
