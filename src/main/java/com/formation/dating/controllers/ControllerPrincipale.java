
package com.formation.dating.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.formation.dating.entities.Adresse;
import com.formation.dating.entities.Apparence;
import com.formation.dating.entities.CentreInteret;
import com.formation.dating.entities.Multimedia;
import com.formation.dating.entities.Photo;
import com.formation.dating.entities.Situation;
import com.formation.dating.entities.Utilisateur;
import com.formation.dating.enumerations.AdressePrefixe;
import com.formation.dating.enumerations.AdresseTypeRue;
import com.formation.dating.enumerations.Alcool;
import com.formation.dating.enumerations.CouleurCheveux;
import com.formation.dating.enumerations.CouleurYeux;
import com.formation.dating.enumerations.Fumer;
import com.formation.dating.enumerations.Orientation;
import com.formation.dating.enumerations.Origin;
import com.formation.dating.enumerations.StatutPerso;
import com.formation.dating.enumerations.StatutPro;
import com.formation.dating.enumerations.TypeCheuveux;
import com.formation.dating.enumerations.TypeMultimedia;
import com.formation.dating.services.AdresseService;
import com.formation.dating.services.ApparenceService;
import com.formation.dating.services.CentreInteretService;
import com.formation.dating.services.MultimediaService;
import com.formation.dating.services.PhotoService;
import com.formation.dating.services.SituationService;
import com.formation.dating.services.UtilisateurService;

@Controller
public class ControllerPrincipale {
	private final UtilisateurService userService;
	private final AdresseService adresseService;
	private final SituationService situationService;
	private final ApparenceService apparenceService;
	private final PhotoService photoService;
	private final CentreInteretService centreInteretService;
	private final MultimediaService multimediaService;
	private static String UPLOADED_FOLDER = "C://Users//Formation.M2I-JAV5-04//Desktop//wafa//Workspace//Dating-master//src//main//resources//static//images//users_pictures//";

//	public ControllerPrincipale() {
//		
//	}

	@Autowired
	public ControllerPrincipale(UtilisateurService userService, AdresseService adresseService,
			SituationService situationService, ApparenceService apparenceService, PhotoService photoService,
			CentreInteretService centreInteretService, MultimediaService multimediaService) {
		
		this.userService = userService;
		this.adresseService = adresseService;
		this.situationService = situationService;
		this.apparenceService = apparenceService;
		this.photoService = photoService;
		this.centreInteretService = centreInteretService;
		this.multimediaService = multimediaService;
	}

