package org.example.conversions;

public class LetterPosition {

    public static int getLetterPosition(char letter) {
        return letter - 'a' + 1;
    }

    public static char getLetter(int number) {
        return (char) ('a' + number - 1);
    }

    public static void main(String[] args) {
        // Running the unit tests
        System.out.println(getLetterPosition('a')); // 1
        System.out.println(getLetterPosition('z')); // 26
        System.out.println(getLetterPosition('w')); // 23
        System.out.println(getLetterPosition('f')); // 6
        System.out.println(getLetterPosition('c')); // 3
        System.out.println(getLetterPosition('h')); // 8

//  A method that takes a number, 1-26, and returns a lowercase letter. 1 would return a, 2 = b, 26 = z, etc.
        System.out.println(getLetter(1));  // a
        System.out.println(getLetter(26)); // z
        System.out.println(getLetter(23)); // w
        System.out.println(getLetter(6));  // f
        System.out.println(getLetter(3));  // c
        System.out.println(getLetter(8));  // h
    }
}


