package fr.demos.formation.septiemearche.test;

import org.junit.Before;
import org.junit.Test;

import fr.demos.formation.septiemearche.metier.Tva;
import junit.framework.Assert;

public class TvaTestUnit {

	@Test
	private Tva tva;
	@Before
	public void inid() {
		tva = new Tva();
		tva.setId(1);
		tva.setLibelle("Tva de test");
		tva.setTaux(10);
	}

	public void test() {
		float ht = 1000;
		float ttc;
		
		tva.calculerTtc(1000);
		
		Assert.assertEquals(1100, ttc);
	}

}
