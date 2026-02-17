package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Entitat Productes Equivalents
 */

@Entity
@Table(
		name = "productes_equivalents"
		)
public class ProductesEquivalents {
	@Id
	@Column(name = "producte_id_base", nullable=false)
	private Long producte_id_base;

	@Column(name = "producte_id_equivalent", nullable=false)
	private Long producte_id_equivalent;

	@Column(name="grau_similitud", precision =3, scale= 2, nullable=true, unique=false)
	private int grau_similitud;

	public Long getProducte_id_base() {
		return producte_id_base;
	}

	public void setProducte_id_base(Long producte_id_base) {
		this.producte_id_base = producte_id_base;
	}

	public Long getProducte_id_equivalent() {
		return producte_id_equivalent;
	}

	public void setProducte_id_equivalent(Long producte_id_equivalent) {
		this.producte_id_equivalent = producte_id_equivalent;
	}

	public int getGrau_similitud() {
		return grau_similitud;
	}

	public void setGrau_similitud(int grau_similitud) {
		this.grau_similitud = grau_similitud;
	}




}
