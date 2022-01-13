package trabalho2;

import java.util.Scanner;

public class Arena {
	int xp, i;
	Personagem p1, p2;
	Scanner scan = new Scanner(System.in);
	public Arena() {
	}
	public void Rodada(Personagem p1, Personagem p2) {
		double i=0, dano = -1, hpantes,  hprestante;
		while(i >= 0){
			if(p1.id>=0){
				if(dano >=-1) {
					p1.Acao();
					dano = p2.DanoRecebido(p2, p1);
					break;
				}
			}
			else {
				if(dano >= -1) {
					p1.AcaoMonstro();
					dano = p2.DanoRecebido(p2, p1);
					break;
				}
			}
		}
		hpantes = p2.atr.hp;
		p2.setHp(p2.DanoRecebido(p2, p1));
		hprestante = p2.atr.hp;
		System.out.println(p2.nome + " - Hp: " + hpantes + " - " + dano + " = " + hprestante);
	}
	public int Batalha(Personagem [] p) {
		Personagem p2 = null;
		int i = 0, vencedor = 0;
		Arena arena = new Arena();
		for(i = 0; i < p.length; i++) {
			while(i >= 0) {
				System.out.println("Turno do: " + p[i].nome + ".");
				p2 = p[i].QuemAtacar(p, p);
				if(p2 != p[i]) {
					break;
				}
				else {
					System.out.println("Nao deve se atacar!");
				}
			}
			arena.Rodada(p[i], p2);
			if(p2.Morto()) {
				System.out.println(p[i].nome + " matou " + p2.nome);
				if(p[i].id >= 0) {
					p[i].exp += (0.25 * p2.exp);
					p[i].Evolucao();
				}
				vencedor = p[i].id;
			}
		}
		return vencedor;
	}
	public int Batalha(Personagem[] p, Personagem[] monstro) {
		Personagem p2 = null;
		int i = 0, vencedor = 0;
		Arena arena = new Arena();
		for(i = 0; i < p.length; i++) {
			while(i >= 0) {
				System.out.println("Turno do: " + p[i].nome + ".");
				p2 = p[i].QuemAtacar(p, monstro);
				if(p2 != p[i]) {
					break;
				}
				else {
					System.out.println("Nao deve se atacar!");
				}
			}
			arena.Rodada(p[i], p2);
			if(p2.Morto()) {
				System.out.println(p[i].nome + " matou " + p2.nome);
				if(p[i].id >= 0) {
					p[i].exp += (0.25 * p2.exp);
					p[i].Evolucao();
				}
				vencedor = p[i].id;
			}
		}
		
		for(i = 0; i < monstro.length; i++) {
			while(i >= 0) {
				System.out.println("Turno do: " + monstro[i].nome + ".");
				p2 = monstro[i].AtkMonstro(p, monstro);
				if(p2 != monstro[i]) {
					break;
				}
			}
			arena.Rodada(monstro[i], p2);
			if(p2.Morto()) {
				System.out.println(monstro[i].nome + " matou " + p2.nome);
				vencedor = monstro[i].id;
			}
		}
		return vencedor;
	}
	public void Revitalizar(Personagem [] personagem, int id) {
		for(int i = 0; i < personagem.length; i++) {
			if(personagem[i].k == id) {
				personagem[i].Recuperar(personagem[i]);
			}
		}
	}
	public void Amaldicoar() {
		
	}
}