package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(
   name = "categories"
)
public class ItemLlista {
    @EmbeddedId
    @Column(name = "item_id", nullable=false)
    private BigDecimal item_id;
    
    @Column(name = "llista_id", nullable=false)
    private BigDecimal llista_id;
   
    @Column(name = "producte_id", nullable=false)
    private BigDecimal producte_id;
   
	@Column(name="quantitat", precision =10, scale= 3, nullable=false,
			unique=false)
	private int quantitat;
	
	@Column(name="unitat", length=20, nullable=true,unique=false)
	private String unitat;
	   
    @Column(name = "supermercat_preferit_id", nullable=true,unique=false)
    private BigDecimal supermercat_preferit_id;
   
    @Column(name = "marcada", nullable=true,unique=false)
    private Boolean marcada;

	public BigDecimal getItem_id() {
		return item_id;
	}

	public void setItem_id(BigDecimal item_id) {
		this.item_id = item_id;
	}

	public BigDecimal getLlista_id() {
		return llista_id;
	}

	public void setLlista_id(BigDecimal llista_id) {
		this.llista_id = llista_id;
	}

	public BigDecimal getProducte_id() {
		return producte_id;
	}

	public void setProducte_id(BigDecimal producte_id) {
		this.producte_id = producte_id;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public String getUnitat() {
		return unitat;
	}

	public void setUnitat(String unitat) {
		this.unitat = unitat;
	}

	public BigDecimal getSupermercat_preferit_id() {
		return supermercat_preferit_id;
	}

	public void setSupermercat_preferit_id(BigDecimal supermercat_preferit_id) {
		this.supermercat_preferit_id = supermercat_preferit_id;
	}

	public Boolean getMarcada() {
		return marcada;
	}

	public void setMarcada(Boolean marcada) {
		this.marcada = marcada;
	}
 
    
  
}
