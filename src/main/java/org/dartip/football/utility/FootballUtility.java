package org.dartip.football.utility;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.dartip.football.entity.Player;

public class FootballUtility {

	/**
	 * This method return the largest skilled player object who can be killed by
	 * 'killedBy' player
	 * 
	 * @param players
	 * @param killedBy
	 * @return
	 */
	private static Optional<Player> getMostSkilledKillablePlayer(List<Player> players, Player killedBy) {
		return players.stream().filter(p -> killedBy.getSkillNumber() > p.getSkillNumber() && !p.isKilled())
				.max(Comparator.comparing(Player::getSkillNumber));
	}

	/**
	 * This method return the Player object who has largest skill Number and who can
	 * kill player
	 * 
	 * @param players
	 * @return
	 */
	private static Optional<Player> getMostSkilledPlayerWithBullet(List<Player> players) {
		return players.stream().filter(p -> p.getBullet() > 0).max(Comparator.comparing(Player::getSkillNumber));
	}

	/**
	 * It will start the play. The logic is --> Largest skilled player can not be
	 * killed and if he kills most skilled player then the sum will be minimized.
	 * Hence largest skilled player with bullet is identified, and the player with
	 * most skill who can be killed is identified
	 * 
	 * @param players
	 */
	public static void startPlay(List<Player> players) {
		Optional<Player> mostSkilledWithBullet = Optional.empty();
		Optional<Player> killablePlayerWithLargestSkill = Optional.empty();
		do {
			mostSkilledWithBullet = getMostSkilledPlayerWithBullet(players);
			if (mostSkilledWithBullet.isPresent()) {
				killablePlayerWithLargestSkill = getMostSkilledKillablePlayer(players, mostSkilledWithBullet.get());
				if (killablePlayerWithLargestSkill.isPresent()) {
					mostSkilledWithBullet.get().shoot(killablePlayerWithLargestSkill.get());
				}
			}
		} while (mostSkilledWithBullet.isPresent() && killablePlayerWithLargestSkill.isPresent());
//		return players.stream().filter(p->!p.isKilled()).mapToInt(Player::getSkillNumber).sum();
	}

	public static int getTotalSkillofSurvivedPlayer(List<Player> players) {
		return players.stream().filter(p -> !p.isKilled()).mapToInt(Player::getSkillNumber).sum();
	}

}
