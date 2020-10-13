package br.com.lembrete.soap;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.lembrete.dao.LembreteDao;
import br.com.lembrete.model.Lembrete;

@WebService(serviceName = "LembreteService")
public class LembreteSOAP {
	
	@Inject
	private LembreteDao dao;
	
	@WebMethod
	@WebResult(name = "listaLembrete")
	public List<Lembrete> listarLembrete() throws Exception{
		return dao.listarTodos();
		
	}
	
	@WebMethod
	@WebResult(name = "cadastraLembrete")
	public Lembrete inserirLembrete(Lembrete lembrete) throws Exception {
		dao.inserir(lembrete);
		
		return lembrete;
	}
	
	@WebMethod
	@WebResult(name = "deletarLembrete")
	public void removerLembrete(Long id) throws Exception {
		dao.excluir(id);;
		
	}
	
	@WebMethod
	@WebResult(name = "atualizarLembrete")
	public void atualizarLembrete(Lembrete lembrete) throws Exception {
		dao.atualizar(lembrete);
		
	}
	

}
