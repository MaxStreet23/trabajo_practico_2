package ar.edu.unju.fi.ejercicio1.model;
public class Producto {
	public enum Origenes{
		ARGENTINA,CHINA,BRASIL,URUGUAY;
	}
	public enum Categorias{
		TELEFONIA,INFORMATICA,ELECTRO_HOGAR,HERRAMIENTAS;
	}
	private String codigo;
	private String descripcion;
	private float precioUnitario;
	private Origenes origenFabricacion;
	private Categorias categoria;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Origenes getOrigenFabricacion() {
		return origenFabricacion;
	}
	public void setOrigenFabricacion(Origenes origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
}
