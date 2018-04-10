package com.formation.dating.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.formation.dating.repositories.UtilisateurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilisateurServiceTest {
	@Autowired
	private UtilisateurRepository ur;
	@Autowired
	private UtilisateurService us;
	@Autowired
//	private Utilisateur user;

	//@Before
//	public void init() {
//		user.setNom("manel");
//		user.setEmail("manel@hotmail.fr");
//		user.setPseudo("manel");
//		user.setMotDePass("m");
//		user.setDateNaissance("2001-02-24");
//		user.setDescription("Je suis Manel");
//		user.setNumTel("0627491388");
//
//	}

	@Test
	public void findUtilisateurByEmailAndMotDePass() {
		String email = "manel@hotmail.fr";
		String motPasse = "m";
		Assert.assertNotNull(us.findUtilisateurByEmailAndMotDePass(email, motPasse));

	
	}
	@Test
	public void findUtilisateurByEmail() {
		

		String email = "mama@hotmail.fr";
		Assert.assertNull(us.findUtilisateurByEmail(email));

	}

}
