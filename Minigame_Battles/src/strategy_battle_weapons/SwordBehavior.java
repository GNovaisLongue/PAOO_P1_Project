package strategy_battle_weapons;

public class SwordBehavior implements WeaponBehavior {

	@Override
	public double useWeapon() {
		return 0.300;
	}

	public String toString() {
		return "Espada";
	}
}
