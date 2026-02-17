package cat.estalvia.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * Entitat Itemo Llista
 */

@Entity
@Table(
		name = "item_llista"
		)
public class ItemLlista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	@ManyToOne
	@JoinColumn(name = "llista_id", nullable = false) 
	private Llista llista;

	@ManyToOne
	@JoinColumn(name = "producte_id", nullable = false)
	private Producte producte;

	private BigDecimal quantitat;
	private String unitat;

	@ManyToOne
	@JoinColumn(name = "supermercat_preferit_id")
	private Supermercat supermercatPreferit;

	private boolean marcada = false;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Llista getLlista() {
		return llista;
	}

	public void setLlista(Llista llista) {
		this.llista = llista;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public BigDecimal getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(BigDecimal quantitat) {
		this.quantitat = quantitat;
	}

	public String getUnitat() {
		return unitat;
	}

	public void setUnitat(String unitat) {
		this.unitat = unitat;
	}

	public Supermercat getSupermercatPreferit() {
		return supermercatPreferit;
	}

	public void setSupermercatPreferit(Supermercat supermercatPreferit) {
		this.supermercatPreferit = supermercatPreferit;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}


	// Getters & Setters



}
