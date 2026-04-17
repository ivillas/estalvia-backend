package cat.estalvia.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource; 
import cat.estalvia.dto.ProducteStatusDTO;
import cat.estalvia.service.ProducteStatusService;

/**
 * Controller nomes d'informacio de l'app
 */




@RestController
@RequestMapping("/api/status")
public class StatusController {

	private final ProducteStatusService service;

	
	private final String APK_PATH = "/app/updates";
	
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

	/**
	 * Per coneixer l'ultima versio de la app movil
	 * @return version i url de descàrrega
	 */
	    @GetMapping("/check-update")
	    public Map<String, Object> checkUpdate() {
	        File folder = new File(APK_PATH);
	        File[] files = folder.listFiles((dir, name) -> name.endsWith(".apk"));

	        if (files != null && files.length > 0) {
	            // Lógica simple: ordenar por nombre (estalvia-1.2.apk) y tomar el último
	            Arrays.sort(files, Collections.reverseOrder());
	            File latestApk = files[0];
	            
	            // Extraer versión del nombre "estalvia-1.2.apk" -> 1.2
	            String versionName = latestApk.getName()
	                                    .replace("estalvia-", "")
	                                    .replace(".apk", "");

	            Map<String, Object> response = new HashMap<>();
	            response.put("versionName", versionName);
	            response.put("downloadUrl", "ip_server" + latestApk.getName());
	            return response;
	        }
	        return null; 
	    }
	    
	    /**
		 * Endpoint per descarregar l'apk 
		 * 
		 */
	    @GetMapping("/download/{filename}")
	    public ResponseEntity<Resource> downloadApk(@PathVariable String filename) throws MalformedURLException {
	        Path path = Paths.get(APK_PATH).resolve(filename);
	        Resource resource = new UrlResource(path.toUri());
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }
	
}
