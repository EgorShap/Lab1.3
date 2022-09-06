package football_teams;
import java.util.Scanner;

public class RecordTeam {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in, "cp1251");

        // Entering information about teams
        System.out.println("Enter the number of the football teams =>");
        int num = scan.nextInt();  // the number of teams
        FootballTeam team[] = new FootballTeam[num];
        System.out.println("Enter the info about football team =>");

        for (int i=0; i< team.length; i++){
            scan.nextLine();  // buffer clearing
            team[i] = new FootballTeam();

            System.out.print("Name of the "+(i+1)+" team =>");
            team[i].name = scan.nextLine();

            System.out.print("Country of the "+(i+1)+" team =>");
            team[i].country = scan.nextLine();

            System.out.print("Place in league of the "+(i+1)+" team =>");
            team[i].league_place = scan.nextInt();

            System.out.print("Number of wins of the "+(i+1)+" team =>");
            team[i].win_num = scan.nextInt();
        }
        // Output of the entered info
        System.out.println("\nTeam characteristics");

        for(int i=0; i< team.length;i++) {
            System.out.println("" + team[i].name + "\t" + team[i].country + "\t" + team[i].league_place + "\t" + team[i].win_num);
        }

        // Teams with number of wins more than average
        int sum_win = 0;  //the total number of wins
        for (int i=0; i< team.length; i++) {
            sum_win += team[i].win_num;
        }
        double avg_sum_win = sum_win/team.length;  //the average number of wins
        System.out.println("Average number of wins = "+avg_sum_win);
        System.out.println("\nTeams with more wins than average :");
        for(int i=0; i< team.length;i++){
            if(team[i].win_num>avg_sum_win) {
                System.out.println(team[i].name + "\t" + team[i].country + "\t" + team[i].league_place + "\t" + team[i].win_num);
            }
        }

        // Arranging the array by descending places in league
        for(int i=0; i<team.length-1; i++){
            for(int j=0; j< team.length-1-i; j++){
                if(team[j].league_place>team[j+1].league_place){
                    FootballTeam temp = team[j];  //temp - temporary variable to sort
                    team[j]=team[j+1];
                    team[j+1]=temp;
                }
            }
        }
        System.out.println("\nArranged array of football teams by descending places in league:");
        for(int i =0; i< team.length; i++) {
            System.out.println(team[i].name + "\t" + team[i].country + "\t" + team[i].league_place + "\t" + team[i].win_num);
        }

        // Searching team by name
        scan.nextLine();  // buffer clearing
        System.out.println("Enter the name of football team for search: ");
        String search_name = scan.nextLine();
        int search_id = -1;  // -1 - team with entered name doesn't exist

        for (int i =0; i< team.length;i++){
            if(search_name.equalsIgnoreCase(team[i].name)){
                search_id=i;
            }
        }
        if (search_id !=-1){
            System.out.println("This team is exist in list. It is "+team[search_id].name+" "+team[search_id].country+ " "+team[search_id].league_place + " "+team[search_id].win_num);
        } else System.out.println("Country with this name doesn't exist in the list");

    }
}
