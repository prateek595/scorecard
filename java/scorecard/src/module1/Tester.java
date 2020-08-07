package module1;

import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			System.out.println("No. of players for each team:");
			int team_players=sc.nextInt();
			System.out.println("No. of overs:");
			int total_overs=sc.nextInt();
			System.out.println("Batting Order for team 1:");
			Players[] team_1_player=new Players[team_players];
			for(int i=0;i<team_players;i++)
			{
				
				team_1_player[i]=new Players(1,sc.next());
				
				
			}
			Play.addScore(team_1_player,team_players,total_overs,1);
			
			Players[] team_2_player=new Players[team_players];
			System.out.println("Batting Order for team 2:");
			for(int i=0;i<team_players;i++)
			{
				team_2_player[i]=new Players(2,sc.next());
			}
			Play.addScore(team_2_player,team_players,total_overs,2);
		int temp=Players.getTeam_1_total()-Players.getTeam_2_total();
		if(temp>0)
		{
			
			System.out.println("Team 1 won the match by "+temp+"runs");
		}
		if(temp<0)
		{
			int wicket= team_players-1-Players.getTeam_2_wickets();
			System.out.println("Team 2 won the match by "+wicket+"wickets");
		}
		if(temp==0)
		{
			System.out.println("match draw");
		}
	}
	
	
}
