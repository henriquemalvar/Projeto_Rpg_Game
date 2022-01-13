package trabalho2;

import java.util.Random;
import java.util.Scanner;

public class Mapa {
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	int limites, rodada=0;
	Celula[][] sala;
	boolean combate;
	public Mapa(int limites) {
		this.limites = limites;
		sala = new Celula[limites][limites];
		int i, j, k=0;
		for(i = 0; i < limites; i++) {
			for(j = 0; j < limites; j++) {
				sala[i][j] = new Celula(k, i, j);
				k++;
			}
		}
	}
	public void Movimento(Personagem player) {
		int x = player.i, y = player.j, idSalaAtual=player.k, proximaSala=0;
		System.out.println("Escolha para onde movimentar:");
		if(y + 1 <= limites) {
			System.out.println(sala[x][y+1].id + " - Para baixo.");  
		}
		if(y - 1 >= 0){
			System.out.println(sala[x][y-1].id + " - Para cima.");
		}
		if(x-1 >= 0) {
			System.out.println(sala[x-1][y].id + " - Para esquerda.");
		}
		if(x+1 <= limites) {
			System.out.println(sala[x+1][y].id + " - Para direita.");
		}
		proximaSala = scan.nextInt();
		if(proximaSala == idSalaAtual + 1 || proximaSala == idSalaAtual - 1
				|| proximaSala == idSalaAtual + limites || proximaSala == idSalaAtual - limites) {
			for(int k=0; k < limites; k++)
			{
				for(int l=0; l < limites; l++)
				{
					if(proximaSala == sala[k][l].id) {
						if(sala[k][l].emCombate){
							System.out.println("Celula em combate...");
							System.out.println("Escolha novamente.");
						}
						else {
							System.out.println(player.nome + " foi movido da celula " + idSalaAtual + " para a celula " + proximaSala);
							player.i = k;
							player.j = l;
							player.k = sala[k][l].id;
							break;
						}
					}
				}
			}
		}
	}
	public boolean PossivelBatalha(Personagem[] monstro, Personagem[] personagem) {
		int i=0, j=0;
			for(i = 0; i < limites; i++) {
				for(j = 0; j < limites; j++) {
					sala[i][j].PersonagensNaCelula(personagem, monstro, sala[i][j].id);
					if(sala[i][j].numMonstros > 0 || sala[i][j].numPlayers > 1) {
						sala[i][j].Combate(monstro, personagem, sala[i][j].id);
					}
				}
			}
			return false;
		}
	public void InserirPersonagens(Personagem []player, int n) {
		System.out.println(player[n].nome + " em qual celula deseja ser adicionado: ");
		int id = scan.nextInt();
		player[n].PosicaoAtual(id);
	}
	public void InserirMonstros(Personagem[] monstro) {
		int n = monstro.length;
		int quantGoblins, quantEfogo;
		quantEfogo = ((n-1) * 25)/100;
		quantGoblins = n - 1 - quantEfogo;
		for(int i = 0; i < n; i++) {
			if(i >= 0 && i < quantGoblins)
				monstro[i] = new Personagem(-i,"Goblin" , "goblin");
			else if(i < quantEfogo && i >= quantGoblins)
				monstro[i] = new Personagem(-i, "Efogo" , "Efogo");
			else
				monstro[i] = new Personagem(-i, "Dragao" , "Dragao");
			monstro[i].PosicaoAtual(random.nextInt(limites * limites));
		}
	}
}
