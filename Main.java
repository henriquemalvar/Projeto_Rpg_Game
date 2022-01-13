package trabalho2;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Mapa mapa = new Mapa(8);
		Arena arena = new Arena();
		Scanner scan = new Scanner(System.in);
		String nome, classe;
		int quantMonstros = (8 * 2) + 1; 
		Personagem[] monstro = new Personagem[quantMonstros];
		System.out.println("Iniciando jogo...");
		System.out.println("Digite o numero de jogadores: ");
		//int quant = Integer.parseInt(scan.nextLine());
		Personagem[] player = new Personagem[1];
		for(int i = 0; i < 1; i++) {
			System.out.println("Digite o nome e a classe do personagem: ");
			//nome = scan.nextLine();
			//classe = scan.nextLine();
			//player[i] = new Personagem(i, nome, classe);
		}
		player[0] = new Personagem(0, "Goblin Slayer" , "Guerreiro");
		
		System.out.println("Os personagens criados foram: ");
		for(int i = 0; i < player.length; i++) {
			System.out.println("Player:"+player[i].id + "\nNome: " + player[i].nome + "\nClasse: " + player[i].classe);
			mapa.InserirPersonagens(player, i);
		}
		mapa.InserirMonstros(monstro);
		
		boolean loop = true;//coloca o mapa em loop ate o objetivo ser concluido
		int contador = 0;
		while(loop) {
			mapa.PossivelBatalha(monstro, player);
			for(int j = 0; j < player.length; j++) {
				if(player[j].emCombate) {
				}
				else {
					mapa.Movimento(player[j]);
				}//movimento
				mapa.PossivelBatalha(monstro, player);				}
		}//combate
	}
	//player[1] = new Personagem (1, "npc", "mago");
	//player[0].PosicaoAtual(0);
	//System.out.println("Criacao dos monstrons.");
	//mapa.CriacaoMonstros(monstro, 8);
	//mapa.Movimento(player[0]);
	//arena.Rodada(player, npc);
	//arena.Batalha(player, monstro);
	//System.out.println();
}
