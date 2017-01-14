package interviewStreet;

import java.util.ArrayList;

public class FlatList {
    public ArrayList<Integer> flat(ArrayList a, ArrayList<Integer> ret) {
        for (Object o : a) {
            if (o instanceof Integer) {
                ret.add((Integer) o);
            } else if (o instanceof ArrayList) {
                ret = flat((ArrayList) o, ret);
            }
        }
        return ret;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
