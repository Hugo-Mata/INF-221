/*
 * Criado por Hugo Leonardo da Mata Ribeiro
 * 
 * 23 de setembro 2021
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A classe Campeonato é responsável por ler a entrada do usuário
 * e calcular a classificação do campeonato a partir dos resultados
 * obtidos	
 */
public class Campeonato {
	public static int n_times;
	public static Map<Integer, Time> times = new HashMap<Integer, Time>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n_times = in.nextInt();
		int n_jogos = n_times*(n_times-1)/2;
		Partida[] resultados = new Partida[n_jogos];
		for(int i = 0; i < n_jogos; i++) {
			Partida p = new Partida();
			int time1 = in.nextInt();
			p.setTime1(time1);
			int pontuacao_time1 = in.nextInt();
			p.setPontuacao_time1(pontuacao_time1);
			int time2 = in.nextInt();
			p.setTime2(time2);
			int pontuacao_time2 = in.nextInt();
			p.setPontuacao_time2(pontuacao_time2);
			resultados[i] = p;
		}
		registra_times(resultados);
		for(int i = 0; i < resultados.length; i++) {
			registra_partida(resultados[i]);
		}
		int[] classisficacao_final = calcula_classificao();
		resposta(classisficacao_final);
	}

	public static void registra_times(Partida[] resultados) {
		for(int i = 0; i < resultados.length; i++) {
			times.putIfAbsent(resultados[i].getTime1(), new Time(resultados[i].getTime1()));
			times.putIfAbsent(resultados[i].getTime2(), new Time(resultados[i].getTime2()));
		}
	}

	public static void registra_partida(Partida partida) {
		//TIME 1
		Time t1 = new Time(partida.getTime1());
		t1.setPontos_marcados(times.get(partida.getTime1()).getPontos_marcados() + partida.getPontuacao_time1());
		t1.setPontos_sofridos(times.get(partida.getTime1()).getPontos_sofridos() + partida.getPontuacao_time2());
		//TIME 2
		Time t2 = new Time(partida.getTime2());
		t2.setPontos_marcados(times.get(partida.getTime2()).getPontos_marcados() + partida.getPontuacao_time2());
		t2.setPontos_sofridos(times.get(partida.getTime2()).getPontos_sofridos() + partida.getPontuacao_time1());
		// Se o time 1 venceu
		if(partida.getPontuacao_time1() > partida.getPontuacao_time2()){
			t1.setPontos_campeonato(times.get(partida.getTime1()).getPontos_campeonato() + 2);
			t2.setPontos_campeonato(times.get(partida.getTime2()).getPontos_campeonato() + 1);
		}else { // se o time 2 venceu
			t1.setPontos_campeonato(times.get(partida.getTime1()).getPontos_campeonato() + 1);
			t2.setPontos_campeonato(times.get(partida.getTime2()).getPontos_campeonato() + 2);
		}
		times.put(partida.getTime1(), t1);
		times.put(partida.getTime2(), t2);
	}

	public static void resposta(int[] classisficacao_final) {
		for(int i = 0; i < classisficacao_final.length; i++) {
			System.out.print(classisficacao_final[i]+" ");
		}
		System.out.println("");
	}
	
	public static int[] calcula_classificao() {
		int[] classisficacao_final = new int[n_times];
		int pontos = 0,t = 0, pt_marcados = 0;
		double avg = 0;
		for(int i  = 0; i < n_times; i++) {
			for (Map.Entry<Integer, Time> time : times.entrySet()) {
				if(time.getValue().getPontos_campeonato() > pontos) {
					pontos = time.getValue().getPontos_campeonato();
					t = time.getValue().getInscricao();
				}else if(time.getValue().getPontos_campeonato() == pontos) {
					if(time.getValue().cesta_average() > avg) {
						avg = time.getValue().cesta_average();
						t = time.getValue().getInscricao();
					}else if(time.getValue().cesta_average() == avg) {
						if(time.getValue().getPontos_marcados() > pt_marcados) {
							pt_marcados = time.getValue().getPontos_marcados();
							t = time.getValue().getInscricao();
						}else if(time.getValue().getPontos_marcados() == pt_marcados) {
							break;
						}
					}
				}
			}
			classisficacao_final[i] = t;
			times.remove(t);
			pontos = pt_marcados = 0;
			avg = 0;
		}
		
		return classisficacao_final;
	}
}
