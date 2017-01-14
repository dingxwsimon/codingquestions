package LeetCode;

public class IntToRoman {

    static String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM", "  ", " ", "  ", "   ", "    ", "  "},
            {"", "", "", "", "", "", "", "", "", ""}};

    public static String intToRoman1(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num > 3999 || num < 1) {
            return "";
        }
        // count how many digits in num
        int m = 1, d = 1;
        while (m <= num) {
            m *= 10;
            d++;
        }
        StringBuilder sb = new StringBuilder();
        // search table based on the digits in num
        while (m > 0) {
            sb.append(roman[--d][num / m]);
            num = num % m;
            m = m / 10;
        }
        return sb.toString();
    }

    public static String intToRoman2(int num) {
        String str = "";
        String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
        int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num != 0; ++i) {
            while (num >= value[i]) {
                num -= value[i];
                str += symbol[i];
            }
        }
        return str;
    }

    public static String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String roman = "";

        int number = num;

        while (number >= 1000) {
            roman += "M";
            number -= 1000;
        }

        while (number >= 900) {
            roman += "CM";
            number -= 900;
        }

        while (number >= 500) {
            roman += "D";
            number -= 500;
        }

        while (number >= 400) {
            roman += "CD";
            number -= 400;
        }

        while (number >= 100) {
            roman += "C";
            number -= 100;
        }

        while (number >= 90) {
            roman += "XC";
            number -= 90;
        }

        while (number >= 50) {
            roman += "L";
            number -= 50;
        }

        while (number >= 40) {
            roman += "XL";
            number -= 40;
        }

        while (number >= 10) {
            roman += "X";
            number -= 10;
        }

        while (number >= 9) {
            roman += "IX";
            number -= 9;
        }

        while (number >= 5) {
            roman += "V";
            number -= 5;
        }

        while (number >= 4) {
            roman += "IV";
            number -= 4;
        }

        while (number >= 1) {
            roman += "I";
            number -= 1;
        }

        System.out.println(num + " in Roman numerals is " + roman);
        return roman;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(intToRoman1(3999));
    }

}
