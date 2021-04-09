package org.gonra.desafio;

import static org.junit.jupiter.api.Assertions.*;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesafioApplicationTests {

	@Autowired
	ProductController pc;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(pc);
	}

	@Test
	void testCreateTypeProduct() {
		TypeProductDto tp = new TypeProductDto();
		tp.setDescription("Electro");

		TypeProductDto tpresp = pc.addProductType(tp);
		assertTrue(tpresp.getDescription().equals(tp.getDescription()));

	}

	@Test
	void testCreateProduct() {
		TypeProductDto tp = new TypeProductDto();
		tp.setId(1L);
		tp.setDescription("Electro");

		pc.addProductType(tp);

		AddProductDto p = new AddProductDto();
		p.setCode("123456");
		p.setDescription("Producto1");
		p.setProviderPrice(1.5d);
		p.setTypeProductId(1L);

		ProductDto resp = pc.addProduct(p);

		assertTrue(resp.getDescription().equals(p.getDescription()));
	}
}
