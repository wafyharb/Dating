package com.formation.dating.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.formation.dating.entities.Utilisateur;
import com.formation.dating.services.AdresseService;
import com.formation.dating.services.ApparenceService;
import com.formation.dating.services.CentreInteretService;
import com.formation.dating.services.MultimediaService;
import com.formation.dating.services.PhotoService;
import com.formation.dating.services.SituationService;
import com.formation.dating.services.UtilisateurService;

@RunWith(SpringRunner.class) // Spring qui s'occupe de test
@WebMvcTest(ControllerPrincipale.class) // preciser la classe sur la quel on va faire les test
@ContextConfiguration
@WebAppConfiguration
public class ControllerPrincipaleTest {

	@Autowired // Injection des dépendances
	MockMvc mockMvc;
	@MockBean
	UtilisateurService userService;
	@MockBean
	AdresseService adresseService;
	@MockBean
	SituationService situationService;
	@MockBean
	ApparenceService apparenceService;
	@MockBean
	PhotoService photoService;
	@MockBean
	CentreInteretService centreInteretService;
	@MockBean
	MultimediaService multimediaService;
	@MockBean
	Utilisateur user;

	// Junit
	// @Autowired
	// private WebApplicationContext context;
	@Test
	public void hello() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(view().name("index.html")).andExpect(status().isOk())// Je demande un
																										// code 200
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute("users",userService.getAll()))
				.andExpect(content().string(containsString("descrip")))

		;
	}
	// @Before
	// public void setup() {
	// mockMvc = MockMvcBuilders
	// .webAppContextSetup(context)
	//
	// .build();
	// }
	@Test
	public void home() throws Exception {
	
		this.mockMvc.perform(get("/acceuil"))
		.andExpect(view().name("acceuil"))
		.andExpect(status().isOk())																	
	    .andExpect(content().contentType("text/html;charset=UTF-8"))
	   // .andExpect(model().attribute("favori",user))	
		;
	}
	@Test
	public void desincrire() throws Exception {
	
		this.mockMvc.perform(get("/desinscription"))
		.andExpect(view().name("desinscription.html"))
		.andExpect(status().isOk())																	
	    .andExpect(content().contentType("text/html;charset=UTF-8"))

	    ;
	}
 
}
