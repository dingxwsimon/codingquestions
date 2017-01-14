package tree;

public class ParenthesssRepresentTree {
    public static int find_depth(String input) {
        String str = input;
        int ret = 0;
        int time = 0;
        while (str.contains("(00)")) {
            time = time + 1;
            str = str.replace("(00)", "0");
        }
        if (time != 0 && str.equals("0") && !input.equals("0")) {
            ret = time - 1;
        } else {
            ret = -1;
        }

        return ret;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(find_depth("((00)(0(0(00))))"));
    }

}
