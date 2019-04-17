package strategy_battle_Chars;

import strategy_battle_weapons.WeaponBehavior;

public abstract class Character {
	WeaponBehavior Weapon;
	private double vida = 1;
	private String nome;
	
	public abstract double causarDano();//dano 'double' das armas
	
	public void receberDano(double dano) {
		this.vida -= dano;
	}
	
	public void setVida(double vida) {
		this.vida = vida;
	}
	
	public double getVida() {
		return vida;
	}
	
	public void recuperarMaxVida() {
		setVida(1);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public Boolean aindaVivo() {
		return this.vida > 0.0;
	}
	
	public void setWeapon(WeaponBehavior w) {
		Weapon = w;
	}
	
	public String toString() {
		return this.nome + " com " + Weapon;
	}
	
}
