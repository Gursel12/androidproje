package com.example.gursel.newproject.Models;

public class Mesajcevappojo{
	private String result;
	private Object cevap;
	private boolean tf;
	private Object ctarih;
	private Object tarih;
	private Object mesaj;



	public Object getCevap() {
		return cevap;
	}

	public void setCevap(Object cevap) {
		this.cevap = cevap;
	}

	public Object getCtarih() {
		return ctarih;
	}

	public void setCtarih(Object ctarih) {
		this.ctarih = ctarih;
	}

	public Object getTarih() {
		return tarih;
	}

	public void setTarih(Object tarih) {
		this.tarih = tarih;
	}

	public Object getMesaj() {
		return mesaj;
	}

	public void setMesaj(Object mesaj) {
		this.mesaj = mesaj;
	}




	@Override
	public String toString() {
		return "Mesajcevappojo{" +
				"result='" + result + '\'' +
				", cevap=" + cevap +
				", tf=" + tf +
				", ctarih=" + ctarih +
				", tarih=" + tarih +
				", mesaj=" + mesaj +
				'}';
	}


}
