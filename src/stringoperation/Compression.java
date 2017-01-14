package stringoperation;

public class Compression {
    // CC150 1.5
    public static String compress(String input) {
        if (input == null || input.isEmpty())
            return "";
        String output = "";
        char prev = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == prev) {
                count++;
            } else {
                output += prev + "" + count;
                prev = input.charAt(i);
                count = 1;
            }
        }
        output += prev + "" + count;
        return output;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(compress("aaaaabbbbbcccccccc"));
    }

}
