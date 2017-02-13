package org.spring.oelsacte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LibroController 
{
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "libro", method = RequestMethod.GET)
	@ResponseBody
	public Object index()
	{
		System.out.println("Entrando a mostrar todo");
		System.out.println("Libros recuperados " + libroService.findAll().toString());
		return libroService.findAll();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody Libro libro)
	{
		String libroId = "";
		
		try
		{
			System.out.println("Entrando a salvar libro");
			libroService.save(libro);
			System.out.println("Tratando de recuperar ID");
			libroId = String.valueOf(libro.getId());
			System.out.println("Entrando a crear libro");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Error al intentar guardar libro " + libro.toString();			
		}
		return "Se agrega documento " + libroId;
	}
	
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable String id)
	{
		Libro libro= null;
		try
		{
			libro = libroService.findById(id);
			libroService.delete(libro);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Error al intentar eliminar " + libro.toString();
		}
		return "Se eliminó exitosamente " + libro.toString();
	}
	
	@RequestMapping(value = "/update/{id}")
	@ResponseBody
	public String update(@RequestBody Libro libro, @PathVariable String id)
	{
		try
		{
			libro.setId(id);
			libroService.save(libro);
		}catch(Exception e)
		{
			return "Error al intentar actualizar " + libro.toString();
		}
		return "Se actualizó exitosamente " + libro.toString();
	}
	
}
