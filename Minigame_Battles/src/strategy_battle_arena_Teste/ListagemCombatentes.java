package strategy_battle_arena_Teste;

import strategy_battle_Chars.Character;

public class ListagemCombatentes {
	private Character p;
	
	public ListagemCombatentes (Character p) {
		this.p = p;
	}
	
	public Character getplayer() {
		return p;
	}
	
	public String toString() {
		return "participante: " + p;
	}
}
