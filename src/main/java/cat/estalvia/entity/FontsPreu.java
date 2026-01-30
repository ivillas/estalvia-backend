package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "fonts_preu"
)
public class FontsPreu {
   @Id
   @Column(name = "font_id", nullable=false)
   private Long font_id;
   
	@Column(name="tipus", length=25, nullable=false,
			unique=false)
	private String tipus;
	
   @Column(name="descripcio", length=255, nullable=true, unique=false)
   private String descripcio;
   
   @Column(name = "propietari_user_id")
   private Long propietari_user_id;
   
   @Column(name = "activa")
   private Boolean activa;
 
   @Column(name = "data_creacio")
   private LocalDateTime  data_creacio;

   public Long getFont_id() {
	return font_id;
   }

   public void setFont_id(Long font_id) {
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

   public Long getPropietari_user_id() {
	return propietari_user_id;
   }

   public void setPropietari_user_id(Long propietari_user_id) {
	this.propietari_user_id = propietari_user_id;
   }

   public Boolean getActiva() {
	return activa;
   }

   public void setActi(Boolean activa) {
	this.activa = activa;
   }

   public LocalDateTime  getData_creacio() {
	return data_creacio;
   }

   public void setData_creacio(LocalDateTime  data_creacio) {
	this.data_creacio = data_creacio;
   }
   


   
}
