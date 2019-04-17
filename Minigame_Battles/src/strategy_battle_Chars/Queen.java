package strategy_battle_Chars;

public class Queen extends Character {

	@Override
	public double causarDano() {
		return Weapon.useWeapon();
		
	}
	
	public Queen() {
		setNome("Rainha");
	}

}
