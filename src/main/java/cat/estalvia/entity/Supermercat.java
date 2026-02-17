package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Entitat Supermercat
 */

@Entity
@Table(
		name = "supermercats"
		)
public class Supermercat {
	@Id
	@Column(
			name = "supermercat_id"
			)
	private Long supermercatId;
	@Column(
			name = "nom"
			)
	private String nom;
	@Column(
			name = "web"
			)
	private String web;
	@Column(
			name = "actiu"
			)
	private Boolean actiu;

	public Supermercat() {
	}

	public Supermercat(Long supermercatId, String nom) {
		this.supermercatId = supermercatId;
		this.nom = nom;
	}

	public Long getSupermercatId() {
		return this.supermercatId;
	}

	public void setSupermercatId(Long supermercatId) {
		this.supermercatId = supermercatId;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Boolean getActiu() {
		return this.actiu;
	}

	public void setActiu(Boolean actiu) {
		this.actiu = actiu;
	}
}
