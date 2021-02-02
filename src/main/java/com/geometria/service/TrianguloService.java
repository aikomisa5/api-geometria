package com.geometria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geometria.dto.request.TrianguloRequest;
import com.geometria.dto.response.TrianguloResponse;
import com.geometria.enums.TipoFigura;
import com.geometria.exceptions.BadRequestException;
import com.geometria.exceptions.NoContentException;
import com.geometria.factory.FactoryFiguras;
import com.geometria.model.Triangulo;
import com.geometria.repository.TrianguloRepository;

@Service
public class TrianguloService {

	@Autowired
	private TrianguloRepository repository;
	
	/**
	 * Public 
	 **/
	
	public Triangulo getTriangulo(Long id) throws NoContentException{
		
		return repository.findById(id).orElseThrow(() -> new NoContentException("No se ha encontrado un triangulo con id: " + id));
		
	}
	
	public TrianguloResponse getTrianguloResponse(Long id) throws NoContentException{

		Triangulo trianguloBBDD = repository.findById(id).orElse(null);

		if (trianguloBBDD != null) {
			return getTrianguloResponse(trianguloBBDD);
		}else {
			throw new NoContentException("No se ha encontrado un triangulo con id: " + id);
		}
	}
	
	public Triangulo saveTriangulo(Triangulo triangulo){
		return repository.save(triangulo);
	}
	
	public TrianguloResponse saveTrianguloRequest(TrianguloRequest request) throws BadRequestException{
		
		validarTrianguloRequest(request);
		
		Triangulo triangulo = getTriangulo(request);
		
		Triangulo trianguloBBDD= repository.save(triangulo);
		
		return getTrianguloResponse(trianguloBBDD);
	}

	public Triangulo updateTriangulo(Triangulo triangulo){
		return repository.save(triangulo);
	}

	public void deleteTriangulo(Triangulo triangulo){
		repository.delete(triangulo);
	}

	public void deleteTriangulo(Long id){
		repository.deleteById(id);
	}

	public List<Triangulo> getAllTriangulos(){
		return repository.findAll();
	}

	public long countTriangulos(){
		return repository.count();
	}

	public Double calculateSuperficie(Double base, Double altura) {
		return base * (altura / 2d);
	}
	
	/**
	 * Private
	 **/

	private Triangulo getTriangulo(TrianguloRequest request) {
		
		Triangulo triangulo = (Triangulo) FactoryFiguras.getFiguraGeometrica(TipoFigura.TRIANGULO);

		triangulo.setBase(request.getBase());
		triangulo.setAltura(request.getAltura());
		triangulo.setSuperficie(calculateSuperficie(request.getBase(), request.getAltura()));

		return triangulo;
	}

	private TrianguloResponse getTrianguloResponse(Triangulo triangulo){

		TrianguloResponse response = new TrianguloResponse();

		response.setId(triangulo.getId());
		response.setBase(triangulo.getBase());
		response.setAltura(triangulo.getAltura());
		response.setSuperficie(triangulo.getSuperficie());

		return response;
	}
	
	private void validarTrianguloRequest(TrianguloRequest request) throws BadRequestException {

		if (request == null) {
			throw new BadRequestException("Error. El request del triangulo es vacio");
		}
		if(request.getBase() == null) {
			throw new BadRequestException("Error. El valor de base del request es vacio");
		}
		if(request.getAltura() == null) {
			throw new BadRequestException("Error. El valor de altura del request es vacio");
		}
	}
}
