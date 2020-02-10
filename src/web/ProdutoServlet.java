package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Produto;
import dao.ProdutoDao;


@WebServlet(urlPatterns = {"/produto", "/produto/list", "/produto/new", "/produto/insert", "/produto/edit", "/produto/update", "/produto/delete"})
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao;

	@Override
	public void init() throws ServletException {	
		produtoDao = new ProdutoDao();
	}
	
    public ProdutoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		//System.out.println("ação: "  + action);
		try {
			switch (action) {
				case "/produto/edit":
	                showEditForm(request, response);
	                break;
				case "/produto/new":
	                showNewForm(request, response);
	                break;
				case "/produto/list":
					System.out.println("debug 2");
	            	listarProduto(request, response);
	                break;
				case "/produto/delete":
					deleteProduto(request, response);
					break;
	            default:
	            	System.out.println("Entrou em default");
	            	listarProduto(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
				case "/produto/insert":
					insertProduto(request, response);
					break;
				case "/produto/update":
					updateProduto(request, response);
					break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/produto/produto-form.jsp");
	        dispatcher.include(request, response);
    }
	
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/produto/produto-edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Produto p = produtoDao.getById( id );
        request.setAttribute("produto", p);
        dispatcher.include(request, response);
    }

	
	
	private void listarProduto(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		System.out.println("Debug: chegou método listar do servlet");
		List<Produto> listaProdutos = produtoDao.getAllProdutos();
		System.out.println("Quantidade de produtos: " + listaProdutos.size());
		request.setAttribute("listaProduto", listaProdutos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/produto/produto-list.jsp");
		dispatcher.include(request, response);
	}
	
	private void insertProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{
		String descricao = request.getParameter("descricao");
		Produto p = new Produto();
		//Integer version = Integer.parseInt(request.getParameter("version"));
		p.setDescricao(descricao);
		//p.setVersion(version);
		produtoDao.save(p);
		System.out.println("request 'path: " + request.getContextPath() + "/produto/list");
		response.sendRedirect( request.getContextPath() + "/produto/list" );
	}
	
	private void updateProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("descricao");
		Integer version = Integer.parseInt(request.getParameter("version"));
		Produto p = new Produto();
		p.setId(id);
		p.setDescricao(descricao);
		p.setVersion(version);
		produtoDao.save(p);
		System.out.println("path: " + request.getContextPath() + "/produto/list");
		response.sendRedirect( request.getContextPath() + "/produto/list" );
	}
	
	
	private void deleteProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		produtoDao.removeById(id);
		response.sendRedirect( request.getContextPath() + "/produto/list" );
	}
	
	

}//endof: ProdutoServlet
