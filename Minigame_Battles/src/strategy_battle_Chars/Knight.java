package strategy_battle_Chars;

public class Knight extends Character {

	@Override
	public double causarDano() {
		return Weapon.useWeapon();
		
	}
	
	public Knight() {
		setNome("Cavaleiro");
	}

}
