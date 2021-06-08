package g8row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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
            fileWriter.write(sc.nextLine() + "/" + i + "/" + (double)(int)(Math.random()*10+10) + "/" +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mi augue. Praesent sed molestie.\n");// what better filler text than lorem ipsum
            //a comment about the double parse situation: naturally the area should be a double, 
            //but in order for the effect of sortBy() with more arguments example
            //to be more clearly understandable, i wanted to round it easily
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
        Collections.shuffle(list);//to make the sort results more interesting
    }
    /*
     * Sorts the list by a selected method, multiple methods for multiple attri
     */
    public static void sortBy(SortBy sortBy, List<ParkingSpot> list){
        switch (sortBy){
            case AREA -> list.sort(ParkingSpot.byArea);//mergesort seems adequate to me, why write something that's already written?
            case USER -> list.sort(ParkingSpot.byUser);
            case NUMBER -> list.sort(ParkingSpot.byNumber);
        }
    }
    public static void sortBy(SortBy sortBy,SortBy sortBy1, List<ParkingSpot> list){
    	Comparator<ParkingSpot> comp1 = null,comp2=null;
        switch (sortBy){
            case AREA -> comp1 = ParkingSpot.byArea;
            case USER -> comp1 = ParkingSpot.byUser;
            case NUMBER -> comp1 = ParkingSpot.byNumber;
        }
        switch (sortBy1){
        	case AREA -> comp2 = ParkingSpot.byArea;
        	case USER -> comp2 = ParkingSpot.byUser;
        	case NUMBER -> comp2 = ParkingSpot.byNumber;
        }
        list.sort(comp1.thenComparing(comp2));
    }
    public static void sortBy(SortBy sortBy,SortBy sortBy1,SortBy sortBy2, List<ParkingSpot> list){
    	Comparator<ParkingSpot> comp1=null,comp2=null,comp3=null;
        switch (sortBy){
            case AREA -> comp1 = ParkingSpot.byArea;
            case USER -> comp1 = ParkingSpot.byUser;
            case NUMBER -> comp1 = ParkingSpot.byNumber;
        }
        switch (sortBy1){
        	case AREA -> comp2 = ParkingSpot.byArea;
        	case USER -> comp2 = ParkingSpot.byUser;
        	case NUMBER -> comp2 = ParkingSpot.byNumber;
        }
        switch (sortBy2){
    		case AREA -> comp3 = ParkingSpot.byArea;
    		case USER -> comp3 = ParkingSpot.byUser;
    		case NUMBER -> comp3 = ParkingSpot.byNumber;
    }
        list.sort(comp1.thenComparing(comp2).thenComparing(comp3));
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
    public static void showResults(String location,SortBy sortBy,SortBy sortBy1,List<ParkingSpot> list) throws IOException {//show the results in a txt file
        FileWriter fileWriter = new FileWriter(new File(location));
        sortBy(sortBy,sortBy1,list);
        for (ParkingSpot parkingSpot : list) {
            fileWriter.write(parkingSpot + "\n");
            fileWriter.flush();
        }
    }
    public static void showResults(String location,SortBy sortBy,SortBy sortBy1,SortBy sortBy2,List<ParkingSpot> list) throws IOException {//show the results in a txt file
        FileWriter fileWriter = new FileWriter(new File(location));
        sortBy(sortBy,sortBy1,sortBy2,list);
        for (ParkingSpot parkingSpot : list) {
            fileWriter.write(parkingSpot + "\n");
            fileWriter.flush();
        }
    }
}
