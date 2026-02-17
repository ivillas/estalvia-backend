package cat.estalvia.dto;

import java.time.LocalDateTime;


/**
 * DTO per l'ultima actualitzacio de preus
 */

public class ProducteStatusDTO {

	private LocalDateTime lastUpdate;

	public ProducteStatusDTO(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
}
