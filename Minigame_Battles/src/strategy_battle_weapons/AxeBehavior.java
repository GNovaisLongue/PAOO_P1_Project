package strategy_battle_weapons;

public class AxeBehavior implements WeaponBehavior {

	@Override
	public double useWeapon() {
		return 0.400;
	}
	
	public String toString() {
		return "Machado";
	}

}
