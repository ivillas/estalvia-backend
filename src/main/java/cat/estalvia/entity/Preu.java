package cat.estalvia.entity;

import java.math.BigDecimal;
import cat.estalvia.entity.Producte;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "preus")
public class Preu {

    @EmbeddedId
    private PreuId id;

    private BigDecimal preu;

    @ManyToOne
    @MapsId("producteId")
    private Producte producte;

    @ManyToOne
    @MapsId("supermercatId")
    private Supermercat supermercat;

	public PreuId getId() {
		return id;
	}

	public void setId(PreuId id) {
		this.id = id;
	}

	public BigDecimal getPreu() {
		return preu;
	}

	public void setPreu(BigDecimal preu) {
		this.preu = preu;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public Supermercat getSupermercat() {
		return supermercat;
	}

	public void setSupermercat(Supermercat supermercat) {
		this.supermercat = supermercat;
	}
    
    
    
    
    
}