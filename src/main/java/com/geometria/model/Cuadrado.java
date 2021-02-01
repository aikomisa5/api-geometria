package com.geometria.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.geometria.enums.TipoFigura;

@Entity
@Table(name = "Cuadrado")
public class Cuadrado extends Paralelogramo{
	
	public Cuadrado() {
		super();
		this.setUuid(UUID.randomUUID());
		this.setTipoFigura(TipoFigura.CUADRADO);
	}
}
