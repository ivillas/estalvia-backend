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
public class Categories {
   @EmbeddedId
   @Column(name = "parent_id", nullable=false)
   private BigDecimal Categoria_ID;
   
   
   @Column(name="nom", length=100, nullable=false, unique=false)
   private String nom;
   
   @Column(name = "parent_id", precision = 10, scale = 2)
   private BigDecimal parent_id;

   public BigDecimal getCategoria_ID() {
	return Categoria_ID;
   }

   public void setCategoria_ID(BigDecimal categoria_ID) {
	Categoria_ID = categoria_ID;
   }

   public String getNom() {
	return nom;
   }

   public void setNom(String nom) {
	this.nom = nom;
   }

   public BigDecimal getParent_id() {
	return parent_id;
   }

   public void setParent_id(BigDecimal parent_id) {
	this.parent_id = parent_id;
   }




   
}
