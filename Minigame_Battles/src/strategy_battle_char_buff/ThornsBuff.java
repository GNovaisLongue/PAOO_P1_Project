package strategy_battle_char_buff;

import strategy_battle_Chars.Character;

public class ThornsBuff extends CharBuffDecorator {
	public ThornsBuff(Character character) {
		setCharacter(character);
	}
	
	@Override
	public double causarDano() {
		return 0.150 + getCharacter().causarDano();
	}
	
	public String toString() {
		return getCharacter().toString() + ", e muitos espinhos";
	}

}
