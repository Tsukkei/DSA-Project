import java.util.PriorityQueue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PriorityQueue<String> songQueue = new PriorityQueue<>(10, (s1, s2) -> s1.compareTo(s2));
        Scanner scanner = new Scanner(System.in);

        // Initialize the priority queue with some default songs
        songQueue.add("Lihim by Arthur Miguel");
        songQueue.add("Standing next to you by JK (BTS)");
        songQueue.add("Unang Sayaw by Nobita");
        songQueue.add("Mercy by Shawn Mendez");
        songQueue.add("Fleeting Lullaby by Ado");
        songQueue.add("Gusto feat. Al James by Zack Tabudlo, Al James");
        songQueue.add("Who by Lauv, BTS");
        songQueue.add("Future Perfect by ENHYPEN");
        songQueue.add("Pasilyo by Sunkissed Lola");
        songQueue.add("Raining in Manila by Lola Amour");

        while (true) {
            System.out.println("Current Playlist:");
            System.out.println("   ");

            // Convert the priority queue to an array for display
            String[] songArray = songQueue.toArray(new String[0]);
            for (int i = 0; i < songArray.length; i++) {
                System.out.println((i + 1) + ". " + songArray[i]);
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
                    songQueue.add(favoriteSong);
                    break;
                case 2:
                    System.out.print("Enter the index of the song to remove: ");
                    int indexToRemove = scanner.nextInt();
                    if (indexToRemove >= 1 && indexToRemove <= songArray.length) {
                        // Convert the array back to a priority queue to remove elements
                        songQueue = new PriorityQueue<>(songArray.length, (s1, s2) -> s1.compareTo(s2));
                        for (String song : songArray) {
                            if (song != null) {
                                songQueue.add(song);
                            }
                        }
                        // Remove the selected song
                        for (int i = 1; i < indexToRemove; i++) {
                            songQueue.poll();
                        }
                        songQueue.poll(); // Remove the selected song
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
                    if (indexToReplace >= 1 && indexToReplace <= songArray.length) {
                        // Convert the array back to a priority queue to replace elements
                        songQueue = new PriorityQueue<>(songArray.length, (s1, s2) -> s1.compareTo(s2));
                        for (String song : songArray) {
                            if (song != null) {
                                songQueue.add(song);
                            }
                        }
                        // Replace the selected song
                        for (int i = 1; i < indexToReplace; i++) {
                            songQueue.poll();
                        }
                        songQueue.poll(); // Remove the selected song
                        songQueue.add(newSong); // Add the new song
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
