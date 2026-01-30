package cat.estalvia.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "item_llista"
)
public class ItemLlista {
    @Id
    @Column(name = "item_id", nullable=false)
    private Long item_id;
    
    @Column(name = "llista_id", nullable=false)
    private Long llista_id;
   
    @Column(name = "producte_id", nullable=false)
    private Long producte_id;
   
	@Column(name="quantitat", precision =10, scale= 3, nullable=false,
			unique=false)
	private BigDecimal quantitat;
	
	@Column(name="unitat", length=20, nullable=true,unique=false)
	private String unitat;
	   
    @Column(name = "supermercat_preferit_id", nullable=true,unique=false)
    private Long supermercat_preferit_id;
   
    @Column(name = "marcada", nullable=true,unique=false)
    private Boolean marcada;

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getLlista_id() {
		return llista_id;
	}

	public void setLlista_id(Long llista_id) {
		this.llista_id = llista_id;
	}

	public Long getProducte_id() {
		return producte_id;
	}

	public void setProducte_id(Long producte_id) {
		this.producte_id = producte_id;
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

	public Long getSupermercat_preferit_id() {
		return supermercat_preferit_id;
	}

	public void setSupermercat_preferit_id(Long supermercat_preferit_id) {
		this.supermercat_preferit_id = supermercat_preferit_id;
	}

	public Boolean getMarcada() {
		return marcada;
	}

	public void setMarcada(Boolean marcada) {
		this.marcada = marcada;
	}
 
    
  
}
