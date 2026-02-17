package cat.estalvia.controller;


/**
 * Clase per controller per gestio dels productes
 */


import cat.estalvia.dto.ProductePreusDTO;
import cat.estalvia.service.ProducteService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/productos"})
public class ProducteController {
	private final ProducteService service;

	public ProducteController(ProducteService service) {
		this.service = service;
	}

	/**
	 * Per obtenir els prodcutes de la base de dades amb els preus
	 * @return llista de cada producte mab els diferents preus
	 */

	@GetMapping({"/con-precios"})
	public List<ProductePreusDTO> getProductosConPrecios() {
		return this.service.getProductosConPrecios();
	}

}
