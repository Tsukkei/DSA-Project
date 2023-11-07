import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<String> songList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Initialize the list with some default songs
        songList.add("Lihim by Arthur Miguel" );
        songList.add("Standing next to you by JK (BTS)" );
        songList.add("Unang Sayaw by Nobita" );
        songList.add("Mercy by Shawn Mendez" );
        songList.add("Fleeting Lullaby by Ado" );
        songList.add("Gusto feat.Al James by Zack Tabudlo, Al James");
        songList.add("Who by Lauv, BTS" );
        songList.add("Future Perfect by ENHYPEN" );
        songList.add("Pasilyo by Sunkissed Lola" );
        songList.add("Raining in Manila by Lola Amour" );
        // ... Add more songs
        while (true) {
            System.out.println("Current Playlist:");
            System.out.println("   ");
            for (int i = 0; i < songList.size(); i++) {
                System.out.println((i + 1) + ". " + songList.get(i));
            }

            System.out.println("   ");

            System.out.println("Options:");
            System.out.println("   ");
            System.out.println("1. Add a favorite song");
            System.out.println("2. Remove a song");
            System.out.println("3. Replace a song");
            System.out.println("4. Exit");

            System.out.println("Please put your Chosen option:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of your favorite song: ");
                    String favoriteSong = scanner.nextLine();
                    songList.add(favoriteSong);
                    break;
                case 2:
                    System.out.print("Enter the index of the song to remove: ");
                    int indexToRemove = scanner.nextInt();
                    if (indexToRemove >= 1 && indexToRemove <= songList.size()) {
                        songList.remove(indexToRemove - 1);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the index of the song to replace: ");
                    int indexToReplace = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the new song: ");
                    String newSong = scanner.nextLine();
                    if (indexToReplace >= 1 && indexToReplace <= songList.size()) {
                        songList.set(indexToReplace - 1, newSong);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
