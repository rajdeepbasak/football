package org.dartip.football.utility;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.dartip.football.entity.Player;

public class FootballUtility {
	
	private static Optional<Player> getMostSkilledKillablePlayer(List<Player> players, Player killedBy) {
		return players.stream()
			.filter(p-> killedBy.getSkillNumber()>p.getSkillNumber() && !p.isKilled())
			.max(Comparator.comparing(Player::getSkillNumber));
	}
	

	private static Optional<Player> getMostSkilledPlayerWithBullet(List<Player> players) {
		return players.stream()
				.filter(p-> p.getBullet() > 0)
				.max(Comparator.comparing(Player::getSkillNumber));
	}
	
	public static void startPlay(List<Player> players) {
		Optional<Player> mostSkilledWithBullet = Optional.empty();
		Optional<Player> killablePlayerWithLargestSkill = Optional.empty();
		do {
			mostSkilledWithBullet = getMostSkilledPlayerWithBullet(players);
			if(mostSkilledWithBullet.isPresent()) {
				killablePlayerWithLargestSkill = getMostSkilledKillablePlayer(players,mostSkilledWithBullet.get());
				if(killablePlayerWithLargestSkill.isPresent()) {
					mostSkilledWithBullet.get().shoot(killablePlayerWithLargestSkill.get());
				}
			}
		} while(mostSkilledWithBullet.isPresent() && killablePlayerWithLargestSkill.isPresent());
//		return players.stream().filter(p->!p.isKilled()).mapToInt(Player::getSkillNumber).sum();
	}
	
	public static int getTotalSkillofSurvivedPlayer(List<Player> players) {
		return players.stream().filter(p->!p.isKilled()).mapToInt(Player::getSkillNumber).sum();
	}

}
