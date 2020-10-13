package br.com.lembrete.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.lembrete.dao.LembreteDao;
import br.com.lembrete.model.Lembrete;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("lembrete")
public class LembreteREST {
	
	@Inject
	private LembreteDao dao;
	
	@GET
	@Path("/list")
	public List<Lembrete> listarTodos() throws Exception{
		return dao.listarTodos();
	}
	
	@POST
	@Path("/inserir")
	public Response inserir(Lembrete lembrete) throws Exception {
		dao.inserir(lembrete);
		return Response.ok(201).build();
	}
	
	@DELETE
	@Path("{lembreteId}")
	public Response deletar(@PathParam("lembreteId") Long id) throws Exception {
		dao.excluir(id);
		return Response.noContent().build();	
	}
	
	@PUT
	@Path("{lembreteId}")
	public Response update(Lembrete lembrete) throws Exception {
		dao.atualizar(lembrete);
		return Response.noContent().build();
	}
	
	
	
	
}
