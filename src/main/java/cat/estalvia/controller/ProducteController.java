package cat.estalvia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.dto.ProductePreusDTO;
import cat.estalvia.service.ProducteService;

@RestController
@RequestMapping("/api/productos")
public class ProducteController {

    private final ProducteService service;

    public ProducteController(ProducteService service) {
        this.service = service;
    }

    @GetMapping("/con-precios")
    public List<ProductePreusDTO> getProductosConPrecios() {
        return service.getProductosConPrecios();
    }
}
