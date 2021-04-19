package model;

import javax.xml.bind.annotation.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@XmlRootElement(name = "CV")
@XmlAccessorType(XmlAccessType.NONE)

public class CV {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private Integer id;

	@XmlElement
	private String nom;

	@XmlElement
	private String prenom;

	@XmlElement
	private String date;

	@XmlElement
	private String mel;

	public CV(String nom, String prenom, String date, String mel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.mel = mel;
	}

	public CV() {
	}

	@Override
	public String toString() {
		return ("CV [" + nom + " " + prenom + ",Date=" + date + ",mel=" + mel + "]");
	}

	@RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody CV getXML() {
		CV cv = new CV("HAMILTON", "Margaret", "1969/07/21", "Appollo11@nasa.us");
		return cv;
	};

}
