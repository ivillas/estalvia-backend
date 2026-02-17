package cat.estalvia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.dto.ProducteStatusDTO;
import cat.estalvia.service.ProducteStatusService;

/**
 * Controller nomes d'informacio de l'app
 */

@RestController
@RequestMapping("/api/status")
public class StatusController {

	private final ProducteStatusService service;

	public StatusController(ProducteStatusService service) {
		this.service = service;
	}

	/**
	 * PEr coneixer la data de l'ultim producte afegit o modificat
	 * @return data
	 */

	@GetMapping("/productes")
	public ProducteStatusDTO getProducteStatus() {
		return new ProducteStatusDTO(service.getLastProducteUpdate());
	}
}
