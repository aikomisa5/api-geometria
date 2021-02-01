package com.geometria.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.geometria.enums.TipoFigura;

@Entity
@Table(name = "Circulo")
public class Circulo extends Circunferencia{
	
	public Circulo() {
		super();
		this.setUuid(UUID.randomUUID());
		this.setTipoFigura(TipoFigura.CIRCULO);
	}
}
