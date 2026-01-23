package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(
   name = "preus_historic"
)
public class PreusHistoric {
    @EmbeddedId
    @Column(name = "id", nullable=false)
    private BigDecimal id;
   
    @Column(name = "producte_id", nullable=false)
    private BigDecimal producte_id;
    
    @Column(name = "supermercat_id", nullable=false)
    private BigDecimal supermercat_id;
   
	@Column(name="preu", precision =10, scale= 2, nullable=false, unique=false)
	private int preu;
	
	@Column(name = "data_preu", nullable=true,unique=false)
	private Date data_preu;
	
    @Column(name = "font_id", nullable=false)
    private BigDecimal font_id;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getProducte_id() {
		return producte_id;
	}

	public void setProducte_id(BigDecimal producte_id) {
		this.producte_id = producte_id;
	}

	public BigDecimal getSupermercat_id() {
		return supermercat_id;
	}

	public void setSupermercat_id(BigDecimal supermercat_id) {
		this.supermercat_id = supermercat_id;
	}

	public int getPreu() {
		return preu;
	}

	public void setPreu(int preu) {
		this.preu = preu;
	}

	public Date getData_preu() {
		return data_preu;
	}

	public void setData_preu(Date data_preu) {
		this.data_preu = data_preu;
	}

	public BigDecimal getFont_id() {
		return font_id;
	}

	public void setFont_id(BigDecimal font_id) {
		this.font_id = font_id;
	}
	
	
 
    
  
}
