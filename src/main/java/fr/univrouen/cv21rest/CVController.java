package fr.univrouen.cv21rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CVController {
	
	@RestController
	public class GetController {
		@GetMapping("/resume")
		public String getListCVinXML() {
			return "Envoi de la liste des CV";
		}

		@GetMapping("/id")
		public String getCVinXML(@RequestParam(value = "name") String texte) {
			return ("Détail du CV demandé : " + texte);
		}

		@GetMapping("/test")
		public String getTestnbXML(@RequestParam(value = "nb") int nb, @RequestParam(value = "texte") String texte) {
			return new StringBuilder("Test : </br>id = ").append(nb).append("</br>titre = ").append(texte).toString();
		}
	}
	
	@RestController
	public class PostController {
		@RequestMapping(value = "/testpost", method = RequestMethod.POST, consumes = "application/xml")
		public String postTest(@RequestBody String cv) {
			return ("<result><response>Message reçu : </response>" + cv + "</result>");
		}
	}

}
