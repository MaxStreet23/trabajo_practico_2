package ar.edu.unju.fi.ejercicio3.constantes;
public enum Provincia {
	JUJUY(811611, 53),
    SALTA(1441351, 155),
    TUCUMAN(1731820, 22),
    CATAMARCA(429562, 103),
    LA_RIOJA(383865, 90),
    SANTIAGO_DEL_ESTERO(1060906, 136);
	private int cantidadPoblacion;
	private int superficie;
	private Provincia() {
	}
	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}
	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidad() {
        return (double)cantidadPoblacion/superficie;
    }	
}
