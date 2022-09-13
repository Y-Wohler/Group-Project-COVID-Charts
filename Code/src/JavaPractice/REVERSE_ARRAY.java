package JavaPractice;

public final class REVERSE_ARRAY {
    public static void main(String[] args) {
        String[] myArray = new String[]{"a", "b", "c", "d", "e"};
        // Create array.

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        System.out.println();
        // Print that array.


        for (int i = 0; i < myArray.length/2; i++){                 // We only want to go through half of the array. Otherwise, we'd reverse everything we just changed.        //
            String temp = myArray[i];                               // Set the temporary [VARIABLE] to the values held in the current position.                                 //
            myArray[i] = myArray[myArray.length - i - 1];           // Then, we set the current position's value to the value held at the opposite side of the array.           //
            myArray[myArray.length - i - 1] = temp;                 // After that, we set the value held at the opposite side of the array, as the we value stored in temp.     //
        }
        // Say we had an array with a length of 7.
        // int 7/2 = 3, so the for loop would go around 3 times. Remember, this gets rounded down in java.

        // [a][b][c][d][e][f][g] | Initial State.
        // [g][b][c][d][e][f][a] | 1st loop: 'i' is equal to 0, so 'thisArray.length - i - 1' = 6.   So, the values in [0] and [6] are exchanged.
        // [g][f][c][d][e][b][a] | 2nd loop: 'i' is equal to 1, so 'thisArray.length - i - 1' = 5.   So, the values in [1] and [5] are exchanged.
        // [g][f][e][d][c][b][a] | 3rd loop: 'i' is equal to 2, so 'thisArray.length - i - 1' = 4.   So, the values in [2] and [4] are exchanged.
        // Now that the loop is over, we can see that all of our positions have been changed except for the one in the middle, which doesn't need to be changed!
        // This also works for arrays with an even length of values, and arrays who's values haven't been set (the values will just be null).
        // Ta-da!


        // Reverse that array.

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        // Print that array.
    }
}

