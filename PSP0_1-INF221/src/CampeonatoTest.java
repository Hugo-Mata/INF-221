import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CampeonatoTest {
	Partida[] resultados;
	
	@Test
	void testResposta() {
		int[] classisficacao_final = {1,3,5,2,4};
		Campeonato.resposta(classisficacao_final);
	}
	
	@Test
	void testRegistra_times() {
		resultados = new Partida[6];
		resultados[0] = new Partida(1,102,2,62);
		resultados[1] = new Partida(1,128,3,127);
		resultados[2] = new Partida(1,144,4,80);
		resultados[3] = new Partida(2,111,3,92);
		resultados[4] = new Partida(2,99,4,102);
		resultados[5] = new Partida(3,102,4,104);
		Campeonato.registra_times(resultados);
		assertNotNull(Campeonato.times);
	}
	
	@Test
	void testRegistra_partidas() {
		Campeonato.times.put(1, new Time());
		Campeonato.times.put(2, new Time());
		Campeonato.times.put(3, new Time());
		Campeonato.times.put(4, new Time());
		resultados = new Partida[6];
		resultados[0] = new Partida(1,102,2,62);
		resultados[1] = new Partida(1,128,3,127);
		resultados[2] = new Partida(1,144,4,80);
		resultados[3] = new Partida(2,111,3,92);
		resultados[4] = new Partida(2,99,4,102);
		resultados[5] = new Partida(3,102,4,104);
		for(int i = 0; i < 6; i++) {
			Campeonato.registra_partida(resultados[i]);
		}
		assertEquals(6,Campeonato.times.get(1).getPontos_campeonato());
	}
	
	private Time setTime(int inscricao, int pontos, int pt_m, int pt_s) {
		Time t = new Time();
		t.setInscricao(inscricao);
		t.setPontos_campeonato(pontos);
		t.setPontos_marcados(pt_m);
		t.setPontos_sofridos(pt_s);
		return t;
	}
	
	@Test
	void testCalcula_classificao() {
		Campeonato.times.clear();
		Campeonato.n_times = 6;
		Time t = new Time();
		t = setTime(1,6,374,269);
		Campeonato.times.put(1,t);
		t = setTime(2,5,100,50);
		Campeonato.times.put(2, t);
		t = setTime(3,5,200,100);
		Campeonato.times.put(3, t);
		t = setTime(4,3,286,345);
		Campeonato.times.put(4, t);
		t = setTime(5,3,386,100);
		Campeonato.times.put(5, t);
		t = setTime(6,3,386,100);
		Campeonato.times.put(6, t);
		int[] clasfic = Campeonato.calcula_classificao();
		for(int i = 0; i < 3; i++) {
			System.out.print(clasfic[i]+" ");
		}
		int[] expected = {1,3,2,6,5,4};
		assertArrayEquals(expected, clasfic);
	}
	
	@Test
	void testCesta_average() {
		Time t1 = new Time();
		t1 = setTime(1,4, 200, 160);
		Time t2 = new Time();
		t2 = setTime(2,2,100,0);
		assertEquals(1.25,t1.cesta_average());
		assertEquals(100,t2.cesta_average());
	}
	
	@Test
	void testPartida() {
		Partida p = new Partida();
		p.setTime1(1);
		p.setPontuacao_time1(100);
		p.setTime2(2);
		p.setPontuacao_time2(98);
		assertEquals(1,p.getTime1());
		assertEquals(100,p.getPontuacao_time1());
		assertEquals(2,p.getTime2());
		assertEquals(98,p.getPontuacao_time2());
	}

}
