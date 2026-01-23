package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(
   name = "productes__favorits"
)
public class ProductesFavorits {
    @EmbeddedId
    @Column(name = "user_id", nullable=false)
    private BigDecimal user_id;
   
    @Column(name = "producte_id", nullable=false)
    private BigDecimal producte_id;
	
	@Column(name = "data_favorit", nullable=true,unique=false)
	private Date data_favorit;

	public BigDecimal getUser_id() {
		return user_id;
	}

	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}

	public BigDecimal getProducte_id() {
		return producte_id;
	}

	public void setProducte_id(BigDecimal producte_id) {
		this.producte_id = producte_id;
	}

	public Date getData_favorit() {
		return data_favorit;
	}

	public void setData_favorit(Date data_favorit) {
		this.data_favorit = data_favorit;
	}
	
    
 
    
  
}
