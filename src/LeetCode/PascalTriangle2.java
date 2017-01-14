package LeetCode;

import java.util.ArrayList;

public class PascalTriangle2 {

    // pass both
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (rowIndex == 0) {
            resultList.add(1);
            return resultList;
        }
        // Initial
        resultList.add(1);
        resultList.add(1);

        for (int i = 2; i <= rowIndex; i++) {
            resultList.add(1, resultList.get(0) + resultList.get(1));
            for (int j = 2; j < resultList.size() - 1; j++) {
                resultList.set(j, resultList.get(j) + resultList.get(j + 1));
            }
        }

        return resultList;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
