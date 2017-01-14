package CrackingCoding;

import java.util.ArrayList;
import java.util.HashMap;

public class c9_10 {
    public static class Box {
        public int width;
        public int height;
        public int depth;

        public Box(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }

        public boolean canBeUnder(Box b) {
            if (width > b.width && height > b.height && depth > b.depth) {
                return true;
            }
            return false;
        }

        public boolean canBeAbove(Box b) {
            if (b == null) {
                return true;
            }
            if (width < b.width && height < b.height && depth < b.depth) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Box(" + width + "," + height + "," + depth + ")";
        }
    }

    public static int stackHeight(ArrayList<Box> boxes) {
        if (boxes == null) {
            return 0;
        }
        int h = 0;
        for (Box b : boxes) {
            h += b.height;
        }
        return h;
    }

    public static ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
        int max_height = 0;
        ArrayList<Box> max_stack = null;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].canBeAbove(bottom)) {
                ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
                int new_height = stackHeight(new_stack);
                if (new_height > max_height) {
                    max_stack = new_stack;
                    max_height = new_height;
                }
            }
        }

        if (max_stack == null) {
            max_stack = new ArrayList<Box>();
        }
        if (bottom != null) {
            max_stack.add(0, bottom);
        }

        return max_stack;
    }

    public static ArrayList<Box> createStackDP(Box[] boxes, Box bottom,
                                               HashMap<Box, ArrayList<Box>> stack_map) {
        if (bottom != null && stack_map.containsKey(bottom)) {
            return (ArrayList<Box>) stack_map.get(bottom).clone();
        }

        int max_height = 0;
        ArrayList<Box> max_stack = null;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].canBeAbove(bottom)) {
                ArrayList<Box> new_stack = createStackDP(boxes, boxes[i],
                        stack_map);
                int new_height = stackHeight(new_stack);
                if (new_height > max_height) {
                    max_stack = new_stack;
                    max_height = new_height;
                }
            }
        }

        if (max_stack == null) {
            max_stack = new ArrayList<Box>();
        }
        if (bottom != null) {
            max_stack.add(0, bottom);
        }
        stack_map.put(bottom, max_stack);

        return max_stack;
    }

    public static void main(String[] args) {
        Box[] boxes = {new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3)};

        ArrayList<Box> stack = createStackDP(boxes, null,
                new HashMap<Box, ArrayList<Box>>());
        // ArrayList<Box> stack = createStackR(boxes, null);
        for (int i = stack.size() - 1; i >= 0; i--) {
            Box b = stack.get(i);
            System.out.println(b.toString());
        }
    }

}
