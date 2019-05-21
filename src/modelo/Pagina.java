package modelo;

public class Pagina {
	private int inicioPagina, finPagina, numeroPagina;
	private String textoPagina;
	private boolean paginaMarcada;
	public Pagina(int inicioPagina, int finPagina, int numeroPagina, String textoPagina) {
		this.inicioPagina = inicioPagina;
		this.finPagina = finPagina;
		this.numeroPagina = numeroPagina;
		this.textoPagina = textoPagina;
		this.paginaMarcada=false;
	}
	public int getInicioPagina() {
		return inicioPagina;
	}
	public void setInicioPagina(int inicioPagina) {
		this.inicioPagina = inicioPagina;
	}
	public int getFinPagina() {
		return finPagina;
	}
	public void setFinPagina(int finPagina) {
		this.finPagina = finPagina;
	}
	public int getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	public String getTextoPagina() {
		return textoPagina;
	}
	public void setTextoPagina(String textoPagina) {
		this.textoPagina = textoPagina;
	}
	public boolean isPaginaMarcada() {
		return paginaMarcada;
	}
	public void setPaginaMarcada(boolean paginaMarcada) {
		this.paginaMarcada = paginaMarcada;
	}
	
	

	
}
