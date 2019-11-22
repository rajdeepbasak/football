package org.dartip.football.entity;

public class Player {

	private int skillNumber;
	private boolean killed;
	private int bullet;
	
	public Player(int skillNumber) {
		super();
		this.skillNumber = skillNumber;
		this.bullet = 1;
		this.killed = false;
	}

	public int getSkillNumber() {
		return skillNumber;
	}

	public void setSkillNumber(int skillNumber) {
		this.skillNumber = skillNumber;
	}

	public int getBullet() {
		return bullet;
	}

	public boolean isKilled() {
		return killed;
	}

	public void shoot(Player p) {
		p.die();
		bullet -= 1;
	}

	public void die() {
		this.killed = true;
	}
}
