package com.geometria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geometria.dto.request.CirculoRequest;
import com.geometria.dto.response.CirculoResponse;
import com.geometria.enums.TipoFigura;
import com.geometria.exceptions.BadRequestException;
import com.geometria.exceptions.NoContentException;
import com.geometria.factory.FactoryFiguras;
import com.geometria.model.Circulo;
import com.geometria.repository.CirculoRepository;

@Service
public class CirculoService {

	@Autowired
	private CirculoRepository repository;

	/**
	 * Public 
	 **/

	public Circulo getCirculo(Long id) throws NoContentException{

		return repository.findById(id).orElseThrow(() -> new NoContentException("No se ha encontrado un circulo con id: " + id));
	}

	public CirculoResponse getCirculoResponse(Long id) throws NoContentException{

		Circulo circuloBBDD = repository.findById(id).orElse(null);

		if (circuloBBDD != null) {
			return getCirculoResponse(circuloBBDD);
		}else {
			throw new NoContentException("No se ha encontrado un circulo con id: " + id);
		}
	}

	public Circulo saveCirculo(Circulo circulo){
		return repository.save(circulo);
	}

	public CirculoResponse saveCirculoRequest(CirculoRequest request) throws BadRequestException{
		
		validarCirculoRequest(request);

		Circulo circulo = getCirculo(request);

		Circulo circuloBBDD= repository.save(circulo);

		return getCirculoResponse(circuloBBDD);
	}

	public Circulo updateCirculo(Circulo circulo){
		return repository.save(circulo);
	}

	public void deleteCirculo(Circulo circulo){
		repository.delete(circulo);
	}

	public void deleteCirculo(Long id){
		repository.deleteById(id);
	}

	public List<Circulo> getAllCirculos(){
		return repository.findAll();
	}

	public long countCirculos(){
		return repository.count();
	}

	public Double calculateDiametro(Double radio) {
		return radio * 2;
	}

	public Double calculateSuperficie(Double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

	/**
	 * Private
	 **/

	private Circulo getCirculo(CirculoRequest request) {

		Circulo circulo = (Circulo) FactoryFiguras.getFiguraGeometrica(TipoFigura.CIRCULO);

		circulo.setRadio(request.getRadio());
		circulo.setDiametro(calculateDiametro(request.getRadio()));
		circulo.setSuperficie(calculateSuperficie(request.getRadio()));

		return circulo;
	}

	private CirculoResponse getCirculoResponse(Circulo circulo){

		CirculoResponse response = new CirculoResponse();

		response.setId(circulo.getId());
		response.setRadio(circulo.getRadio());
		response.setDiametro(circulo.getDiametro());
		response.setSuperficie(circulo.getSuperficie());

		return response;
	}

	private void validarCirculoRequest(CirculoRequest request) throws BadRequestException {

		if (request == null) {
			throw new BadRequestException("Error. El request del circulo es vacio");
		}
		if(request.getRadio() == null) {
			throw new BadRequestException("Error. El valor de radio del request es vacio");
		}
	}
}
