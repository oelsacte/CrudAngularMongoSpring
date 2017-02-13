package org.spring.oelsacte;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="libros")
public class Libro implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String titulo;
	private String autor;
	private int paginas;
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getTitulo() 
	{
		return titulo;
	}
	
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	
	public String getAutor() 
	{
		return autor;
	}
	
	public void setAutor(String autor) 
	{
		this.autor = autor;
	}
	
	public int getPaginas() 
	{
		return paginas;
	}
	
	public void setPaginas(int paginas) 
	{
		this.paginas = paginas;
	}
	
	public Libro(String titulo, String autor, int paginas) 
	{
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}
	
	public Libro(String id)
	{
		this.id = id;
	}
	
	public Libro() 
	{
		super();
	}	
	
}
