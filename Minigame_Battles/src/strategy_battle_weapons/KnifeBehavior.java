package strategy_battle_weapons;

public class KnifeBehavior implements WeaponBehavior {

	@Override
	public double useWeapon() {
		return 0.200;
	}
	
	public String toString() {
		return "Faca";
	}

}
