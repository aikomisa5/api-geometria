package com.geometria.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geometria.enums.TipoFigura;
import com.geometria.factory.FactoryFiguras;
import com.geometria.model.Circulo;
import com.geometria.model.Cuadrado;
import com.geometria.model.Triangulo;
import com.geometria.service.CirculoService;
import com.geometria.service.CuadradoService;
import com.geometria.service.TrianguloService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private CirculoService circuloService;

	@Autowired
	private CuadradoService cuadradoService;

	@Autowired
	private TrianguloService trianguloService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Order(1)
	public void postCuadrado() throws Exception {

		Cuadrado cuadrado = (Cuadrado) FactoryFiguras.getFiguraGeometrica(TipoFigura.CUADRADO);
		cuadrado.setBase(20.5d);

		String body = mapper.writeValueAsString(cuadrado);
		assertNotNull(body);

		MvcResult result = mockMvc.perform(post("/figuras-geometricas/cuadrados")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body))
				.andExpect(status().isCreated()).andReturn();

		String response = result.getResponse().getContentAsString();

		Cuadrado cuadradoBBDD = mapper.readValue(response, Cuadrado.class);

		assertNotNull(cuadradoBBDD);
		assertTrue(cuadradoBBDD.getId().equals(1L));
	}

	@Test
	@Order(2)
	public void postCirculo() throws Exception {

		Circulo circulo = (Circulo) FactoryFiguras.getFiguraGeometrica(TipoFigura.CIRCULO);
		circulo.setRadio(10.5d);

		String body = mapper.writeValueAsString(circulo);
		assertNotNull(body);

		MvcResult result = mockMvc.perform(post("/figuras-geometricas/circulos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body))
				.andExpect(status().isCreated()).andReturn();

		String response = result.getResponse().getContentAsString();

		Circulo circuloBBDD = mapper.readValue(response, Circulo.class);

		assertNotNull(circuloBBDD);
		assertTrue(circuloBBDD.getId().equals(1L));
	}

	@Test
	@Order(3)
	public void postTriangulo() throws Exception {

		Triangulo triangulo = (Triangulo) FactoryFiguras.getFiguraGeometrica(TipoFigura.TRIANGULO);
		triangulo.setBase(7.5d);
		triangulo.setAltura(15.2d);

		String body = mapper.writeValueAsString(triangulo);
		assertNotNull(body);

		MvcResult result = mockMvc.perform(post("/figuras-geometricas/triangulos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(body))
				.andExpect(status().isCreated()).andReturn();

		String response = result.getResponse().getContentAsString();

		Triangulo trianguloBBDD = mapper.readValue(response, Triangulo.class);

		assertNotNull(trianguloBBDD);
		assertTrue(trianguloBBDD.getId().equals(1L));
	}

	@Test
	@Order(4)
	public void getCuadrado() throws Exception {

		Cuadrado cuadrado = (Cuadrado) FactoryFiguras.getFiguraGeometrica(TipoFigura.CUADRADO);
		cuadrado.setBase(20.5d);

		Cuadrado cuadradoBBDD = cuadradoService.saveCuadrado(cuadrado);

		assertNotNull(cuadradoBBDD);
		assertNotNull(cuadradoBBDD.getId());

		MvcResult result = mockMvc.perform(get("/figuras-geometricas/cuadrados/{idCuadrado}", cuadradoBBDD.getId()))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();

		Cuadrado response = mapper.readValue(content, Cuadrado.class);

		assertNotNull(response);
		assertNotNull(response.getId());
	}

	@Test
	@Order(5)
	public void getCirculo() throws Exception {

		Circulo circulo = (Circulo) FactoryFiguras.getFiguraGeometrica(TipoFigura.CIRCULO);
		circulo.setRadio(10.5d);

		Circulo circuloBBDD = circuloService.saveCirculo(circulo);

		assertNotNull(circuloBBDD);
		assertNotNull(circuloBBDD.getId());

		MvcResult result = mockMvc.perform(get("/figuras-geometricas/circulos/{idCirculo}", circuloBBDD.getId()))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();

		Circulo response = mapper.readValue(content, Circulo.class);

		assertNotNull(response);
		assertNotNull(response.getId());
	}

	@Test
	@Order(6)
	public void getTriangulo() throws Exception {

		Triangulo triangulo = (Triangulo) FactoryFiguras.getFiguraGeometrica(TipoFigura.TRIANGULO);
		triangulo.setBase(7.5d);
		triangulo.setAltura(15.2d);

		Triangulo trianguloBBDD = trianguloService.saveTriangulo(triangulo);

		assertNotNull(trianguloBBDD);
		assertNotNull(trianguloBBDD.getId());

		MvcResult result = mockMvc.perform(get("/figuras-geometricas/triangulos/{idTriangulo}", trianguloBBDD.getId()))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();

		Triangulo response = mapper.readValue(content, Triangulo.class);

		assertNotNull(response);
		assertNotNull(response.getId());
	}

	@Test
	@Order(7)
	public void getCuadrado204() throws Exception {

		mockMvc.perform(get("/figuras-geometricas/cuadrados/{idCuadrado}", 10000000))
		.andExpect(status().isNoContent());
	}

	@Test
	@Order(8)
	public void getCirculo204() throws Exception {

		mockMvc.perform(get("/figuras-geometricas/circulos/{idCirculo}", 10000000))
		.andExpect(status().isNoContent());
	}

	@Test
	@Order(9)
	public void getTriangulo204() throws Exception {

		mockMvc.perform(get("/figuras-geometricas/triangulos/{idTriangulo}", 10000000))
		.andExpect(status().isNoContent());

	}
}
