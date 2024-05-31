package com.biblioteca.norena.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.norena.app.crud.CrudLibro;
import com.biblioteca.norena.app.crud.CrudUsuario;
import com.biblioteca.norena.app.entity.Libro;
import com.biblioteca.norena.app.entity.Usuario;

@Controller
public class HomeController {
	
	@Autowired
	private CrudUsuario clienteRepositorio;
	
	@Autowired
	private CrudLibro paqueteRepositorio;

	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin.html";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("cliente2", new Usuario());
		
		return "login.html";
	}
	
	//PAQUETES
	
	@GetMapping("/verPaquetes")
	public String paquetes(Model model) {
		List<Libro> lista = paqueteRepositorio.findAll();
		model.addAttribute("listaPaquete", lista);
		
		return "verPaquetes.html";
	}
	
	@GetMapping("/paquete/formPaquete")
	public String mostrarFormularioLibro(Model model) {
		model.addAttribute("libro", new Libro());
		
		List<Usuario> lista = clienteRepositorio.findAll();
		model.addAttribute("listaUsuario", lista);
		
		return "formPaquete";
	}
	
	@PostMapping("/guardarPaquete")
	public String guardarPaquete (Libro paquete) {
		paqueteRepositorio.save(paquete);
		
		return "redirect:/verPaquetes";
	}
	
	@GetMapping("/paquete/editar/{id}")
	public String modificar (@PathVariable("id") Integer id, Model model) {
		Libro pa = paqueteRepositorio.findById(id).get();
		model.addAttribute("paquete", pa);
		
		List<Usuario> lista = clienteRepositorio.findAll();
		model.addAttribute("listaCliente", lista);
		
		
		return "formPaquete";
	}
	
	@GetMapping("/paquete/eliminar/{id}")
	public String eliminarPaquete(@PathVariable("id") Integer id, Model model) {
		paqueteRepositorio.deleteById(id);
		return "redirect:/verPaquetes";
	}
	
	//USUARIOS
	
	@GetMapping("/verUsuarios")
	public String usuarios(Model model) {
		List<Usuario> lista = clienteRepositorio.findAll();
		model.addAttribute("listaUsuario", lista);
		
		return "verUsuarios.html";
	}
	
	@GetMapping("/usuario/formUsuario")
	public String mostrarFormularioUsu(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		List<Libro> lista = paqueteRepositorio.findAll();
		model.addAttribute("listaPaquetes", lista);
		
		return "formUsuarios.html";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarUus (Usuario usuario) {
		clienteRepositorio.save(usuario);
		
		return "redirect:/verUsuarios";
	}
	
	@GetMapping("/usuario/editar/{id}")
	public String modificarUsu (@PathVariable("id") Integer id, Model model) {
		Usuario pa = clienteRepositorio.findById(id).get();
		model.addAttribute("usuario", pa);
		
		List<Usuario> lista = clienteRepositorio.findAll();
		model.addAttribute("listaCliente", lista);
		
		
		return "formUsuarios.html";
	}
	
	@GetMapping("/usuario/eliminar/{id}")
	public String eliminarUsu(@PathVariable("id") Integer id, Model model) {
		clienteRepositorio.deleteById(id);
		return "redirect:/verUsuarios";
	}
	
	//LOGIN
	
	@PostMapping("/loguearse")
	public String loguearse(Usuario cliente2, Model model) {
		Usuario cliente = clienteRepositorio.findByCorreo(cliente2.getCorreo());
		
		if(cliente != null) {
			List<Libro> lista = paqueteRepositorio.findByUsuario(cliente);
			
			model.addAttribute("usuario", cliente);
			model.addAttribute("listaPaquetes", lista);
			return "usuario.html";
		}
		
		model.addAttribute("cliente2", new Usuario());
		return "login.html";
	}
}