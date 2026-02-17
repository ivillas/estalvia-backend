package cat.estalvia.request;

import java.math.BigDecimal;


/**
 * Request dels items dels productes de les llistes
 */


public class ItemLlistaRequest {

	private Long productoId;
	private BigDecimal cantidad;
	private String unidad;
	private Long supermercadoPreferidoId;


	// getters & setters


	public Long getProductoId() {
		return productoId;
	}
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public Long getSupermercadoPreferidoId() {
		return supermercadoPreferidoId;
	}
	public void setSupermercadoPreferidoId(Long supermercadoPreferidoId) {
		this.supermercadoPreferidoId = supermercadoPreferidoId;
	}





}