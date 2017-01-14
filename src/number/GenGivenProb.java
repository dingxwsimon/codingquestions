package number;

import java.util.Random;

public class GenGivenProb {/*
                * ����һ������������԰���0.5�ĸ��ʷ���true�� Ҫ��ʵ��һ�������������������ʵ�true��
			    */

    boolean RNGwithGivenProb(double p, boolean expected) {
        if (p < 0.5)
            return RNGwithGivenProb(1 - p, !expected);
        if (RNG() == expected)
            return expected;
        else
            return RNGwithGivenProb((p - 0.5) * 2, expected);
    }

    boolean RNG() {
        int min = 1;
        int max = 10;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if (randomNum < 5)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
