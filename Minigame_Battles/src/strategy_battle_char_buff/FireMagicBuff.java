package strategy_battle_char_buff;

import strategy_battle_Chars.Character;

public class FireMagicBuff extends CharBuffDecorator {
	public FireMagicBuff(Character character) {
		setCharacter(character);
	}
	
	@Override
	public double causarDano() {
		return 0.200 + getCharacter().causarDano();
	}
	
	public String toString() {
		return getCharacter().toString() + ", em chamas";
	}

}
