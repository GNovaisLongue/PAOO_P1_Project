package strategy_battle_char_buff;

import strategy_battle_Chars.Character;

public class BeastTamerBuff extends CharBuffDecorator {
	public BeastTamerBuff(Character character) {
		setCharacter(character);
	}
	
	@Override
	public double causarDano() {
		return 0.100 + getCharacter().causarDano();
	}
	
	public String toString() {
		return getCharacter().toString() + ", e domador de feras";
	}

}