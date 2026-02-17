package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entitat Categories
 */

@Entity
@Table(
		name = "categories"
		)
public class Categories {
	@Id
	@Column(name = "categoria_id", nullable=false)
	private Long Categoria_ID;


	@Column(name="nom", length=100, nullable=false, unique=false)
	private String nom;

	@Column(name = "parent_id", precision = 10, scale = 2)
	private Long parent_id;

	public Long getCategoria_ID() {
		return Categoria_ID;
	}

	public void setCategoria_ID(Long categoria_ID) {
		Categoria_ID = categoria_ID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}





}
