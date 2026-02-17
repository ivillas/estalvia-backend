package cat.estalvia.dto;


/**
 * DTO per els supermercats
 */ 

public class SupermercatsDTO {
	private Long supermercatId;
	private String nom;
	private String web;
	private boolean actiu;

	public SupermercatsDTO(Long supermercatId, String nom, String web, boolean actiu) {
		this.supermercatId = supermercatId;
		this.nom = nom;
		this.web = web;
		this.actiu = actiu;
	}

	public Long getSupermercatId() {
		return this.supermercatId;
	}

	public String getNom() {
		return this.nom;
	}

	public String getWeb() {
		return this.web;
	}

	public boolean isActiu() {
		return this.actiu;
	}
}
