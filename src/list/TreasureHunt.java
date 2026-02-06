package list;

import java.util.LinkedList;
import java.util.List;

public class TreasureHunt {

    List<String> clues = new LinkedList<String>();

    public void getAllClues() {
        for (String clue : clues)
            System.out.print("clue --> " + clue);
    }

    public static void main(String[] args) {

        TreasureHunt th = new TreasureHunt();
        th.clues.add("this is monday");
        th.clues.add("Go to the fountain in the park");
        th.clues.add("look for the oak tree");

        System.out.println(th.clues);

        th.clues.set(2, "new set variable follow that ");

        // th.getAllClues();

        System.out.println(th.clues);

    }

}
