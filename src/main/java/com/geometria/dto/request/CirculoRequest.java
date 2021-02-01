package com.geometria.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class CirculoRequest implements Serializable{
	
	private static final long serialVersionUID = -7292951892987234058L;
	
	private Double radio;

	public CirculoRequest() {
		super();
	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}
}
