package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "llistes"
)
public class Llistes {
    @Id
    @Column(name = "llista_id", nullable=false)
    private Long llista_id;
    
	@Column(name="nom_llista", length=150, nullable=false,unique=false)
	private String nom_llista;
	
    @Column(name = "usuari_id", nullable=false)
    private Long usuari_id;
   
	@Column(name="visibilitat", length=20, nullable=true,unique=false)
	private String visibilitat;
    
	@Column(name = "data_creacio", nullable=true,unique=false)
	private LocalDateTime  data_creacio;

	public Long getLlista_id() {
		return llista_id;
	}

	public void setLlista_id(Long llista_id) {
		this.llista_id = llista_id;
	}

	public String getNom_llista() {
		return nom_llista;
	}

	public void setNom_llista(String nom_llista) {
		this.nom_llista = nom_llista;
	}

	public Long getUsuari_id() {
		return usuari_id;
	}

	public void setUsuari_id(Long usuari_id) {
		this.usuari_id = usuari_id;
	}

	public String getVisibilitat() {
		return visibilitat;
	}

	public void setVisibilitat(String visibilitat) {
		this.visibilitat = visibilitat;
	}

	public LocalDateTime  getData_creacio() {
		return data_creacio;
	}

	public void setData_creacio(LocalDateTime  data_creacio) {
		this.data_creacio = data_creacio;
	}
     
  
}
