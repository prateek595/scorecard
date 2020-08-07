package module1;

import java.util.Scanner;

public class Players {
	private int score,boundry_4,boundry_6,balls;
	private static int team_1_total,team_1_extra_run=0,team_2_total,team_2_extra_run=0,team_1_wickets,team_2_wickets;
	private String status,player_name;
	//status : out=o,not_out=n,yet_to_bat=y
	private double strike_rate;
	Scanner sc=new Scanner(System.in);
	public Players(int team, String player_name) {
		super();
		this.score = 0;
		this.boundry_4 = 0;
		this.boundry_6 = 0;
		this.balls = 0;
		this.status = "y";
		this.player_name = player_name;
		this.strike_rate = 0.0;
	}
	
	public static int getTeam_1_total() {
		return team_1_total;
	}

	public static void setTeam_1_total(int team_1_total) {
		Players.team_1_total = team_1_total;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBoundry_4() {
		return boundry_4;
	}

	public void setBoundry_4(int boundry_4) {
		this.boundry_4 = boundry_4;
	}

	public int getBoundry_6() {
		return boundry_6;
	}

	public void setBoundry_6(int boundry_6) {
		this.boundry_6 = boundry_6;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public static int getTeam_1_extra_run() {
		return team_1_extra_run;
	}

	public static void setTeam_1_extra_run(int team_1_extra_run) {
		Players.team_1_extra_run = team_1_extra_run;
	}

	public static int getTeam_2_extra_run() {
		return team_2_extra_run;
	}

	public static void setTeam_2_extra_run(int team_2_extra_run) {
		Players.team_2_extra_run = team_2_extra_run;
	}

	public static int getTeam_1_wickets() {
		return team_1_wickets;
	}

	public static void setTeam_1_wickets(int team_1_wickets) {
		Players.team_1_wickets = team_1_wickets;
	}

	public static int getTeam_2_wickets() {
		return team_2_wickets;
	}

	public static void setTeam_2_wickets(int team_2_wickets) {
		Players.team_2_wickets = team_2_wickets;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public double getStrike_rate() {
		return strike_rate;
	}

	public void setStrike_rate(double strike_rate) {
		this.strike_rate = strike_rate;
	}


	public static int getTeam_2_total() {
		return team_2_total;
	}

	public static void setTeam_2_total(int team_2_total) {
		Players.team_2_total = team_2_total;
	}

	@Override
	public String toString() {
		if(status=="n")
		{
			return ""+player_name+"*\t\t"+score+"\t"+boundry_4+"\t"+boundry_6+"\t"+balls+"\t"+strike_rate;
		}
		else
			return ""+player_name+"\t\t"+score+"\t"+boundry_4+"\t"+boundry_6+"\t"+balls+"\t"+strike_rate;
	}
	//calculate team toatal
	public void calculate_totalrun(int run,int team)
	{
		if(team==1)
		{
			Players.setTeam_1_total(Players.team_1_total+run);
		}
		if(team==2)
		{
			Players.setTeam_2_total(Players.team_2_total+run);
		}
	}
	//calculate team wickets
	public void calculate_team_wicket(int team)
	{
		if(team==1)
		{
			Players.setTeam_1_wickets(Players.team_1_wickets+1);
		}
		if(team==2)
		{
			Players.setTeam_2_wickets(Players.team_2_wickets+1);
		}
	}
	// return 0 if strike changes 
	//return 1 if good ball and no strike change
	//return 2 if wicket
	//return 3 if extra ball
	public int calculate_score(int a,int team)
	{
		switch(a)
		{
		case 0:
			this.balls+=1;
			return 1;
		case 1:
			this.score+=1;
			this.calculate_totalrun(1, team);
			this.balls+=1;
			return 0;
		case 2:
			this.score+=2;
			this.calculate_totalrun(2, team);
			this.balls+=1;
			return 1;
		case 3:
			this.score+=3;
			this.calculate_totalrun(3, team);
			this.balls+=1;
			return 0;
		case 4:
			this.score+=4;
			this.calculate_totalrun(4, team);
			this.boundry_4+=1;
			this.balls+=1;
			return 1;
		case 5:
			this.score+=6;
			this.calculate_totalrun(6, team);
			this.boundry_6+=1;
			this.balls+=1;
			return 1;
		case 6:
			if(team==1)
				team_1_extra_run+=1;
			else
				team_2_extra_run+=1;
			this.calculate_totalrun(1, team);
			return 3;
		case 7:
			if(team==1)
				team_1_extra_run+=1;
			else
				team_2_extra_run+=1;
			this.calculate_totalrun(1, team);
			return 3;
		case 8:
			this.status = "o";
			this.balls+=1;
			this.calculate_team_wicket(team);
			return 2;
		}
		
		return -1;
		
		
	}
	

}
