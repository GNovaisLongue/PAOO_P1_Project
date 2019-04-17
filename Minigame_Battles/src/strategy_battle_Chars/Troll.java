package strategy_battle_Chars;

public class Troll extends Character {

	@Override
	public double causarDano() {
		return Weapon.useWeapon();
		
	}
	
	public Troll() {
		setNome("Troll");
	}
	
}
