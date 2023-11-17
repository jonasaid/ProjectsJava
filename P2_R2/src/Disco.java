import java.io.*;

public class Disco implements Serializable{
	private String titulo;
	private String artista;
	private String genero;
	private float precio;
	private String nombreImagen;
	private int cantidad;
	
	public Disco(){
		titulo = "";
		artista = "";
		genero = "";
		precio = 0.0f;
		nombreImagen = "";
		cantidad = 0;
	}
	
	public Disco(String titulo, String artista, String genero, float precio, String nombreImagen, int cantidad){
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.precio = precio;
		this.nombreImagen = nombreImagen;
		this.cantidad = cantidad;
	}
	
	public Disco(Disco disco){
		titulo = disco.getTitulo();
		artista = disco.getArtista();
		genero = disco.getGenero();
		precio = disco.getPrecio();
		nombreImagen = disco.getNombreImagen();
		cantidad = disco.getCantidad();
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setArtista(String artista){
		this.artista = artista;
	}
	
	public String getArtista(){
		return artista;
	}
	
	public void setGenero(String genero){
		this.genero = genero;
	}
	
	public String getGenero(){
		return genero;
	}
	
	public void setPrecio(float precio){
		this.precio = precio;	
	}
	
	public float getPrecio(){
		return precio;
	}
	
	public void setNombreImagen(String nombreImagen){
		this.nombreImagen = nombreImagen;
	}
	
	public String getNombreImagen(){
		return nombreImagen;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public int getCantidad(){
		return cantidad;
	}
}