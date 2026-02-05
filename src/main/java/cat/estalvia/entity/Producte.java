package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "productes"
)
public class Producte {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   @Column(
      name = "producte_id"
   )
   private Long producteId;
   @Column(
      name = "marca"
   )
   private String marca;
   @Column(
      name = "nom_producte"
   )
   private String nomProducte;
   @Column(
      name = "unitat"
   )
   private String unitat;
   @Column(
      name = "quantitat_unitat"
   )
   private String quantitatUnitat;
   private String origen;
   @Column(
      name = "descripcio"
   )
   private String descripcio;
   @Column(
      name = "last_update"
   )   
   private LocalDateTime lastUpdate;
   
   @Column(name = "imatge")
   private String imatge;

   @Column(name = "envase")
   private String envase;

   public String getImatge() {
	return imatge;
}

   public void setImatge(String imatge) {
	this.imatge = imatge;
   }

   public String getEnvase() {
	return envase;
   }

   public void setEnvase(String envase) {
	this.envase = envase;
   }

   public Long getProducteId() {
      return this.producteId;
   }

   public void setProducteId(Long producteId) {
      this.producteId = producteId;
   }

   public String getMarca() {
      return this.marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getNomProducte() {
      return this.nomProducte;
   }

   public void setNomProducte(String nomProducte) {
      this.nomProducte = nomProducte;
   }

   public String getUnitat() {
      return this.unitat;
   }

   public void setUnitat(String unitat) {
      this.unitat = unitat;
   }

   public String getQuantitatUnitat() {
      return this.quantitatUnitat;
   }

   public void setQuantitatUnitat(String quantitatUnitat) {
      this.quantitatUnitat = quantitatUnitat;
   }

   public String getOrigen() {
      return this.origen;
   }

   public void setOrigen(String origen) {
      this.origen = origen;
   }

   public String getDescripcio() {
      return this.descripcio;
   }

   public void setDescripcio(String descripcio) {
      this.descripcio = descripcio;
   }

   public LocalDateTime getLastUpdate() {
      return this.lastUpdate;
   }

   public void setLastUpdate(LocalDateTime lastUpdate) {
      this.lastUpdate = lastUpdate;
   }
}