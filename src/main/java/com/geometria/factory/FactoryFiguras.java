package com.geometria.factory;

import com.geometria.enums.TipoFigura;
import com.geometria.model.Circulo;
import com.geometria.model.Cuadrado;
import com.geometria.model.FiguraGeometrica;
import com.geometria.model.Triangulo;

public class FactoryFiguras {

	public static FiguraGeometrica getFiguraGeometrica(TipoFigura tipoFigura) {

		if (tipoFigura == null) {
			return null;
		}
		else if (tipoFigura.equals(TipoFigura.CUADRADO)) {
			return new Cuadrado();
		}
		else if (tipoFigura.equals(TipoFigura.TRIANGULO)) {
			return new Triangulo();
		}
		else {
			return new Circulo();
		}
	}
}
