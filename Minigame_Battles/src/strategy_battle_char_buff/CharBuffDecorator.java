package strategy_battle_char_buff;

import strategy_battle_Chars.Character;

public abstract class CharBuffDecorator extends Character{
	private Character combatente;
	
	public Character getCharacter() {
		return combatente;
	}
	
	public void setCharacter(Character character) {
		this.combatente = character;
	}

}
