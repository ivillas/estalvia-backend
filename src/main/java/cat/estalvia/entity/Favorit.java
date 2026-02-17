package cat.estalvia.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Entitat favorits
 */

@Entity
@Table(name = "productes_favorits")
public class Favorit {

	@EmbeddedId
	private FavoritId id;

	@Column(name = "data_favorit")
	private LocalDateTime dataFavorit;

	public Favorit() {
		this.dataFavorit = LocalDateTime.now();
	}

	// --- CLASE PARA LA CLAVE COMPUESTA ---
	@Embeddable
	public static class FavoritId implements Serializable {
		@Column(name = "user_id")
		private Long userId;

		@Column(name = "producte_id")
		private Long producteId;

		public FavoritId() {}
		public FavoritId(Long userId, Long producteId) {
			this.userId = userId;
			this.producteId = producteId;
		}
		// Getters y Setters
		public Long getUserId() { return userId; }
		public void setUserId(Long userId) { this.userId = userId; }
		public Long getProducteId() { return producteId; }
		public void setProducteId(Long producteId) { this.producteId = producteId; }

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof FavoritId favoritId)) return false;
			return Objects.equals(userId, favoritId.userId) && Objects.equals(producteId, favoritId.producteId);
		}
		@Override
		public int hashCode() { return Objects.hash(userId, producteId); }
	}

	// Getters y Setters de Favorit
	public FavoritId getId() { return id; }
	public void setId(FavoritId id) { this.id = id; }
	public LocalDateTime getDataFavorit() { return dataFavorit; }
	public void setDataFavorit(LocalDateTime dataFavorit) { this.dataFavorit = dataFavorit; }
}
