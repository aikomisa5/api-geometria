package com.geometria.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({ "id", "radio", "superficie", "diametro"})
public class CirculoResponse implements Serializable{
	
	private static final long serialVersionUID = -4469441518091871436L;

	@ApiModelProperty(position = 1)
	private Long id;
	
	@ApiModelProperty(position = 2)
	private Double radio;
	
	@ApiModelProperty(position = 3)
	private Double superficie;
	
	@ApiModelProperty(position = 4)
	private Double diametro;

	public CirculoResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diametro == null) ? 0 : diametro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((radio == null) ? 0 : radio.hashCode());
		result = prime * result + ((superficie == null) ? 0 : superficie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CirculoResponse other = (CirculoResponse) obj;
		if (diametro == null) {
			if (other.diametro != null)
				return false;
		} else if (!diametro.equals(other.diametro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (radio == null) {
			if (other.radio != null)
				return false;
		} else if (!radio.equals(other.radio))
			return false;
		if (superficie == null) {
			if (other.superficie != null)
				return false;
		} else if (!superficie.equals(other.superficie))
			return false;
		return true;
	}
}
