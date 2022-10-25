import java.util.Scanner;
public class DentalRecords {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
        System.out.println("Please enter number of people in the family: ");

        int numFamilyPeople = keyboard.nextInt();

        while (numFamilyPeople <= 0){

            System.out.println("Invalid number of people, try again: ");
            numFamilyPeople = keyboard.nextInt();
            while (numFamilyPeople > 6){
                System.out.println("Invalid number of people, try again: ");
                numFamilyPeople = keyboard.nextInt();
            }//end of nested while loop
        }//end of while loop

        String peopleNames[] = new String[numFamilyPeople];

        String uppers = "";
        String lowers = "";
        String[][][] toothInfo = new String[6][2][8];

        for (int index = 0; index < numFamilyPeople; index++) {
            System.out.println("Please enter the name for family member " + (index + 1) + ": ");
            peopleNames[index] = keyboard.next();

            System.out.println("Please enter the uppers for " + peopleNames[index] + ": ");

            uppers = keyboard.next();
            boolean correct = false;
            while (!correct){
                while (uppers.length() > 8){
                    System.out.println("Too many teeth, try again: ");
                    uppers = keyboard.next();
                }
                int z = 0;
                for (int i=0; i < uppers.length(); i++) {
                    if (uppers.toUpperCase().charAt(i) == 'I' || uppers.toUpperCase().charAt(i) == 'B' || uppers.toUpperCase().charAt(i) == 'M'){
                        z++;
                    }
                }
                if (z == uppers.length()){
                    correct = true;
                }
                else {
                    System.out.println("Invalid teeth types, try again: ");
                    uppers = keyboard.next();
                }
            }

            System.out.println("Please enter the lowers for " + peopleNames[index] + ": ");

            lowers = keyboard.next();
            boolean correct2 = false;
            while (!correct2){
                while (lowers.length() > 8){
                    System.out.println("Too many teeth, try again: ");
                    lowers = keyboard.next();
                }
                int z = 0;
                for (int i=0; i < lowers.length(); i++) {
                    if (lowers.toUpperCase().charAt(i) == 'I' || lowers.toUpperCase().charAt(i) == 'B' || lowers.toUpperCase().charAt(i) == 'M'){
                        z++;
                    }
                }
                if (z == lowers.length()){
                    correct2 = true;
                }
                else {
                    System.out.println("Invalid teeth types, try again: ");
                    lowers = keyboard.next();
                }
            }

            for (int k=0; k<uppers.length(); k++){
                toothInfo[index][0][k] = String.valueOf(uppers.charAt(k));
            }
            for (int k=0; k<lowers.length(); k++) {
                toothInfo[index][1][k] = String.valueOf(lowers.charAt(k));
            }
        }//end of for loop

        boolean exit = false;
        while (!exit){
            System.out.println("(P)rint, (E)xtract, (R)oot, e(X)it: ");
            char answer = keyboard.next().charAt(0);
            if (Character.toUpperCase(answer) == 'P'){
                for (int n=0; n<numFamilyPeople; n++){
                    System.out.println("");
                    System.out.println(peopleNames[n]);
                    System.out.print("Uppers: ");

                    int p=0;
                    while (p<8 && toothInfo[n][0][p] != null) {
                        System.out.print((p + 1) + ":" + toothInfo[n][0][p].toUpperCase());
                        System.out.print(" ");
                        p++;
                    }

                    System.out.println("");
                    System.out.print("Lowers: ");
                    int t=0;
                    while (t<8 && toothInfo[n][1][t] != null){
                        System.out.print((t + 1) + ":" + toothInfo[n][1][t].toUpperCase());
                        System.out.print(" ");
                        t++;
                    }
                }
                System.out.println("");
            }
            else if (Character.toUpperCase(answer) == 'E') {
                System.out.println("Which family member: ");
                boolean go = false;
                String name = "";
                int in = -1;

                while (!go) {
                    name = keyboard.next();
                    int b = 0;

                    for (int i = 0; i < numFamilyPeople; i++) {
                        if (peopleNames[i].toUpperCase().compareTo(name.toUpperCase())!=0) {
                            b++;
                        }
                        else {
                            in = i;
                        }
                    }
                    if (b == numFamilyPeople) {
                        System.out.println("Invalid family member, try again: ");
                    }
                    else {
                        go = true;
                    }
                }

                System.out.println("Which tooth layer (U)pper or (L)ower: ");
                boolean go2 = false;
                int layerInt = -1;
                while (!go2) {
                    String layer = keyboard.next();
                    if (layer.toUpperCase().compareTo("U") != 0 && layer.toUpperCase().compareTo("L") != 0){
                        System.out.println("Invalid layer, try again");
                    }
                    else {
                        if (layer.toUpperCase().compareTo("U") == 0){
                            layerInt = 0;
                        }
                        else{
                            layerInt = 1;
                        }
                        go2 = true;
                    }
                }

                System.out.println("Which tooth number: ");
                boolean go3 = false;
                int num = -1;
                while (!go3) {
                    num = keyboard.nextInt();
                    if (num > toothInfo[in][layerInt].length){
                        System.out.println("Invalid tooth number, try again");
                    }
                    else if (toothInfo[in][layerInt][num - 1].toUpperCase().compareTo("M") == 0) {
                        System.out.println("Missing tooth, try again");
                    } else {
                        toothInfo[in][layerInt][num - 1] = "M";
                        go3 = true;
                    }
                }
            }

            else if (Character.toUpperCase(answer) == 'R') {
                int i = 0;
                int m = 0;
                int b = 0;
                for (int s=0; s<numFamilyPeople; s++){
                    for (int g=0; g<2; g++){
                        int h = 0;
                        while (h<8 && toothInfo[s][g][h] != null){
                            if (toothInfo[s][g][h].toUpperCase().compareTo("I") == 0){
                                i++;
                            }
                            else if (toothInfo[s][g][h].toUpperCase().compareTo("M") == 0) {
                                m++;
                            }
                            else if (toothInfo[s][g][h].toUpperCase().compareTo("B") == 0) {
                                b++;
                            }
                            h++;
                        }
                    }
                }
                double result = rootPlus(i, b, (-1) * m);
                double result2 = rootMinus(i, b, (-1) * m);
                System.out.printf("One root canal at %.2f\n", result);
                System.out.printf("Another root canal at %.2f\n", result2);
            }
            else if (Character.toUpperCase(answer) == 'X') {
                exit = true;
                System.out.println("Exiting the Floridian Tooth Records :-)");
            }
            else {
                System.out.println("Invalid menu option, try again");
            }
        }
    }//end of the main method

    public static double rootPlus(int iTeeth, int bTeeth, int mTeeth) {
        return(((-1) * bTeeth + Math.sqrt((bTeeth * bTeeth) - 4 * iTeeth * mTeeth)) / (2 * iTeeth));
    }//end of positive root method
    public static double rootMinus(int iTeeth, int bTeeth, int mTeeth) {
        return (((-1) * bTeeth - Math.sqrt((bTeeth * bTeeth) - 4 * iTeeth * mTeeth)) / (2 * iTeeth));
    }//end of negative root method

}//end of the DentalRecords class