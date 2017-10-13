package fr.demos.formation.septiemearche.test;

import org.junit.Before;
import org.junit.Test;

import fr.demos.formation.septiemearche.metier.Tva;



public class TvaTestUnit {

	
	private Tva tva;
	@Before
	public void init() {
		tva = new Tva();
		tva.setId(1);
		tva.setLibelle("Tva de test");
		tva.setTaux(10);
	}
	@Test
	public void test() {
		float ht = 1000;
		float ttc;
		
		tva.calculerTtc(1000);
		
	
	}

}
