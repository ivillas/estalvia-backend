package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@Entity
@Table(
   name = "productes__favorits"
)
public class ProductesFavorits {
    @Id
    @Column(name = "user_id", nullable=false)
    private Long user_id;
   
    @Column(name = "producte_id", nullable=false)
    private Long producte_id;
	
	@Column(name = "data_favorit", nullable=true,unique=false)
	private LocalDateTime data_favorit;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getProducte_id() {
		return producte_id;
	}

	public void setProducte_id(Long producte_id) {
		this.producte_id = producte_id;
	}

	public LocalDateTime getData_favorit() {
		return data_favorit;
	}

	public void setData_favorit(LocalDateTime data_favorit) {
		this.data_favorit = data_favorit;
	}
	
    
 
    
  
}
