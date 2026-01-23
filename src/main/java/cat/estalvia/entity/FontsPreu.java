package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(
   name = "categories"
)
public class FontsPreu {
   @EmbeddedId
   @Column(name = "font_id", nullable=false)
   private BigDecimal font_id;
   
	@Column(name="tipus", length=25, nullable=false,
			unique=false)
	private String tipus;
	
   @Column(name="descripcio", length=255, nullable=true, unique=false)
   private String descripcio;
   
   @Column(name = "propietari_user_id")
   private BigDecimal propietari_user_id;
   
   @Column(name = "activa")
   private Boolean activa;
 
   @Column(name = "data_creacio")
   private Date data_creacio;

   public BigDecimal getFont_id() {
	return font_id;
   }

   public void setFont_id(BigDecimal font_id) {
	this.font_id = font_id;
   }

   public String getTipus() {
	return tipus;
   }

   public void setTipus(String tipus) {
	this.tipus = tipus;
   }

   public String getDescripcio() {
	return descripcio;
   }

   public void setDescripcio(String descripcio) {
	this.descripcio = descripcio;
   }

   public BigDecimal getPropietari_user_id() {
	return propietari_user_id;
   }

   public void setPropietari_user_id(BigDecimal propietari_user_id) {
	this.propietari_user_id = propietari_user_id;
   }

   public Boolean getActiva() {
	return activa;
   }

   public void setActi(Boolean activa) {
	this.activa = activa;
   }

   public Date getData_creacio() {
	return data_creacio;
   }

   public void setData_creacio(Date data_creacio) {
	this.data_creacio = data_creacio;
   }
   


   
}
