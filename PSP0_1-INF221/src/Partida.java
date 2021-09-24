/*
 * Criado por Hugo Leonardo da Mata Ribeiro
 * 
 * 23 de setembro 2021
 */

/**
 * A classe Partida é responsável armazenar armazenar a as informações
 * de cada partida
 */
public class Partida {
	private int time1;
	private int time2;
	private int pontuacao_time1;
	private int pontuacao_time2;
	
	public Partida(int time1, int pontuacao_time1, int time2, int pontuacao_time2) {
		this.time1 = time1;
		this.time2 = time2;
		this.pontuacao_time1 = pontuacao_time1;
		this.pontuacao_time2 = pontuacao_time2;
	}
	
	public Partida() {
		this.time1 = 0;
		this.time2 = 0;
		this.pontuacao_time1 = 0;
		this.pontuacao_time2 = 0;
	}
	
	public int getTime1() {
		return time1;
	}
	public void setTime1(int time1) {
		this.time1 = time1;
	}
	public int getTime2() {
		return time2;
	}
	public void setTime2(int time2) {
		this.time2 = time2;
	}
	public int getPontuacao_time1() {
		return pontuacao_time1;
	}
	public void setPontuacao_time1(int pontuacao_time1) {
		this.pontuacao_time1 = pontuacao_time1;
	}
	public int getPontuacao_time2() {
		return pontuacao_time2;
	}
	public void setPontuacao_time2(int pontuacao_time2) {
		this.pontuacao_time2 = pontuacao_time2;
	}
}
