package com.geometria.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geometria.enums.TipoFigura;
import com.geometria.interfaces.OperacionesFiguraGeometrica;

@MappedSuperclass
public abstract class FiguraGeometrica implements OperacionesFiguraGeometrica{
	
	@JsonIgnore
	private UUID uuid;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(name = "superficie")
	private Double superficie;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoFigura")
	private TipoFigura tipoFigura;
	
	public UUID getUuid() {
		return uuid;
	}
	
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}
	
	public TipoFigura getTipoFigura() {
		return tipoFigura;
	}
	
	public void setTipoFigura(TipoFigura tipoFigura) {
		this.tipoFigura = tipoFigura;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((superficie == null) ? 0 : superficie.hashCode());
		result = prime * result + ((tipoFigura == null) ? 0 : tipoFigura.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		FiguraGeometrica other = (FiguraGeometrica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (superficie == null) {
			if (other.superficie != null)
				return false;
		} else if (!superficie.equals(other.superficie))
			return false;
		if (tipoFigura != other.tipoFigura)
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
}
