package strategy_battle_arenaMain;

import java.text.DecimalFormat;

import strategy_battle_Chars.Character;


public class ListaCombateUmVersusUm {
	DecimalFormat dec = new DecimalFormat("#0.00");
	private Character p1;
	private Character p2;
	
	public ListaCombateUmVersusUm (Character p1, Character p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Character getPessoa1() {
		return p1;
	}
	
	public Character getPessoa2() {
		return p2;
	}
	
	public void p1Ataca() {
		System.out.println(this.p1 + " atacou e causou um total de " + dec.format(this.p1.causarDano()) + " de dano!" );
		this.p2.receberDano(this.p1.causarDano());
		//p2 recebe o dano causado por p1
	}
	
	public void p2Ataca() {
		System.out.println(this.p2 + " atacou e causou um total de " + dec.format(this.p2.causarDano()) + " de dano!" );
		this.p1.receberDano(this.p2.causarDano());
		//p1 recebe o dano causado por p2
	}
	
	public boolean batalhando() {
		return this.p1.aindaVivo() && this.p2.aindaVivo();
	}
	
	public Character quemVenceu() {
		if(this.p1.aindaVivo())
			return p1;
		else
			return p2;
	}
	@Override
	public String toString() {
		return p1 + " VS " + p2 ;
	}
}