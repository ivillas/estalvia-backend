package cat.estalvia.service;



import cat.estalvia.dto.ProductePreusDTO;
import cat.estalvia.repository.ProducteRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ProducteService {
   private final ProducteRepository repository;

   public ProducteService(ProducteRepository repository) {
      this.repository = repository;
   }

   public List<ProductePreusDTO> getProductosConPrecios() {
	    Map<Long, ProductePreusDTO> map = new LinkedHashMap<>();
	    List<Object[]> results = this.repository.findAllWithPrices();

	    for (Object[] row : results) {
	        Long id = (Long) row[0]; // Usamos el nombre del campo en la clase Producte
	        
	        ProductePreusDTO dto = map.computeIfAbsent(id, k -> {
	            ProductePreusDTO d = new ProductePreusDTO();
	            d.setProducteId(id);
	            d.setMarca((String) row[1]);
	            d.setNombre((String) row[2]);
	            d.setUnidad((String) row[3]);
	            d.setPack((String) row[4]);
	            
	            // Campos nuevos
	            d.setDescripcio((String) row[7]);
	            d.setImatge((String) row[8]);
	            d.setLastUpdate((java.time.LocalDateTime) row[9]);
	            d.setEnvase((String) row[10]);
	            
	            return d;
	        });

	        String supermercado = (String) row[5];
	        java.math.BigDecimal precio = (java.math.BigDecimal) row[6];
	        dto.getPrecios().put(supermercado, precio);
	    }
	    return new ArrayList<>(map.values());
	}
}
