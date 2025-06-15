Suppose,you are developing a BPL Player Draft System in Java.Here,Draft admin needs to add the
total number of register Players with their info (iccID,name,nationality,jerseyNumber,role)in two
separate storage named localPlayerList and foreignPlayerList along with total number of Teams with
its info (teamID,name,ownerName,squad).As a developer,you need to shuffle the list randomly and
then the draft begins with the team owners who need to pick player based on their random key.
Develop the application following the concepts of OOP in Java and all the Collection frameworks.

Solve:
import java.util.*;
// Player Class
class Player {
String iccID, name, nationality, role;
int jerseyNumber;
Player(String iccID, String name, String nationality, int jerseyNumber, String role) {
this.iccID = iccID;
this.name = name;
this.nationality = nationality;
this.jerseyNumber = jerseyNumber;
this.role = role;
}
boolean isForeign() {
return !nationality.equalsIgnoreCase("Bangladesh");
}
@Override
public String toString() {
return name + " (" + role + ", " + nationality + ")";
}
}
// Team Class
class Team {
String teamID, name, ownerName;
List<Player> squad;
Team(String teamID, String name, String ownerName) {
this.teamID = teamID;
this.name = name;
this.ownerName = ownerName;
this.squad = new ArrayList<>();
}
void addPlayer(Player p) {
squad.add(p);
}
void showSquad() {
System.out.println("\nTeam: " + name + " | Owner: " + ownerName);
for (Player p : squad) {
System.out.println(" - " + p);
}
}
}
// Main Draft System
public class BPLDraftSystem {
List<Player> localPlayerList = new ArrayList<>();
List<Player> foreignPlayerList = new ArrayList<>();
List<Team> teamList = new ArrayList<>();
public void addPlayer(Player p) {
if (p.isForeign()) {
foreignPlayerList.add(p);
} else {
localPlayerList.add(p);
}
}
public void addTeam(Team t) {
teamList.add(t);
}
public void startDraft() {
// Shuffle everything
Collections.shuffle(localPlayerList);
Collections.shuffle(foreignPlayerList);
Collections.shuffle(teamList);
System.out.println("\n--- DRAFT STARTED ---");
// Simple round-robin player picking
int totalRounds = 2; // example: each team picks 1 local & 1 foreign
int localIndex = 0, foreignIndex = 0;
for (int round = 0; round < totalRounds; round++) {
for (Team team : teamList) {
if (round == 0 && localIndex < localPlayerList.size()) {
team.addPlayer(localPlayerList.get(localIndex++));
} else if (round == 1 && foreignIndex < foreignPlayerList.size()) {
team.addPlayer(foreignPlayerList.get(foreignIndex++));
}
}
}
System.out.println("--- DRAFT ENDED ---");
}
public void showAllTeams() {
for (Team team : teamList) {
team.showSquad();
}
}
public static void main(String[] args) {
BPLDraftSystem system = new BPLDraftSystem();
// Adding Players
system.addPlayer(new Player("P001", "Shakib", "Bangladesh", 75, "Allrounder"));
system.addPlayer(new Player("P002", "Tamim", "Bangladesh", 29, "Batsman"));
system.addPlayer(new Player("P003", "Warner", "Australia", 31, "Batsman"));
system.addPlayer(new Player("P004", "Malinga", "Sri Lanka", 99, "Bowler"));
// Adding Teams
system.addTeam(new Team("T1", "Dhaka Strikers", "Rana"));
system.addTeam(new Team("T2", "Chattogram Warriors", "Sabbir"));
// Start Draft
system.startDraft();
// Show Squads
system.showAllTeams();
}
}
