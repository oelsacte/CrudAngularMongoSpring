package org.spring.oelsacte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService 
{
	@Autowired
	private LibroRepository libroRepository;
	
	public Object findAll()
	{
		return libroRepository.findAll();
	}
	
	public Libro findById(String id)
	{
		return libroRepository.findOne(Long.valueOf(id));
	}
	
	public Libro save(Libro libro)
	{
		return libroRepository.save(libro);
	}
	
	public void delete(Libro libro)
	{
		libroRepository.delete(libro);
		return;
	}

}