	@GetMapping(value = "/")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("index.html");
		mav.addObject("users", userService.getAll());
		return mav;
	}

	@GetMapping(value = "/profile")
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView("profile.html");
		mav.addObject("users", userService.getAll());
		return mav;
	}

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
		mav.addObject("prefixes", AdressePrefixe.values());
		mav.addObject("typerues", AdresseTypeRue.values());
		mav.addObject("alcool", Alcool.values());
		System.out.println(CouleurCheveux.values().toString());
		mav.addObject("couleurcheveux", CouleurCheveux.values());
		mav.addObject("couleuryeux", CouleurYeux.values());
		mav.addObject("fumer", Fumer.values());
		mav.addObject("orientation", Orientation.values());
		mav.addObject("origin", Origin.values());
		mav.addObject("statutPerso", StatutPerso.values());
		mav.addObject("statutPro", StatutPro.values());
		mav.addObject("typecheveux", TypeCheuveux.values());
		mav.addObject("typeMulti", TypeMultimedia.values());
		return mav;
	}

	@GetMapping(value = "/desinscription")
	public ModelAndView desincrire() {
		ModelAndView mav = new ModelAndView("desinscription.html");
		mav.addObject("user", new Utilisateur());
		return mav;
	}

	@PostMapping(value = "/desinscription")
	public String desincrirePost(@Valid @ModelAttribute(value = "user") Utilisateur user) {
		Utilisateur us = userService.findUtilisateurByEmail(user.getEmail());
		if (us != null) {
			userService.delete(user);
			return "redirect:/";

		}
		return "redirect:/connexion";

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute(value = "user") Utilisateur user, BindingResult userResult,
			@Valid @ModelAttribute(value = "adresse") Adresse adresse, BindingResult adresseResult,
			@Valid @ModelAttribute(value = "situation") Situation situation, BindingResult situationResult,
			@Valid @ModelAttribute(value = "apparence") Apparence apparence, BindingResult apparenceResult,
			@Valid @ModelAttribute(value = "photo") Photo photo, BindingResult photoResult,
			@Valid @ModelAttribute(value = "multimedia") Multimedia media, BindingResult mediaResult,
			@Valid @ModelAttribute(value = "centreInteret") CentreInteret centreInteret, BindingResult ciResult) {

		adresseService.add(adresse);
		situationService.add(situation);
		apparenceService.add(apparence);
		photoService.add(photo);
		multimediaService.add(media);
		user.setAdresse(adresse);
		user.setApparence(apparence);
		user.setSituation(situation);
		List<Multimedia> medias = new ArrayList<Multimedia>();
		medias.add(media);
		centreInteret.setMultimedias(medias);
		centreInteretService.add(centreInteret);
		List<Photo> photos = new ArrayList<Photo>();
		photos.add(photo);
		user.setPhotos(photos);
		userService.add(user);
		ModelAndView mav = new ModelAndView("upload.html").addObject("user", user);
		return mav;
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute(value = "user") Utilisateur user, RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select an image");
			return "error";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			Utilisateur us = userService.findUtilisateurByEmail(user.getEmail());
			if (us != null) {
				Photo pic = new Photo();
				pic.setLien(file.getOriginalFilename());
				System.out.println(file.getOriginalFilename());
				List<Photo> photos = new ArrayList<Photo>();
				photoService.add(pic);
				photos.add(pic);
				us.setPhotos(photos);
				userService.update(us);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/connexion";
	}

	@GetMapping(value = "/upload")
	public ModelAndView upload() {
		ModelAndView mav = new ModelAndView("upload.html");
		mav.addObject("user", new Utilisateur());
		// mav.addObject("photo",new Photo());
		return mav;
		// return "upload";
	}

	@GetMapping(value = "/connexion")
	public String affichConnect(ModelMap modelmap) {
		modelmap.addAttribute("user", new Utilisateur());
		return "connexion";
	}

	@GetMapping(value = "/acceuil")
	public String home(ModelMap map) {
		//System.out.println(userService.getAll());
		map.addAttribute("users", userService.getAll());
		map.addAttribute("favori", new Utilisateur());
		return "acceuil";
	}
    
	@PostMapping(value = "/acceuil")
	public String AjoutFavori(@Valid @ModelAttribute(value = "favori") Utilisateur favori, HttpSession session) {
		System.out.println(favori);
		Utilisateur fav = userService.findUtilisateurByEmail(favori.getEmail());
		if (fav != null) {
			Utilisateur user=(Utilisateur) session.getAttribute("user");
			if(user!=null)
			{
				ArrayList<Utilisateur> favoris= (ArrayList<Utilisateur>) user.getFavoris();
				if(favoris==null)
				{
					ArrayList<Utilisateur> favs= new ArrayList<Utilisateur>();
					favs.add(fav);
				}
				else
				{
					favoris.add(fav);
				}
				user.setFavoris(favoris);
				userService.update(user);
			}
		}
		
		
		return "acceuil";
	}
	@PostMapping(value = "/connexion")
	public String verifConnect(@ModelAttribute(value = "user") Utilisateur utilisateur, HttpSession httpsession) {
		System.out.println(utilisateur.getEmail() + utilisateur.getMotDePass());
		Utilisateur us = userService.findUtilisateurByEmailAndMotDePass(utilisateur.getEmail(),
				utilisateur.getMotDePass());
		// System.out.println(us.getEmail() +
		// us.getMotDePass()+us.getAdresse().getVille());
		if (us != null) {
			session(httpsession, us);
			return "redirect:/profile";
		}

		return "connexion";
	}
    
	public void session(HttpSession httpsession, Utilisateur user) {
		String sessionKey = "dating";
		httpsession.setAttribute("sessionKey", sessionKey);
		Object time = httpsession.getAttribute(sessionKey);
		if (time == null) {
			time = LocalDateTime.now();
			httpsession.setAttribute(sessionKey, time);
		}
		httpsession.setAttribute("user", user);
		httpsession.setAttribute("name", sessionKey);
		httpsession.setAttribute("email", user.getEmail());
		httpsession.setAttribute("pseudo", user.getPseudo());
		httpsession.setAttribute("pic", user.getPhotos().get(0));
		// httpsession.setMaxInactiveInterval(30);
	}

	@GetMapping(value = "/deconnexion")
	public String logout(HttpSession httpsession) {
		httpsession.invalidate();

		return "redirect:/";
	}
}
