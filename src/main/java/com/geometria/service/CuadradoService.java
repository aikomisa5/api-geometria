package com.geometria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geometria.dto.request.CuadradoRequest;
import com.geometria.dto.response.CuadradoResponse;
import com.geometria.enums.TipoFigura;
import com.geometria.exceptions.BadRequestException;
import com.geometria.exceptions.NoContentException;
import com.geometria.factory.FactoryFiguras;
import com.geometria.model.Cuadrado;
import com.geometria.repository.CuadradoRepository;

@Service
public class CuadradoService {

	@Autowired
	private CuadradoRepository repository;
	
	/**
	 * Public
	 **/

	public Cuadrado getCuadrado(Long id) throws NoContentException{
		
		return repository.findById(id).orElseThrow(() -> new NoContentException("No se ha encontrado un cuadrado con id: " + id));
		
	}

	public CuadradoResponse getCuadradoResponse(Long id) throws NoContentException{

		Cuadrado cuadradoBBDD = repository.findById(id).orElse(null);

		if (cuadradoBBDD != null) {
			return getCuadradoResponse(cuadradoBBDD);
		}else {
			throw new NoContentException("No se ha encontrado un cuadrado con id: " + id);
		}
	}

	public Cuadrado saveCuadrado(Cuadrado cuadrado){
		return repository.save(cuadrado);
	}
	
	public CuadradoResponse saveCuadradoRequest(CuadradoRequest request) throws BadRequestException{
		
		validarCuadradoRequest(request);
		
		Cuadrado cuadrado = getCuadrado(request);
		
		Cuadrado cuadradoBBDD= repository.save(cuadrado);
		
		return getCuadradoResponse(cuadradoBBDD);
	}

	public Cuadrado updateCuadrado(Cuadrado cuadrado){
		return repository.save(cuadrado);
	}

	public void deleteCuadrado(Cuadrado cuadrado){
		repository.delete(cuadrado);
	}

	public void deleteCuadrado(Long id){
		repository.deleteById(id);
	}

	public List<Cuadrado> getAllCuadrados(){
		return repository.findAll();
	}

	public long countCuadrados(){
		return repository.count();
	}
	
	public Double calculateSuperficie(Double base) {
		return base * base;
	}

	/**
	 * Private
	 **/

	private Cuadrado getCuadrado(CuadradoRequest request) {
		
		Cuadrado cuadrado = (Cuadrado) FactoryFiguras.getFiguraGeometrica(TipoFigura.CUADRADO);
		
		cuadrado.setBase(request.getBase());
		cuadrado.setAltura(request.getBase());
		cuadrado.setSuperficie(calculateSuperficie(request.getBase()));

		return cuadrado;
	}

	private CuadradoResponse getCuadradoResponse(Cuadrado cuadrado){

		CuadradoResponse response = new CuadradoResponse();
		
		response.setId(cuadrado.getId());
		response.setBase(cuadrado.getBase());
		response.setAltura(cuadrado.getAltura());
		response.setSuperficie(cuadrado.getSuperficie());

		return response;
	}
	
	private void validarCuadradoRequest(CuadradoRequest request) throws BadRequestException {
		
		if (request == null) {
			throw new BadRequestException("Error. El request del cuadrado es vacio");
		}
		if(request.getBase() == null) {
			throw new BadRequestException("Error. El valor de base del request es vacio");
		}
	}
}
