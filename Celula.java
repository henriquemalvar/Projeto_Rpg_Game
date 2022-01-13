package trabalho2;

import java.util.Random;
import java.util.Scanner;

public class Celula {
	Arena arena;
	Personagem[] player, monstro;
	int i, j, combate, id, numMonstros=0, numPlayers=0;
	Random porcentagem = new Random(100);
	Scanner scan;
	boolean emCombate;
	public Celula(int id, int i, int j) {
		this.i = i;
		this.j = j;
		this.id = id;
	}
	public void Combate(Personagem[] monstro, Personagem[] p, int id) {
		emCombate = false;
		if(id == 0) {
			int probabilidade = porcentagem.nextInt();
			if(numPlayers > 1) {
				arena.Batalha(p);
				emCombate = true;
				if(probabilidade > 100) {//sem emCombate
				}
				else {
				}
			}
		}
		else if(id == 1) {//emCombate entre p1 e p2,se nao tiver p2
			int probabilidade = porcentagem.nextInt();
			if(numPlayers > 1) {
				arena.Batalha(p);
				if(probabilidade <= 20) {//emCombate 20% de chance
					arena.Batalha(p, monstro);
					emCombate = true;
				}
				else {
					if(numPlayers > 1) {
						arena.Batalha(p);
						emCombate = true;
					}
				}
			}
		}
		else if(id == 2) {
			int probabilidade = porcentagem.nextInt();
			if(numPlayers > 0) {
				if(probabilidade <= 100) {//100%  de chance
					arena.Batalha(p, monstro);
					emCombate = true;
				}
				else {
					arena.Batalha(p);
					emCombate = true;
				}
			}
		}
		else if(id == 3) {//problema, bug quando tento acessar 
			
		}
	}
	public void PersonagensNaCelula(Personagem[] personagem, Personagem[] monstros, int id) {
		int numPlayers=0, numMonstros=0;
		for(int i = 0; i < personagem.length; i++) {
			for(int j = 0; j < personagem.length; j++){
				if(personagem[i].k == personagem[j].k){
					numPlayers++;
				}
			}
			for(int j = 0; j < monstros.length; j++) {
				if(personagem[i].k == monstros[j].k){
					numMonstros++;
				}
			}
			this.numPlayers = numPlayers;
			this.numMonstros = numMonstros;
		}
	}
	public boolean PossiveisMovimentos() {
		boolean bloqueado = emCombate;
		return bloqueado;
	}
}
