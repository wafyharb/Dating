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
	@Test
	public void testFindUtilisateurByEmailAndMotDePass() {
          final String email="manel@hotmail.fr";
          final  String motPasse="m";
          Assert.assertNotNull(ur.findUtilisateurByEmailAndMotDePass(email, motPasse));
           
	}

}
