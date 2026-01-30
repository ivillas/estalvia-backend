package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
   name = "preus"
)
public class Preu {
   @EmbeddedId
   private PreuId id;
   @Column(
      name = "preu",
      precision = 10,
      scale = 2
   )
   private BigDecimal preu;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @MapsId("producteId")
   @JoinColumn(
      name = "producte_id"
   )
   private Producte producte;
   @ManyToOne(
      fetch = FetchType.LAZY
   )
   @MapsId("supermercatId")
   @JoinColumn(
      name = "supermercat_id"
   )
   private Supermercat supermercat;
   @Column(
      name = "data_preu"
   )
   private LocalDateTime dataPreu;
   @Column(
      name = "last_update"
   )
   private LocalDateTime lastUpdate;

   public PreuId getId() {
      return this.id;
   }

   public void setId(PreuId id) {
      this.id = id;
   }

   public BigDecimal getPreu() {
      return this.preu;
   }

   public void setPreu(BigDecimal preu) {
      this.preu = preu;
   }

   public Producte getProducte() {
      return this.producte;
   }

   public void setProducte(Producte producte) {
      this.producte = producte;
   }

   public Supermercat getSupermercat() {
      return this.supermercat;
   }

   public void setSupermercat(Supermercat supermercat) {
      this.supermercat = supermercat;
   }

   public LocalDateTime getDataPreu() {
      return this.dataPreu;
   }

   public void setDataPreu(LocalDateTime dataPreu) {
      this.dataPreu = dataPreu;
   }

   public LocalDateTime getLastUpdate() {
      return this.lastUpdate;
   }

   public void setLastUpdate(LocalDateTime lastUpdate) {
      this.lastUpdate = lastUpdate;
   }
}