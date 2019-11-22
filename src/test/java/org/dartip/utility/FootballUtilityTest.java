package org.dartip.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dartip.football.entity.Player;
import org.dartip.football.utility.FootballUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FootballUtilityTest {
	public Map<Integer, List<Player>> getDatasetforGetMostSkilledKillablePlayer() {
		Map<Integer,List<Player>> dataset = new HashMap<>();
		dataset.put(8,Arrays.asList(
				new Player(4), 
				new Player(5), 
				new Player(2), 
				new Player(8), 
				new Player(3),
				new Player(1)));
		
		dataset.put(3,Arrays.asList(
				new Player(3)));
		dataset.put(0,Arrays.asList());
		return dataset;
	}

	@Test
	public void testPlay() {
////		for (Entry<Integer, List<Player>> entry : getDatasetforGetMostSkilledKillablePlayer().entrySet()) {
//			List<Player> players =  entry.getValue();
//			FootballUtility.startPlay(players);
//			Assertions.assertEquals(entry, FootballUtility.getTotalSkillofSurvivedPlayer(players));
//		}
		getDatasetforGetMostSkilledKillablePlayer().forEach((answer,players)->{
			FootballUtility.startPlay(players);
			Assertions.assertEquals(answer, FootballUtility.getTotalSkillofSurvivedPlayer(players));
		});
	}
}
