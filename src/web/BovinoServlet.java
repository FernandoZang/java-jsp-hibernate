package web;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

import models.Bovino;
import models.Produto;
import models.Sexo;
import dao.BovinoDao;

/**
 * Servlet implementation class BovinoServlet
 */
@WebServlet(urlPatterns = {"/bovino", "/bovino/list", "/bovino/edit", "/bovino/insert", "/bovino/new", "/bovino/update"})
public class BovinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BovinoDao bovinoDao;
       
    public BovinoServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	bovinoDao = new BovinoDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action: " + action);
		switch (action) {
		case "/bovino":
			listarBovino(request, response);
			break;
		case "/bovino/list":
			listarBovino(request, response);
			break;
		case "/bovino/edit":
			showEditForm(request, response);
			break;
		case "/bovino/new":
			showNewForm(request, response);
			break;
		default:
			break;
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/bovino/insert":
			insertBovino(request, response);
			break;
		case "/bovino/update":
			updateBovino(request, response);
			break;
		}
	}
	
	
	
	private void listarBovino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bovino> bovinos = bovinoDao.getAll();
		request.setAttribute("bovinos", bovinos);
		request.getRequestDispatcher("/bovino/bovino-list.jsp").include(request, response);;
	}
	
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bovino/bovino-edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Bovino b = bovinoDao.getById( id );
        List<String> sexos = new ArrayList<>();
        for (Sexo s: Sexo.values()) {
        	sexos.add(s.toString());
		}
        request.setAttribute("sexos", sexos);
        request.setAttribute("bovino", b);
        dispatcher.include(request, response);
    }
	
	
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> sexos = new ArrayList<String>();
        for (Sexo sexo : Sexo.values()) {
        	sexos.add(sexo.toString());			
		}
        request.setAttribute("sexos", sexos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bovino/bovino-form.jsp");
        dispatcher.include(request, response);
    }
	
	
	
	private void insertBovino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String s = request.getParameter("sexo");
        
        Bovino bovino = new Bovino();
        bovino.setNome(nome);
        bovino.setSexo(Sexo.valueOf(s));
        bovinoDao.save(bovino);
        response.sendRedirect( request.getContextPath() + "/bovino/list" );
    }
	
	
	
	private void updateBovino(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
        String s = request.getParameter("sexo");        
        Bovino bovino = new Bovino();
        bovino.setId(id);
        bovino.setNome(nome);
        bovino.setSexo(Sexo.valueOf(s));
        System.out.println("sexo: " + Sexo.valueOf(s));
        bovinoDao.save(bovino);
        response.sendRedirect( request.getContextPath() + "/bovino/list" );
    }
	
	
}
