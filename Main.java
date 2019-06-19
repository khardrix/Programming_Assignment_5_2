/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #5                                           *****
 *****                                               Program #2                                                  *****
 *****___________________________________________________________________________________________________________*****
 *****                        2. Implement a program which creates several int arrays and                        *****
 *****                       tests them using several recursive methods as described below.                      *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****     a. Recursive boolean method to check that the array passed in is increasingly additive.               *****
 *****                                                                                                           *****
 *****     b. Recursive boolean method that checks that every element of Array 1 is greater than                 *****
 *****        every element of Array 2 and return the result.                                                    *****
 *****                                                                                                           *****
 *****     c. Recursive boolean method that checks that every int element value in the passed in Array           *****
 *****        is in ascending order and that there is no duplicate values in the passed in Array and             *****
 *****        return the result. Also, add the values to an ArrayList.                                           *****
 *****                                                                                                           *****
 *****     d. Recursive int method that is passed in two int Arrays and checks for values that are contained     *****
 *****        in both Arrays. If an int value is found to be in both Arrays, increase the count of the           *****
 *****        counter of values the two Arrays have in common and return the number of values both Arrays        *****
 *****        contained. Also, add the particular int value that both Arrays have in common to an ArrayList.     *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;


public class Main {

    // CLASS VARIABLE(s) declaration(s)
    private static int[] array = {1, 2, 4, 8, 16, 32, 64, 128};
    private static int[] arrayB1 = {9, 10, 11, 12, 13, 14, 15, 16};
    private static int[] arrayB2 = {1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] arrayC = {17, 18, 19, 20, 21, 22, 23, 24};
    private static int[] arrayD = {1, 3, 6, 7};
    private static int[] arrayE = {1, 2, 4, 5, 6, 7};
    private static ArrayList<Integer> listPartC = new ArrayList<>();
    private static ArrayList<Integer> listPartD = new ArrayList<>();


    public static void main(String[] args) {

        // Test the recursive method: private static boolean partA(int[] arrayA, int n) and
            // print the results to the console
        System.out.println(partA(array, 8));

        // Test the recursive method: private static boolean partB(int[] array1, int[] array2, int n, int m) and
            // print the results to the console
        System.out.println(partB(arrayB1, arrayB2, 8, 8));

        // Test the recursive method: private static boolean partC(int[] arrayC, int s, int n) and
            // print the results to the console. Also, print the ArrayList created from the partC() method
        System.out.println(partC(arrayC, 0, 8));
        System.out.println(listPartC);

        // Test the recursive method: private static int partD(int[] arrayD, int[] arrayE, int n, int totalCount) and
            // print the results to the console. Also, print the ArrayList created from the partC() method
        System.out.println(partD(arrayD, arrayE, 4, 0));
        System.out.println(listPartD);
    }


    // Recursive method to see if the passed in array of length "n" is increasingly additive
    private static boolean partA(int[] arrayA, int n){

        // int variable to keep track of the sum of all the numbers before the number we are looking at
        int sum = 0;

        // for loop to add up all the numbers prior to the number we are looking at and
            // add them to the int variable "sum"
        for(int i = 0; i < n-1; i++){
            sum += arrayA[i];
        }

        // Print out the sum compared to the number we are looking at
        System.out.println(sum + " compared to " + arrayA[n-1]);

        // If we reach this, we have checked all the numbers in the array, return true
        if(n <= 2) return true;

        // If this passes, sum is greater than the number we are currently looking at, print to the console that the
            // passed in array is not increasingly additive and return false
        else if(sum >= arrayA[n-1]) {
            System.out.println("\nThe passed in Array is not increasingly additive");
            return false;
        }

        // recursively call this method to test the next number
        else return partA(arrayA, (n-1));
    }


    // Recursive method to check that every element of array1 is greater than every element of array2
    private static boolean partB(int[] array1, int[] array2, int n, int m){

        // We have reached the end of array1 and checked all elements to be true
        if(n <= 0) return true;

        // Search through all the values of both arrays to make sure every element of array1 is
            // greater than every element of array2
        for(int i = m-1; i >= 0; i--){
            if(array1[n-1] < array2[i]){
                // Print to the console which element violated the rule and return false
                System.out.println(array1[n-1] + ", which is at location " + (n-1) + " of array1, " +
                        "is less than the value of " + array2[i] + ", which is at location " + i +
                        " of array2");
                return false;
            }
        }

        // Take the last element away from array1 and try again
        return partB(array1, array2, (n-1), m);
    }


    // Recursive method to check that the passed in Array is in ascending order and doesn't contain any duplicates
    private static boolean partC(int[] arrayC, int s, int n){

        // We have reached the end of arrayC and checked all elements to be true
        if(n <= 0) return true;

        // for loop to go through the Array to make sure the current value is in ascending order
            // if not, print the reason why to the console and return false
        for(int i = (s+1); i < n; i++){
            if(arrayC[s] > arrayC[i]){
                System.out.println("The value " + arrayC[i] + ", at location " + i +
                        " in arrayC is greater than the value before it: " + arrayC[(i-1)] + ". So the Array " +
                        "is not in ascending order");
                return false;
            }
        }

        // for loop to go through the Array to make sure the current value does not have a duplicate value in the Array
            // if not, print the reason why to the console and return false
        for(int i = (s+1); i < n; i++){
            if(arrayC[s] == arrayC[i]){
                System.out.println("The value " + arrayC[s] + ", is equal to " + arrayC[i] +
                        ", at location " + i + " of ArrayC. So there is a duplicate value in the Array");
                return false;
            }
        }

        // The value at "s" is in ascending and doesn't have a duplicate, so add it to the ArrayList "listPartC"
        listPartC.add(arrayC[s]);

        // Recursively call this method increasing "s" (starting point) by 1 and decreasing "n" (Array length) by 1
        return partC(arrayC, (s+1), (n-1));
    }


    // Recursive method to return the number of int values the two passed in Arrays have in common and
        // add those values to the ArrayList "listPartD"
    private static int partD(int[] arrayD, int[] arrayE, int n, int totalCount){

        // We have gone through both Arrays and counted the number of values in common, return that int value
        if(n <= 0) return totalCount;

        // for loop to go through all of arrayE, to see if it contains the value contained in arrayD at location "n-1".
            // If a value is found in common, increase the int value "totalCount" by 1 and
            // add the value to the ArrayList "listPartD"
        for(int i = 0; i < arrayE.length; i++){
            if(arrayD[(n-1)] == arrayE[i]){
                listPartD.add(arrayE[i]);
                totalCount++;
            }
        }

        // Recursively call this method with both of the original passed in Arrays, "n-1" (starting at the current
            // second to last element of arrayD) and the int value totalCount (keeps track of the number of values
            // the two passed in Arrays have in common)
        return partD(arrayD, arrayE, (n-1), totalCount);
    }
}
