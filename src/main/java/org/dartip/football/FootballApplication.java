package org.dartip.football;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.dartip.football.entity.Player;
import org.dartip.football.utility.FootballUtility;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FootballApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
  
		List<Player> players =  new ArrayList<>();
		try(Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				players.add(new Player(sc.nextInt()));
			}
		} catch (InputMismatchException e) {
			System.out.println("Pleaase run again and provide Integere Value only");
			return;
		}
		FootballUtility.startPlay(players);
		System.out.println(FootballUtility.getTotalSkillofSurvivedPlayer(players));
    }

}
