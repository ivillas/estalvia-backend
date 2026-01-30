package cat.estalvia.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PreuId implements Serializable {
   private Long producteId;
   private Long supermercatId;

   public PreuId() {
   }

   public PreuId(Long producteId, Long supermercatId) {
      this.producteId = producteId;
      this.supermercatId = supermercatId;
   }

   public Long getProducteId() {
      return this.producteId;
   }

   public void setProducteId(Long producteId) {
      this.producteId = producteId;
   }

   public Long getSupermercatId() {
      return this.supermercatId;
   }

   public void setSupermercatId(Long supermercatId) {
      this.supermercatId = supermercatId;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (!(o instanceof PreuId)) {
         return false;
      } else {
         PreuId that = (PreuId)o;
         return Objects.equals(this.producteId, that.producteId) && Objects.equals(this.supermercatId, that.supermercatId);
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.producteId, this.supermercatId});
   }
}