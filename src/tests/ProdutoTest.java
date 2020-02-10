package tests;

import java.util.List;

import models.Produto;
import dao.ProdutoDao;

public class ProdutoTest {
	private static ProdutoDao produtoDao = new ProdutoDao();
	
	public static void getAll(){
		List<Produto> produtos = null;
		produtos = produtoDao.getAllProdutos();
		for (Produto produto : produtos) {
			System.out.println( produto.toString() );
		}
	}
	
	public static void save(){
		Produto p = new Produto();
		p.setDescricao("Água sanitária 2");
		produtoDao.save(p);
	}
	
	public static void main(String[] args) {
		//getAll();
		save();
		
	}
}
