package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "preus_historic"
)
public class PreusHistoric {
    @Id
    @Column(name = "id", nullable=false)
    private Long id;
   
    @Column(name = "producte_id", nullable=false)
    private Long producte_id;
    
    @Column(name = "supermercat_id", nullable=false)
    private Long supermercat_id;
   
	@Column(name="preu", precision =10, scale= 2, nullable=false, unique=false)
	private BigDecimal  preu;
	
	@Column(name = "data_preu", nullable=true,unique=false)
	private LocalDateTime  data_preu;
	
    @Column(name = "font_id", nullable=false)
    private Long font_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProducte_id() {
		return producte_id;
	}

	public void setProducte_id(Long producte_id) {
		this.producte_id = producte_id;
	}

	public Long getSupermercat_id() {
		return supermercat_id;
	}

	public void setSupermercat_id(Long supermercat_id) {
		this.supermercat_id = supermercat_id;
	}

	public BigDecimal  getPreu() {
		return preu;
	}

	public void setPreu(BigDecimal  preu) {
		this.preu = preu;
	}

	public LocalDateTime  getData_preu() {
		return data_preu;
	}

	public void setData_preu(LocalDateTime  data_preu) {
		this.data_preu = data_preu;
	}

	public Long getFont_id() {
		return font_id;
	}

	public void setFont_id(Long font_id) {
		this.font_id = font_id;
	}
	
	
 
    
  
}
