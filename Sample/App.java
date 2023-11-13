import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<String> songList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input all songs from the user
        System.out.println("Enter your favorite songs (type 'done' when finished):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            songList.add(input);
        }

        while (true) {
            System.out.println("Current Playlist:");
            System.out.println("   ");
            for (int i = 0; i < songList.size(); i++) {
                System.out.println((i + 1) + ". " + songList.get(i));
            }

            System.out.println("   ");

            System.out.println("Options:");
            System.out.println("   ");
            System.out.println("1. Add a New song");
            System.out.println("2. Remove a song");
            System.out.println("3. Replace a song");
            System.out.println("4. Exit");

            System.out.println("Please put your Chosen option:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the song: ");
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
