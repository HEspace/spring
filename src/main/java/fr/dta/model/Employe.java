package fr.dta.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq_employee",sequenceName="seq_employee",initialValue=1,allocationSize=1)
public class Employe {

	@Id
    @GeneratedValue(generator="seq_employee")
	
	private Long id;
	private String prenom;
	private String nom;
	private String ss;
	private BigDecimal salaire;
	private Date dateEmbauche;
	
	@ManyToOne
	private Entreprise entreprise;

	
	public Employe(){};
	public Employe(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}
	public Employe(Long id, String prenom, String nom, String ss, BigDecimal salaire, Date dateEmbauche) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.ss = ss;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

}
