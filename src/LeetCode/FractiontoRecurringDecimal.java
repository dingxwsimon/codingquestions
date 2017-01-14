package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException(" denominator can not be zero");
        }

        // avoid overflow for minimum vlaue of interger
        long newNum = (long) numerator;
        long newDeNom = (long) denominator;

        StringBuilder sb = new StringBuilder();

        // detect sign
        if ((newNum > 0 && newDeNom < 0) || (newNum < 0 && newDeNom > 0)) {
            sb.append("-");
        }
        // make sure it is postive value
        newNum = Math.abs(newNum);
        newDeNom = Math.abs(newDeNom);

        sb.append(newNum / newDeNom);

        long reminder = newNum % newDeNom;
        Map<Long, Integer> reminderMap = new HashMap<Long, Integer>();

        if (reminder != 0) {
            sb.append(".");
        }

        while (reminder != 0 && !reminderMap.containsKey(reminder)) {
            reminderMap.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / newDeNom);
            reminder = reminder % newDeNom;
        }

        if (reminderMap.containsKey(reminder)) {
            sb.insert(reminderMap.get(reminder), "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
