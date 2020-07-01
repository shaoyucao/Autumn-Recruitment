package com.syc.f_xml.d_spel;

public class Customer {
	private String cname = "Jack";
	private double pi;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", pi=" + pi + "]";
	}
	
	
}
