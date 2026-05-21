package org.example.conversions;


//    In the chess board image below, square a8 might map toarray[0][0], and h1 might map to array[7][7].
//    We are going to write a method that takes an input String of a chess coordinate and returns array coordinates.
//    This exercise simply builds on the previous two:
//    a8 0,0
//    h1 7,7
//    g5 6,3
//    d4 3,4


import java.util.Arrays;

import static org.example.conversions.LetterPosition.getLetterPosition;
import static org.example.conversions.LetterConversion.convert;

public class CoordinatesConversion {
    static int[] result = new int[2];

    public static int[] my_coordinates(String place){
        char first_letter = place.charAt(0);
        int first_letter_position = getLetterPosition(first_letter) -1;
        result[0] = first_letter_position;

        int second_letter = Integer.parseInt(String.valueOf(place.charAt(1)));
        int second_letter_position = convert(second_letter);
        result[1]=second_letter_position;;
        return result;
    }


    public static void main(String[] args) {
        int[] coordinates = my_coordinates("d4");
        System.out.println(Arrays.toString(coordinates));
    }
}
