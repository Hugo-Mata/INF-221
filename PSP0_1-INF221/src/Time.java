/*
 * Criado por Hugo Leonardo da Mata Ribeiro
 * 
 * 23 de setembro 2021
 */

/**
 * A classe Partida é responsável armazenar armazenar a as informações
 * de cada time
 */
public class Time {
	
	private int inscricao;
	private int pontos_campeonato;
	private int pontos_marcados;
	private int pontos_sofridos;
	
	public Time(int inscricao) {
		this.inscricao = inscricao;
		this.pontos_campeonato = 0;
		this.pontos_marcados = 0;
		this.pontos_sofridos = 0;
	}
	
	public Time() {
		this.inscricao = 0;
		this.pontos_campeonato = 0;
		this.pontos_marcados = 0;
		this.pontos_sofridos = 0;
	}
	
	public double cesta_average() {
		if(pontos_sofridos == 0) {
			return pontos_marcados;
		}
		double avg;
		avg = (double)pontos_marcados/(double)pontos_sofridos;
		
		return avg;
	}
	
	public int getInscricao() {
		return inscricao;
	}
	public void setInscricao(int inscricao) {
		this.inscricao = inscricao;
	}
	public int getPontos_campeonato() {
		return pontos_campeonato;
	}
	public void setPontos_campeonato(int pontos_campeonato) {
		this.pontos_campeonato = pontos_campeonato;
	}
	
	public int getPontos_marcados() {
		return pontos_marcados;
	}

	public void setPontos_marcados(int pontos_marcados) {
		this.pontos_marcados = pontos_marcados;
	}

	public int getPontos_sofridos() {
		return pontos_sofridos;
	}

	public void setPontos_sofridos(int pontos_sofridos) {
		this.pontos_sofridos = pontos_sofridos;
	}
}
