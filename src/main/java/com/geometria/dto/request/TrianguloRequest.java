package com.geometria.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class TrianguloRequest implements Serializable{
	
	private static final long serialVersionUID = 1075122309999954359L;

	private Double base;

	private Double altura;
	
	public TrianguloRequest() {
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


