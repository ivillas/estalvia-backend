package cat.estalvia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.dto.ProducteStatusDTO;
import cat.estalvia.service.ProducteStatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final ProducteStatusService service;

    public StatusController(ProducteStatusService service) {
        this.service = service;
    }

    @GetMapping("/productes")
    public ProducteStatusDTO getProducteStatus() {
        return new ProducteStatusDTO(service.getLastProducteUpdate());
    }
}
