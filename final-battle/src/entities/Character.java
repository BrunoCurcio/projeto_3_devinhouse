package entities;

public abstract class Character {
	private int healthPoints;
	private int atkPoints;
	private int defPoints;
	
	public Character(int healthPoints, int atkPoints, int defPoints) {
		
		this.healthPoints = healthPoints;
		this.atkPoints = atkPoints;
		this.defPoints = defPoints;
	}
	
	public int takeDamage(int sufferedAtk, boolean criticalDamage) {
		if (sufferedAtk <= this.defPoints) {
			return 0;
		}
		
		int damageTaken = sufferedAtk;
		
		if (!criticalDamage) {
			damageTaken -= this.defPoints;
		}
		
		this.healthPoints -= damageTaken;
		
		return damageTaken;
	}
	
	public int getHealthPoints() {
		return this.healthPoints;
	}

	public int getAtkPoints() {
		return this.atkPoints;
	}

	public void increaseDef(int increase) {
		this.defPoints += increase;
	}
	
	public void heal(int maxHealth) {
		this.healthPoints = maxHealth;
	}

	public boolean dead() {
		return this.getHealthPoints() < 1;
	}	
}