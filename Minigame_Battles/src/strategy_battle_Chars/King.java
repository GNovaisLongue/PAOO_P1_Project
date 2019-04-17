package strategy_battle_Chars;

public class King extends Character {

	@Override
	public double causarDano() {
		return Weapon.useWeapon();
		
	}
	
	public King() {
		setNome("Rei");
	}

}
