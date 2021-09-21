import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test1() {
		int n = 10;
		int[] distancias_atacantes = new int[n];
		assertEquals(10, distancias_atacantes.length);
	}
	
	@Test
	void test2() {
		int[] distancias_atacantes = {500,700};
		int[] distancias_defensores = {700,500,500};
		
		boolean existe = Main.existe_impedimento(distancias_atacantes,distancias_defensores);
		assertFalse(existe);
	}
	
	@Test
	void test3() {
		int[] distancias_atacantes = {200,400};
		int[] distancias_defensores = {200,1000};
		
		boolean existe = Main.existe_impedimento(distancias_atacantes,distancias_defensores);
		assertTrue(existe);
	}
	
	@Test
	void test4() {
		boolean existe = true;
		boolean nao_existe = false;
		
		assertEquals("Y",Main.resposta(existe));
		assertEquals("N",Main.resposta(nao_existe));
		
	}
	
	

}
