package cat.estalvia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productes")
public class Producte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producteId;

    private String marca;
    private String nomProducte;
    private String unitat;
    private String quantitatUnitat;
	public Long getProducteId() {
		return producteId;
	}
	public void setProducteId(Long producteId) {
		this.producteId = producteId;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNomProducte() {
		return nomProducte;
	}
	public void setNomProducte(String nomProducte) {
		this.nomProducte = nomProducte;
	}
	public String getUnitat() {
		return unitat;
	}
	public void setUnitat(String unitat) {
		this.unitat = unitat;
	}
	public String getQuantitatUnitat() {
		return quantitatUnitat;
	}
	public void setQuantitatUnitat(String quantitatUnitat) {
		this.quantitatUnitat = quantitatUnitat;
	}
    
    

}
