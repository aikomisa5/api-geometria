package com.geometria.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class CuadradoRequest implements Serializable{
	
	private static final long serialVersionUID = -7218714158033955551L;
	
	private Double base;

	public CuadradoRequest() {
		super();
	}

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}
}
