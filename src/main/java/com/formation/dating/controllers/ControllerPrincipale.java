package com.formation.dating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formation.dating.entities.Adresse;
import com.formation.dating.entities.Apparence;
import com.formation.dating.entities.CentreInteret;
import com.formation.dating.entities.Multimedia;
import com.formation.dating.entities.Photo;
import com.formation.dating.entities.Situation;
import com.formation.dating.entities.Utilisateur;
import com.formation.dating.enumeration.AdressePrefixe;
import com.formation.dating.enumeration.AdresseTypeRue;
import com.formation.dating.enumeration.Alcool;
import com.formation.dating.enumeration.CouleurCheveux;
import com.formation.dating.enumeration.CouleurYeux;
import com.formation.dating.enumeration.Fumer;
import com.formation.dating.enumeration.Orientation;
import com.formation.dating.enumeration.Origin;
import com.formation.dating.enumeration.StatutPerso;
import com.formation.dating.enumeration.StatutPro;
import com.formation.dating.enumeration.TypeCheuveux;
import com.formation.dating.enumeration.TypeMultimedia;
import com.formation.dating.services.UtilisateurService;

@Controller
public class ControllerPrincipale {
	private final UtilisateurService userService;

	@Autowired
	public ControllerPrincipale(UtilisateurService userService) {

		this.userService = userService;

	}

	/*
	 * @GetMapping(value = "/") public ModelAndView hello() { ModelAndView mav = new
	 * ModelAndView("index.html"); mav.addObject("user", new Utilisateur()); return
	 * mav; }
	 */
	@GetMapping(value = "/user")
	public ModelAndView inscription() {
		ModelAndView mav = new ModelAndView("formulaire.html");
		mav.addObject("user", new Utilisateur());
		mav.addObject("adresse", new Adresse());
		mav.addObject("situation", new Situation());
		mav.addObject("centreInteret", new CentreInteret());
		mav.addObject("photo", new Photo());
		mav.addObject("apparence", new Apparence());
		mav.addObject("multimedia", new Multimedia());
		mav.addObject("prefixes",AdressePrefixe.values());
		mav.addObject("typerues",AdresseTypeRue.values());
		mav.addObject("alcool",Alcool.values());
		mav.addObject("couleurcheveux",CouleurCheveux.values());
		mav.addObject("couleuryeux",CouleurYeux.values());
		mav.addObject("fumer",Fumer.values());
		mav.addObject("orientation",Orientation.values());
		mav.addObject("origin", Origin.values());
		mav.addObject("statutPerso",StatutPerso.values());
		mav.addObject("statutPro",StatutPro.values());
		mav.addObject("typeCheveux",TypeCheuveux.values());
		mav.addObject("typeMulti",TypeMultimedia.values());
		
		
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView add(@Validated Utilisateur user) {

		userService.add(user);
		return new ModelAndView("connexion.html").addObject("user", user);
	}

}
