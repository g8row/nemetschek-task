package g8row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Utilities {
    /*
     * Seeds a file with test entities to sort
     */
    public static void createTestFile() throws IOException {
        FileWriter fileWriter = new FileWriter( new File("ParkSpots.txt"));
        Scanner sc = new Scanner(new File("./src/g8row/Names.txt"));
        for (int i = 1;sc.hasNextLine();i++) {
            fileWriter.write(sc.nextLine() + "/" + i + "/" + (Math.random()*10+10) + "/" +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mi augue. Praesent sed molestie.\n");// what better filler text than lorem ipsum
            fileWriter.flush();
        }
        fileWriter.close();
    }
    /*
     * Reads the test file into a list
     */
    public static void readTestFile(List<ParkingSpot> list) throws FileNotFoundException {// now to read the test file
        Scanner sc = new Scanner(new File("ParkSpots.txt"));
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] temp = line.split("/");
            list.add(new ParkingSpot(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2]),temp[3]));
        }
    }
    /*
     * Sorts the list by a selected method
     */
    public static void sortBy(SortBy sortBy, List<ParkingSpot> list){
        switch (sortBy){
            case AREA -> list.sort(ParkingSpot.byArea);//mergesort seems adequate to me, why write something that's already written?
            case USER -> list.sort(ParkingSpot.byUser);
            case NUMBER -> list.sort(ParkingSpot.byNumber);
        }
    }
    /*
     * Writes to a file, as to show the sorted array
     */
    public static void showResults(String location,SortBy sortBy,List<ParkingSpot> list) throws IOException {//show the results in a txt file
        FileWriter fileWriter = new FileWriter(new File(location));
        sortBy(sortBy,list);
        for (ParkingSpot parkingSpot : list) {
            fileWriter.write(parkingSpot + "\n");
            fileWriter.flush();
        }
    }
}
