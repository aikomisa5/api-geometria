package com.geometria.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.geometria.enums.TipoFigura;

@Entity
@Table(name = "Triangulo")
public class Triangulo extends Poligono{

	public Triangulo() {
		super();
		this.setUuid(UUID.randomUUID());
		this.setTipoFigura(TipoFigura.TRIANGULO);
	}
}
