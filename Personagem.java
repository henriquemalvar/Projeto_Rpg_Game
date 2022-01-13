package trabalho2;

import java.util.Random;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Personagem {
	int id, i, j, k, tipoAtk, acao;
	String nome, Status, classe;
	boolean amaldicoado, emCombate;
	Atributos atr;
	double danoAcao, exp;
	Random random = new Random();
	Random max = new Random();
	Random min = new Random();
	Scanner scan = new Scanner(System.in);
	public Personagem(int id, String nome, String classe) {
		this.nome = nome;
		atr = new Atributos(classe);
		this.classe = classe;
		this.id = id;
		this.exp = 10;
	}
	public void setHp(double atk) {
		atr.hp -= atk;
	}
	public boolean Morto() {
		return (atr.hp <= 0);
	}
	public double AtkGerado(int tipoAtk, double danoAcao) {
		double dano=-1, fc, fm, p, maximo, minimo;
		if(tipoAtk == 1) {//atk simples
			p = 0.17 * (100 - atr.atk)/100;
			maximo = (atr.atk/100) * danoAcao - Math.abs(p*danoAcao);
			minimo = min.nextInt((int) (Math.abs(500 - atr.chp + 1))) + 500;
			fc = (atr.hp + 0.1 * (atr.chp))/minimo;
			dano = max.nextInt((int) (Math.abs(0 - maximo) + 1)) * fc;
			//break;
		}
		else if(tipoAtk == 2) {//atk cruzado
			p = 0.17 * (100 - atr.atk)/100;
			minimo = min.nextInt((int) (Math.abs(500 - atr.chp + 1))) + 500;
			fc = (atr.hp + 0.1 * (atr.chp))/minimo;
			maximo = (atr.atk/100) * danoAcao - Math.abs(p*danoAcao);
			dano = max.nextInt((int) (Math.abs(0 - maximo) + 1)) * fc;
			//break;
		}
		else if(tipoAtk == 3) {//atk fogo
			while(dano == -1) {
				if(atr.mp >= 6 ) {// tem mp para o atk magico
					minimo = min.nextInt((int) (Math.abs(500 - atr.cmp + 1))) + 500;
					p = 0.17 * (100 - atr.Rfogo)/100;
					fm = (atr.mp + 0.1 * (atr.cmp))/minimo;
					maximo = (atr.Rfogo/100) * danoAcao - Math.abs(p*danoAcao);
					dano = max.nextInt((int) (Math.abs(0 - maximo) + 1)) * fm;
					break;
				}
					else {
						System.out.println("O " + nome + " nao possui mp suficiente para realizar o atk.");
						break;
					}
			}
		}
		else if(tipoAtk == 4) {//atk gelo
			while(dano == -1) {
				if(atr.mp >= 12) {//tem mp suficiente
					minimo = min.nextInt((int) (Math.abs(500 - atr.cmp + 1))) + 500;
					p = 0.17 * (100 - atr.Rgelo)/100;
					fm = (atr.mp + 0.1 * (atr.cmp))/minimo;
					maximo = (atr.Rgelo/100) * danoAcao - Math.abs(p*danoAcao);
					dano = max.nextInt((int) (Math.abs(0 - maximo) + 1)) * fm;
					break;
				}
				else {
					System.out.println("O " + nome + "nao possui mp suficiente para realizar o atk.");
					break;
				}
			}
			
		}
		return dano;
	}
	public double DanoRecebido(Personagem p1, Personagem p2) {
		double danoRecebido=0, danoAtacante = p2.AtkGerado(p2.tipoAtk, p2.danoAcao);
		double tipoAtk = p2.tipoAtk;
		if(tipoAtk == 1) {//atk simples
			danoRecebido = danoAtacante * (100/(100 + p1.atr.Rfisico)); 
		}
		else if(tipoAtk == 2) {//atk cruzado
			danoRecebido = danoAtacante * (100/(100 + p1.atr.Rfisico));
		}
		else if(tipoAtk == 3) {//atk fogo
			danoRecebido = danoAtacante * (100/(100 + p1.atr.Rfogo));
		}
		else if(tipoAtk == 4) {//atk gelo
			danoRecebido = danoAtacante * (100/(100 + p1.atr.Rgelo));
		}
		return danoRecebido;
	}
	public void Evolucao() {
		atr.hp = atr.chp * (1 - Math.pow(Math.E, (-(exp)/ atr.thp))) + atr.ihp;
		atr.mp = atr.cmp * (1 - Math.pow(Math.E, (-(exp)/ atr.tmp))) + atr.imp;
		atr.atk = atr.catk * (1 - Math.pow(Math.E, (-(exp)/ atr.tatk)));
		atr.esq = atr.cesq * (1 - Math.pow(Math.E, (-(exp)/ atr.esq)));
		atr.dest = atr.cdest * (1 - Math.pow(Math.E, (-(exp)/ atr.tdest)));
		atr.Rfogo = atr.cRfogo * (1 - Math.pow(Math.E, (-(exp)/ atr.tRfogo)));
		atr.Rgelo = atr.cRgelo * (1 - Math.pow(Math.E, (-(exp)/ atr.tRgelo)));
		atr.Rfisico = atr.cRfisico * (1 - Math.pow(Math.E, (-(exp)/ atr.tRfisico)));
	}
	public void Recuperar(Personagem p1) {
		Personagem p2 = new Personagem(p1.id, p1.nome, p1.classe);
		p2.exp = p1.exp;
		p2.Evolucao();
		p1.atr.hp = p2.atr.hp;
		p1.atr.mp = p2.atr.mp;
	}
	public String AtributosAtuais(Personagem p1) {
		return ("Hp: " + p1.atr.hp + "\nMp: " + p1.atr.mp +
					    	"\nAtk: " + p1.atr.atk + "\nEsq:" + p1.atr.esq + 
			    			"\nDest: " + p1.atr.dest + "\nRfogo: " + p1.atr.cRfogo +
		    				"\nRgelo: " + p1.atr.cRgelo + "\nRfisico: " + p1.atr.cRfisico);
	}
	public void Acao() {
		System.out.println("Digite a proxima acao: "
				+ "\n1 - Ataque simples"
				+ "\n2 - Impulso cruzado"
				+ "\n3 - Fogo"
				+ "\n4 - Gelo");
		tipoAtk = scan.nextInt();
		acao = tipoAtk;
		if(acao == 1) {
			danoAcao = 210.0;
		}
		else if(acao == 2) {
			danoAcao = 362.0;
		}
		else if(acao == 3) {
			danoAcao = 200.0;
		}
		else if(acao == 4) {
			danoAcao = 350.0;
		}
	}
	public void PosicaoAtual(int n) {
		this.k = n;
	}
	public Personagem QuemAtacar(Personagem[] p, Personagem[] monstro) {
		int idAtk, k=0;
		int quantMonstro = monstro.length, quantPersonagem = p.length;
		System.out.println("Escolha o personagem que deseja atacar: ");
		for(int i = 0; i < quantPersonagem; i++) {
			System.out.println("Nome: " + p[i].nome + "\tId: " + p[i].id);
		}
		for(int i = 0; i < quantMonstro; i++) {
			System.out.println("Nome: " + monstro[i].nome + "\tId: " + monstro[i].id);
		}
		System.out.println("Digite a id do personagem que deseja atacar: ");
		idAtk = scan.nextInt();
		for(int i = 0; i < p.length; i++) {
				if(idAtk == p[i].id) {
				k = i;
				}
		}
		for(int i = 0; i < monstro.length; i++) {
			if(idAtk == monstro[i].id) {
				k=i;
			}
		}
		if(idAtk < 0) {
			return monstro[k];
		}
		else if(idAtk >= 0) {
			return p[k];
		}
		return null;
	}
	public Personagem AtkMonstro(Personagem[] p, Personagem[] monstro) {
		int idAtk, k=0;
		idAtk = random.nextInt(p.length) ;
		for(int i = 0; i < p.length; i++) {
				if(idAtk == p[i].id) {
				k = i;
				}
		}
		if(idAtk >= 0) {
			return p[k];
		}
		return null;
	}
	public void AcaoMonstro() {
		tipoAtk = random.nextInt(4) + 1;
		acao = tipoAtk;
		if(acao == 1) {
			danoAcao = 210.0;
		}
		else if(acao == 2) {
			danoAcao = 362.0;
		}
		else if(acao == 3) {
			danoAcao = 200.0;
		}
		else if(acao == 4) {
			danoAcao = 350.0;
		}
	}
	public Personagem IdentificarPersonagem(Personagem[] personagem, int x, int y) {
		Personagem p1 = null;
		for(int i = 0; i < personagem.length; i++) {
			if(personagem[i].i == x && personagem[i].j == y) {
				p1 = personagem[i];
			}
		}
		return p1;
	}
}
