package cat.estalvia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cat.estalvia.dto.ProductePreusDTO;
import cat.estalvia.repository.ProducteRepository;

@Service
public class ProducteService {

    private final ProducteRepository repository;

    public ProducteService(ProducteRepository repository) {
        this.repository = repository;
    }

    public List<ProductePreusDTO> getProductosConPrecios() {

        Map<Long, ProductePreusDTO> map = new LinkedHashMap<>();

        for (Object[] row : repository.findAllWithPrices()) {

            Long id = (Long) row[0];

            ProductePreusDTO dto = map.computeIfAbsent(id, k -> {
                ProductePreusDTO d = new ProductePreusDTO();
                d.setProducteId(id);
                d.setMarca((String) row[1]);
                d.setNombre((String) row[2]);
                d.setUnidad((String) row[3]);
                d.setPack((String) row[4]);
                return d;
            });

            String supermercado = (String) row[5];
            BigDecimal precio = (BigDecimal) row[6];

            dto.getPrecios().put(supermercado, precio);
        }

        return new ArrayList<>(map.values());
    }
}