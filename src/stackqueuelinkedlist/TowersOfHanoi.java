package stackqueuelinkedlist;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TowersOfHanoi {

    static int moves = 0;
    static int totalDisks = 0;

    public static void main(String[] arguments) throws java.io.IOException {
        int disks;
        char fromPole = 'A';
        char withPole = 'B';
        char toPole = 'C';
        disks = getNumber("\nHow many disks are there on the tower? ");
        totalDisks = disks;
        if (totalDisks > 10) {
            System.out.println("Working...");
        }
        FileOutputStream fos = new FileOutputStream("TowersOfHanoiSolution.txt");
        PrintStream ps = new PrintStream(fos);
        solveHanoi(disks, fromPole, toPole, withPole, ps);
        ps.close();
        System.out.println();
        System.out.println("\nAmount of moves: " + moves + "\n");
        System.out
                .print("You can now access the TowersOfHanoiSolution.txt file");
        System.out
                .println(" which is in the same directory as the .class file of this program.");
    }

    static void solveHanoi(int disks, char fromPole, char toPole,
                           char withPole, PrintStream ps) {
        if (disks >= 1) {
            // move the first disk-1 disk from -> the with(buffer) pole
            solveHanoi(disks - 1, fromPole, withPole, toPole, ps);
            // move the last one from -> to pole
            moveDisk(fromPole, toPole, ps);
            // move the disk-1 disk from with(buffer) -> topole
            solveHanoi(disks - 1, withPole, toPole, fromPole, ps);
        }
    }

    static void moveDisk(char fromPole, char toPole, PrintStream ps) {
        moves++;
        if (totalDisks <= 10) {
            System.out.print("Move from " + fromPole + " to " + toPole + ". ");
            ps.print("Move from " + fromPole + " to " + toPole + ". ");
            if (moves % 4 == 0) {
                System.out.println();
                ps.println();
            }
        } else {
            ps.print("Move from " + fromPole + " to " + toPole + ". ");
            if (moves % 4 == 0) {
                ps.println();
            }
        }
    }

    static int getNumber(String question) throws java.io.IOException {
        String theNumber;
        int number = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(question);
        theNumber = in.readLine();
        System.out.println();
        number = Integer.parseInt(theNumber);
        return number;
    }
}
