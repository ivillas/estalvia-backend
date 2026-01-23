package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(
   name = "productes_equivalents"
)
public class ProductesEquivalents {
    @EmbeddedId
    @Column(name = "producte_id_base", nullable=false)
    private BigDecimal producte_id_base;
    
    @Column(name = "producte_id_equivalent", nullable=false)
    private BigDecimal producte_id_equivalent;
   
	@Column(name="grau_similitud", precision =3, scale= 2, nullable=true, unique=false)
	private int grau_similitud;

	public BigDecimal getProducte_id_base() {
		return producte_id_base;
	}

	public void setProducte_id_base(BigDecimal producte_id_base) {
		this.producte_id_base = producte_id_base;
	}

	public BigDecimal getProducte_id_equivalent() {
		return producte_id_equivalent;
	}

	public void setProducte_id_equivalent(BigDecimal producte_id_equivalent) {
		this.producte_id_equivalent = producte_id_equivalent;
	}

	public int getGrau_similitud() {
		return grau_similitud;
	}

	public void setGrau_similitud(int grau_similitud) {
		this.grau_similitud = grau_similitud;
	}
	
	
    
  
}
