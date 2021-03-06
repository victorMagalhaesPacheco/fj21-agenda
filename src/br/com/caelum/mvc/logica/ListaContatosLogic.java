package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogic implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// monta a lista de contatos
		Connection connection = (Connection) request.getAttribute("connection");
		
		List<Contato> contatos = new ContatoDao(connection).getLista();
		
		// guarda a lista no request
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}
}
