package com.geometria.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.geometria.interfaces.OperacionesParalelogramo;

@MappedSuperclass
public class Paralelogramo extends FiguraGeometrica implements OperacionesParalelogramo{
	
	@Column(name = "base")
	private Double base;
	
	@Column(name = "altura")
	private Double altura;

	public Paralelogramo() {
		super();
	}

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
}
