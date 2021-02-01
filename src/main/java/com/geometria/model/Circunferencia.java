package com.geometria.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.geometria.interfaces.OperacionesCircunferencia;

@MappedSuperclass
public class Circunferencia extends FiguraGeometrica implements OperacionesCircunferencia{
	
	@Column(name = "radio")
	private Double radio;
	
	@Column(name = "diametro")
	private Double diametro;

	public Circunferencia() {
		super();
	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}
}
