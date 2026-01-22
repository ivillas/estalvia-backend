package cat.estalvia.dto;

import java.time.LocalDateTime;

public class ProducteStatusDTO {

    private LocalDateTime lastUpdate;

    public ProducteStatusDTO(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
