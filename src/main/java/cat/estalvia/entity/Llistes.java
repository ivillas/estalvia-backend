package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(
   name = "llistes"
)
public class Llistes {
    @EmbeddedId
    @Column(name = "llista_id", nullable=false)
    private BigDecimal llista_id;
    
	@Column(name="nom_llista", length=150, nullable=false,unique=false)
	private String nom_llista;
	
    @Column(name = "usuari_id", nullable=false)
    private BigDecimal usuari_id;
   
	@Column(name="visibilitat", length=20, nullable=true,unique=false)
	private String visibilitat;
    
	@Column(name = "data_creacio", nullable=true,unique=false)
	private Date data_creacio;

	public BigDecimal getLlista_id() {
		return llista_id;
	}

	public void setLlista_id(BigDecimal llista_id) {
		this.llista_id = llista_id;
	}

	public String getNom_llista() {
		return nom_llista;
	}

	public void setNom_llista(String nom_llista) {
		this.nom_llista = nom_llista;
	}

	public BigDecimal getUsuari_id() {
		return usuari_id;
	}

	public void setUsuari_id(BigDecimal usuari_id) {
		this.usuari_id = usuari_id;
	}

	public String getVisibilitat() {
		return visibilitat;
	}

	public void setVisibilitat(String visibilitat) {
		this.visibilitat = visibilitat;
	}

	public Date getData_creacio() {
		return data_creacio;
	}

	public void setData_creacio(Date data_creacio) {
		this.data_creacio = data_creacio;
	}
     
  
}
