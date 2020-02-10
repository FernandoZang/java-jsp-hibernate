package tests;

import java.util.List;

import dao.BovinoDao;
import models.Bovino;
import models.Sexo;


public class BovinoTest {
	private static BovinoDao bovinoDao = new BovinoDao();
	
	
	private static void save(){
		Bovino b = new Bovino();
		b.setNome("Tekinha");
		b.setSexo(Sexo.Femea);
		bovinoDao.save(b);
	}
	
	private static void getBovinosByNameStartWith(){
		List<Bovino> bovinos = bovinoDao.getBovinoByNameStartWith("");
		for(Bovino b: bovinos){
			System.out.println(b.getNome());
		}
	}
	
	public static void main(String[] args) {
		//save();
		getBovinosByNameStartWith();
		
	}

}
