package com.mksistemas.webhook.controllers.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mksistemas.webhook.MksistemaswebhookApplication;

import br.com.mksistemas.base.negocio.MensagensDeResposta;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaContexto;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaRequisicao;
import br.com.mksistemas.rna.empresa.registrar.RegistrarEmpresaResposta;
import br.com.mksistemas.rna.fluxos.padrao.IFluxoRNAPadrao;

@SpringBootTest(classes = MksistemaswebhookApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class EmpresaControllerIntegrationTest {

	@Autowired
	ObjectMapper jsonMapper;

	@Autowired
	private MockMvc mvc;

	@Autowired
	IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> registrarEmpresa;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRegistrarEmpresaCorreta() throws Exception {
		RegistrarEmpresaCommand command = new RegistrarEmpresaCommand();
		command.setId(UUID.randomUUID());
		command.setNome("Empresa Teste");
		command.setCnpj(46388366000180l);

		var jsonData = jsonMapper.writeValueAsString(command);

		var result = mvc
			.perform(post("/api/registrarempresa")
			.content(jsonData)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		
		jsonData = result.getResponse().getContentAsString();
		var resposta = jsonMapper.readValue(jsonData, RegistrarEmpresaRespostaView.class);
		assertEquals(MensagensDeResposta.ProcessamentoValido.getCodigo(), resposta.getResposta().getCodigo());
	}
	
	@Test
	void testRegistrarEmpresaIncorreta() throws Exception {
		String jsonData = "{}";
		var result = mvc
			.perform(post("/api/registrarempresa")
			.content(jsonData)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		
		jsonData = result.getResponse().getContentAsString();
		var resposta = jsonMapper.readValue(jsonData, RegistrarEmpresaRespostaView.class);
		assertEquals(MensagensDeResposta.IdentificadorInvalido.getCodigo(), resposta.getResposta().getCodigo());
	}

}

interface IRegistrarEmpresa
		extends IFluxoRNAPadrao<RegistrarEmpresaRequisicao, RegistrarEmpresaResposta, RegistrarEmpresaContexto> {

}
