package serviceNowQuestions;

import java.util.ArrayList;

public class BestSum {
    public static void main(String[] args) {
        ArrayList<Integer> parent=new ArrayList<>();
        parent.add(-1);
        parent.add(0);
        parent.add(1);
        parent.add(2);
        parent.add(1);

        ArrayList<Integer> value=new ArrayList<>();
        value.add(5);
        value.add(7);
        value.add(2);
        value.add(4);
        value.add(15);

        ArrayList<ArrayList<Integer>> tree =new ArrayList<>();

        for (int i = 0; i < parent.size(); i++) {
            tree.add(new ArrayList<>());

        }
    }
}