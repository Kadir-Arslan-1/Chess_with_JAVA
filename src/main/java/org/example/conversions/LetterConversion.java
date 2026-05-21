package org.example.conversions;

// A method that takes the following inputs and returns the corresponding outputs:
//        8->0, 7->1, 6->2, 5->3, 4->4, 3->5, 2->6, 1->7
public class LetterConversion {

    public static int convert(int num) {
        return 8 - num;}


    public static void main(String[] args) {
        System.out.println(convert(8));
        System.out.println(convert(7));
        System.out.println(convert(6));
        System.out.println(convert(5));
        System.out.println(convert(4));
        System.out.println(convert(3));
        // etc. etc.

    }


}
