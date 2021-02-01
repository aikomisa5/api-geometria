package com.geometria.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geometria.dto.request.CirculoRequest;
import com.geometria.dto.request.CuadradoRequest;
import com.geometria.dto.request.TrianguloRequest;
import com.geometria.dto.response.CirculoResponse;
import com.geometria.dto.response.CuadradoResponse;
import com.geometria.dto.response.TrianguloResponse;
import com.geometria.service.CirculoService;
import com.geometria.service.CuadradoService;
import com.geometria.service.TrianguloService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("figuras-geometricas")
public class FiguraGeometricaController {

	@Autowired
	private CuadradoService cuadradoService;

	@Autowired
	private TrianguloService trianguloService;

	@Autowired
	private CirculoService circuloService;
	
	@GetMapping("/cuadrados/{idCuadrado}")
	@ApiOperation("Recurso para obtener un cuadrado")
	public ResponseEntity<CuadradoResponse> getCuadrado(
			@ApiIgnore @RequestHeader Map<String, String> headers,
			@PathVariable Long idCuadrado
			) throws Exception{
		
		CuadradoResponse response = cuadradoService.getCuadradoResponse(idCuadrado);
		
		return new ResponseEntity<CuadradoResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/cuadrados")
	@ApiOperation("Recurso para guardar un cuadrado")
	public ResponseEntity<CuadradoResponse> postCuadrado(
			@ApiIgnore @RequestHeader Map<String, String> headers,
			@RequestBody CuadradoRequest cuadrado
			) throws Exception{
		
		CuadradoResponse response = cuadradoService.saveCuadradoRequest(cuadrado);
		
		return new ResponseEntity<CuadradoResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/circulos/{idCirculo}")
	@ApiOperation("Recurso para obtener un circulo")
	public ResponseEntity<CirculoResponse> getCirculo(
			@ApiIgnore @RequestHeader Map<String, String> headers,
			@PathVariable Long idCirculo
			) throws Exception{
		
		CirculoResponse response = circuloService.getCirculoResponse(idCirculo);
		
		return new ResponseEntity<CirculoResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/circulos")
	@ApiOperation("Recurso para guardar un circulo")
	public ResponseEntity<CirculoResponse> postCirculo(
			@ApiIgnore @RequestHeader Map<String, String> headers,
			@RequestBody CirculoRequest circulo
			) throws Exception{
		
		CirculoResponse response = circuloService.saveCirculoRequest(circulo);
		
		return new ResponseEntity<CirculoResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/triangulos/{idTriangulo}")
	@ApiOperation("Recurso para obtener un triangulo")
	public ResponseEntity<TrianguloResponse> getTriangulo(
			@ApiIgnore @RequestHeader Map<String, String> headers,
			@PathVariable Long idTriangulo
			) throws Exception{
		
		TrianguloResponse response = trianguloService.getTrianguloResponse(idTriangulo);
		
		return new ResponseEntity<TrianguloResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/triangulos")
	@ApiOperation("Recurso para guardar un triangulo")
	public ResponseEntity<TrianguloResponse> postTriangulo(
			@ApiIgnore @RequestHeader Map<String, String> headers,
			@RequestBody TrianguloRequest triangulo
			) throws Exception{

		TrianguloResponse response = trianguloService.saveTrianguloRequest(triangulo);

		return new ResponseEntity<TrianguloResponse>(response, HttpStatus.CREATED);
	}
}
