package module1;

import java.util.Scanner;

public class Play {
	
	public static boolean addScore(Players[] player,int team_players,int total_overs,int team)
	{
		int i=0,j=1;
		double over=0.0;
		int over_ball,temp_ball,ball_input=1;
		int wicket=0;
		boolean flag=false,exit=false;
		Scanner sc = new Scanner(System.in);
			player[i].setStatus("n");
			player[j].setStatus("n");
			while(!exit)
			{
				over_ball=1;
				System.out.println("over "+over);
				System.out.println("menu");
				System.out.println("0: 0 run\n1: 1 run\n2: 2 run\n3: 3 run\n4: 4 run\n"
						+ "5: 6 run\n6: no ball\n7 : wide ball\n8 : out ");
				System.out.println("Enter your choice");
				while(over_ball<7)
				{
					System.out.println("ball "+over_ball);
					while(!flag)
					{
						ball_input=sc.nextInt();
						if(ball_input>-1 && ball_input<9)
						{
							break;
						}
						System.out.println("invalid input! Try again");
					}
					temp_ball=player[i].calculate_score(ball_input,team);
					
					if(temp_ball==0 || temp_ball==6)
					{
						int temp_result[]=swapbatsman(i,j);
						i=temp_result[0];
						j=temp_result[1];
					}
					if(temp_ball==2)
					{
						wicket+=1;
						if(wicket==team_players-1)
						{
							print_result(player,team);
							exit=true;
							break;
						}
						i=nextbatsman(i,wicket);
						player[i].setStatus("n");
					}
					
					if(temp_ball>-1 && temp_ball<3)
					{
						over_ball+=1;
					}
					
					if(over_ball==7)
					{
						over+=1;
						print_result(player,team);
					}
					if(team==2)
					{
						if(Players.getTeam_2_total()>Players.getTeam_1_total())
						{
							exit=true;
							break;
						}
					}
				}
				if(!(over<total_overs))
					exit=true;
				
			}
		
		return true;
	}
	
	//change strike
	public static int[] swapbatsman(int i,int j)
	{
		return new int[] {j,i};
	}
	
	//change batsman on wicket
	public static int nextbatsman(int i,int j)
	{
			i=j+1;
			return i;
	}
	
	//print scorecard	
	public static void print_result(Players[] player,int team)
	{
		System.out.println("Scorecard for Team "+team);
		System.out.println("Player Name\tScore\t4s\t6s\tBalls\tStrike Rate");
		for (Players p : player) {
			if (p == null)
				break;
			if(p.getBalls()!=0)
				p.setStrike_rate((p.getScore()/p.getBalls())*100);
			System.out.println(p.toString());				

		}
		if(team==1)
		{
			System.out.println("Team total "+Players.getTeam_1_total()+"/"+Players.getTeam_1_wickets());
			System.out.println("Team extra "+Players.getTeam_1_extra_run());
		}
		
		else
		{
			System.out.println("Team total "+Players.getTeam_2_total()+"/"+Players.getTeam_2_wickets());
			System.out.println("Team extra "+Players.getTeam_2_extra_run());
		}
	}

}
