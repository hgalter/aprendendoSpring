package com.galter.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.galter.cobranca.model.StatusTitulo;
import com.galter.cobranca.model.Titulo;
import com.galter.cobranca.model.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		// TODO salvar no banco de dados
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}
	
	@RequestMapping
	public String pesquisar() {
		return "PesquisaTitulos";
	}
	
	@ModelAttribute //nome do atributo fica "statusTituloList" (nome da classe + List)
	public List<StatusTitulo> listaStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
