package strategy_battle_weapons;

public class BowAndArrowBehavior implements WeaponBehavior {

	@Override
	public double useWeapon() {
		return 0.350;
	}
	
	public String toString() {
		return "Arco e Flecha";
	}

}
