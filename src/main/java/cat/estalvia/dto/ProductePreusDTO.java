package cat.estalvia.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;



/**
 * DTO per els productes (amb els seus diferents preus)
 */

public class ProductePreusDTO {
	private Long producteId;
	private String marca;
	private String nombre;
	private String unidad;
	private String pack;
	private String descripcio;
	private String imatge;
	private java.time.LocalDateTime lastUpdate;
	private String envase;
	private Map<String, BigDecimal> precios = new HashMap();

	public Long getProducteId() {
		return this.producteId;
	}

	public void setProducteId(Long producteId) {
		this.producteId = producteId;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getPack() {
		return this.pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public Map<String, BigDecimal> getPrecios() {
		return this.precios;
	}

	public void setPrecios(Map<String, BigDecimal> precios) {
		this.precios = precios;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getImatge() {
		return imatge;
	}

	public void setImatge(String imatge) {
		this.imatge = imatge;
	}

	public java.time.LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getEnvase() {
		return envase;
	}

	public void setEnvase(String envase) {
		this.envase = envase;
	}




}
