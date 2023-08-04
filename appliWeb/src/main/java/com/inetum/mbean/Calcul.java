package com.inetum.mbean;


import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ReferencedBean;

@jakarta.faces.bean.ManagedBean
@ReferencedBean
@RequestScoped
public class Calcul {
	private Double x;
	
	private Double res;

	public String calculerRacineCarree() {
		String suite= null;
		this.res= Math.sqrt(this.x);
		return suite;
	}
	
	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getRes() {
		return res;
	}

	public void setRes(Double res) {
		this.res = res;
	}
	
}
