import java.util.Scanner;

public class SolutionB {
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        //INPUT THE SIZE OF THE ARRAY AND THE KEY TO BE SEARCHED
        int size  = input.nextInt();
        int key = input.nextInt();

        //ARRAY IS INITIATED WITH [size + 1] TO HAVE ONE-INDEXED ARRAY
        int [] arrayOfUserIDs = new int[size+1];

        //INPUT THE ARRAY ELEMENTS
        for(int i = 1; i < size+1; i++){
            arrayOfUserIDs[i] = input.nextInt();
        }

        //CALLING THE searchID FUNCTION
        int numM = searchID(arrayOfUserIDs,key);
        if(numM == -1){
            System.out.println("NOT_FOUND");
        } else{
            System.out.println(numM);
        }
    }

    //BINARY SEARCH METHOD
    public static int binarySearch(int [] arrayOfUserIDs, int start, int end, int key){

        try{
            while(start <= end){
                int mid = start + ((end - start)/2);
                if(key == arrayOfUserIDs[mid]){
                    return mid;
                }
                if(key < arrayOfUserIDs[mid]){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            return -1;
        }

       return -1;
    }


    /*IN THIS FUNCTION, SINCE WE DON'T KNOW THE LENGTH OF THE ARRAY, WE USE 2 INTEGERS TO LOOP THROUGH THE ARRAY.
    * THE FIRST INTEGER "i" WILL BE POINTING TOWARDS THE FIRST POSITION OF THE ARRAY AND THE SECOND INTEGER "j"
    * WILL BE POINTING TOWARDS THE SECOND POSITION OF THE ARRAY INITIALLY. tHE SECOND INTEGER WILL BE INCREMENTED
    * BY 2 SO THAT WE CAN CHECK EVERY POSITION TO FIND OUR KEY ELEMENT. WE WILL INITIALISE ANOTHER VARIABLE "num"
    * WHICH WE USE TO CONTROL OUR WHILE LOOP. THE "num" VARIABLE WILL BE ASSIGNED THE VALUE AT POSITION "j"*/



    public static int searchID(int [] arrayOfUserIDs, int key){
        int i = 1;
        int j = 2;
        int num = arrayOfUserIDs[1];


        /*ARRAY INDEX OUT OF BOUNDS EXCEPTION WILL HAPPEN WHEN WE TRY TO SEARCH FOR AN ELEMENT
        * WHICH IS NOT PRESENT IN THE ARRAY. TO TACKLE THIS I USED TRY AND CATCH METHOD. THE CATCH
        * WILL RETURN -1 WHICH MEANS THE ELEMENT IS NOT PRESENT IN THE ARRAY*/

        try{
            while(num < key){
                i = j;
                j++;
                num = arrayOfUserIDs[j];
            }
        } catch(ArrayIndexOutOfBoundsException e){
            return -1;
        }

        return binarySearch(arrayOfUserIDs,i,j,key);
    }

    /*EXPLANATION OF searchID METHOD
    --------------------------------
    SIZE OF THE ARRAY = 5
    KEY TO BE FOUND  = 4
    ELEMENTS OF THE ARRAY = {1,2,4,6,8}
    THE "num" VALUE WILL BE 1 INITIALLY. SINCE THIS IS LESS THAN OUR "key" VALUE OF 4,
    THE PROGRAM WILL ENTER THE WHILE LOOP.

    NOW "i" WILL BE SET TO 2 AND "j" WILL BE SET TO 3. "num" WILL BECOME 4.
    SINCE "num" IS NOW EQUAL OUR "key" VALUE THE PROGRAM WILL EXECUTE THE WHILE LOOP ONCE AGAIN.

    "i" WILL BE SET TO 3 AND "j" WILL BE SET TO 4. "num" IS 6 NOW AND SINCE THE CONDITION IS FALSE AND
    PROGRAM WILL EXIT THE WHILE LOOP.

    NOW, THE BINARY SEARCH FUNCTION WILL USE THE FOLLOWING INPUTS:
    a. THE ARRAY = {1,2,4,6,8}
    b. START POSITION = 3
    c. END POSITION = 4
    d. KEY = 4

    MID = 3 + ((4-3)/2) = 3
    THE ELEMENT AT POSITION 3 IS 4 WHICH IS EQUAL TO OUR "key".
    * */
}
