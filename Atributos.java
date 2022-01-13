package trabalho2;

public class Atributos {
	double hp, mp, atk, dest, esq, Rfogo, Rgelo, Rfisico;
	double chp, cmp, catk, cdest, cesq, cRfogo, cRgelo, cRfisico;
	double thp, tmp, tatk, tdest, tesq, tRfogo, tRgelo, tRfisico;
	double ihp, imp;
	public Atributos(String classe) {
		if(classe.equalsIgnoreCase("guerreiro")) {
			Guerreiro g = new Guerreiro();
			this.hp = g.ihp;
			this.ihp = g.ihp;
			this.chp = g.ihp;
			this.thp = g.thp;
			this.imp = g.imp;
			this.cmp = g.cmp;
			this.tmp = g.tmp;
			this.catk = g.catk;
			this.tatk = g.tatk;
			this.cdest = g.cdest;
			this.tdest = g.tdest;
			this.cesq = g.cesq;
			this.tesq = g.tesq;
			this.cRfogo = g.cRfogo;
			this.tRfogo = g.tRfogo;
			this.cRgelo = g.cRgelo;
			this.tRgelo = g.tRgelo;
			this.cRfisico = g.cRfisico;
			this.tRfisico = g.tRfisico;
		}
		else if(classe.equalsIgnoreCase("mago")) {
			Mago m = new Mago();
			this.hp = m.ihp;
			this.ihp = m.ihp;
			this.chp = m.chp;
			this.thp = m.thp;
			this.imp = m.imp;
			this.cmp = m.cmp;
			this.tmp = m.tmp;
			this.catk = m.catk;
			this.tatk = m.tatk;
			this.cdest = m.cdest;
			this.tdest = m.tdest;
			this.cesq = m.cesq;
			this.tesq = m.tesq;
			this.cRfogo = m.cRfogo;
			this.tRfogo = m.tRfogo;
			this.cRgelo = m.cRgelo;
			this.tRgelo = m.tRgelo;
			this.cRfisico = m.cRfisico;
			this.tRfisico = m.tRfisico;
		}
		else if(classe.equalsIgnoreCase("ninja")) {
			Ninja n = new Ninja();
			this.hp = n.ihp;
			this.ihp = n.ihp;
			this.chp = n.chp;
			this.thp = n.thp;
			this.imp = n.imp;
			this.cmp = n.cmp;
			this.tmp = n.tmp;
			this.catk = n.catk;
			this.tatk = n.tatk;
			this.cdest = n.cdest;
			this.tdest = n.tdest;
			this.cesq = n.cesq;
			this.tesq = n.tesq;
			this.cRfogo = n.cRfogo;
			this.tRfogo = n.tRfogo;
			this.cRgelo = n.cRgelo;
			this.tRgelo = n.tRgelo;
			this.cRfisico = n.cRfisico;
			this.tRfisico = n.tRfisico;
		}
		else if(classe.equalsIgnoreCase("Goblin")) {
			Goblin goblin = new Goblin();
			this.hp = goblin.ihp;
			this.ihp = goblin.ihp;
			this.chp = goblin.chp;
			this.thp = goblin.thp;
			this.imp = goblin.imp;
			this.cmp = goblin.cmp;
			this.tmp = goblin.tmp;
			this.catk = goblin.catk;
			this.tatk = goblin.tatk;
			this.cdest = goblin.cdest;
			this.tdest = goblin.tdest;
			this.cesq = goblin.cesq;
			this.tesq = goblin.tesq;
			this.cRfogo = goblin.cRfogo;
			this.tRfogo = goblin.tRfogo;
			this.cRgelo = goblin.cRgelo;
			this.tRgelo = goblin.tRgelo;
			this.cRfisico = goblin.cRfisico;
			this.tRfisico = goblin.tRfisico;
		}
		else if(classe.equalsIgnoreCase("dragao")) {
			Dragao d = new Dragao();
			this.hp = d.ihp;
			this.ihp = d.ihp;
			this.chp = d.chp;
			this.thp = d.thp;
			this.imp = d.imp;
			this.cmp = d.cmp;
			this.tmp = d.tmp;
			this.catk = d.catk;
			this.tatk = d.tatk;
			this.cdest = d.cdest;
			this.tdest = d.tdest;
			this.cesq = d.cesq;
			this.tesq = d.tesq;
			this.cRfogo = d.cRfogo;
			this.tRfogo = d.tRfogo;
			this.cRgelo = d.cRgelo;
			this.tRgelo = d.tRgelo;
			this.cRfisico = d.cRfisico;
			this.tRfisico = d.tRfisico;
		}
		else if(classe.equalsIgnoreCase("efogo")) {
			Efogo e = new Efogo();
			this.hp = e.ihp;
			this.ihp = e.ihp;
			this.chp = e.chp;
			this.thp = e.thp;
			this.imp = e.imp;
			this.cmp = e.cmp;
			this.tmp = e.tmp;
			this.catk = e.catk;
			this.tatk = e.tatk;
			this.cdest = e.cdest;
			this.tdest = e.tdest;
			this.cesq = e.cesq;
			this.tesq = e.tesq;
			this.cRfogo = e.cRfogo;
			this.tRfogo = e.tRfogo;
			this.cRgelo = e.cRgelo;
			this.tRgelo = e.tRgelo;
			this.cRfisico = e.cRfisico;
			this.tRfisico = e.tRfisico;
		}
	}
	
}
