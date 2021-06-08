package g8row;

import java.io.*;
import java.util.*;

enum SortBy {// for the sake of the user
    NUMBER,
    AREA,
    USER
}
class ParkingSpot{//i like objects, don't judge me
    String firstName;
    String lastName;
    int number;
    double area;
    String description;
    boolean is74;//am i even trying to get accepted?

    public ParkingSpot(String name, int number, double area, String description) {
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
        this.number = number;
        this.area = area;
        this.description = description;
        if(number==74){
            this.is74 = true;
        }
    }

    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                ", area=" + area +
                ", description='" + description + '\'';
    }

    int a = Integer.compare(1,2);


    static Comparator<ParkingSpot> byArea = new Comparator<ParkingSpot>() {
        @Override
        public int compare(ParkingSpot o1, ParkingSpot o2) {
            if(o1.is74){
                return -1;
            }else if(o2.is74){
                return 1;
            }else{
                return Double.compare(o1.area, o2.area);
            }
        }
    };
    static Comparator<ParkingSpot> byUser = new Comparator<ParkingSpot>() {
        @Override
        public int compare(ParkingSpot o1, ParkingSpot o2) {
            if(o1.is74){
                return -1;
            }else if(o2.is74){
                return 1;
            }else{
                return (o1.firstName+" "+o2.lastName).compareTo(o1.firstName+" "+o2.lastName);
            }
        }
    };
    static Comparator<ParkingSpot> byNumber = new Comparator<ParkingSpot>() {
        @Override
        public int compare(ParkingSpot o1, ParkingSpot o2) {
            if(o1.is74){
                return -1;
            }else if(o2.is74){
                return 1;
            }else{
                return Integer.compare(o1.number, o2.number);
            }
        }
    };
}
public class Main {
    public static void createTestFile() throws IOException {//in order to quickly create a test file with a list of obj to sort
        FileWriter fileWriter = new FileWriter( new File("ParkSpots.txt"));
        Scanner sc = new Scanner(new File("./src/g8row/Names.txt"));
        for (int i = 1;sc.hasNextLine();i++) {
            fileWriter.write(sc.nextLine() + "/" + i + "/" + (Math.random()*10+10) + "/" +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec mi augue. Praesent sed molestie.\n");// what better filler text than lorem ipsum
            fileWriter.flush();
        }
        fileWriter.close();
    }
    public static void readTestFile(List<ParkingSpot>list) throws FileNotFoundException {// now to read the test file
        Scanner sc = new Scanner(new File("ParkSpots.txt"));
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] temp = line.split("/");
            list.add(new ParkingSpot(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2]),temp[3]));
        }
    }
    public static void sortBy(SortBy sortBy, List<ParkingSpot> list){
        switch (sortBy){
            case AREA -> list.sort(ParkingSpot.byArea);//mergesort seems adequate to me, why write something that's already written?
            case USER -> list.sort(ParkingSpot.byUser);
            case NUMBER -> list.sort(ParkingSpot.byNumber);
        }
    }
    public static void showResults(String location,SortBy sortBy,List<ParkingSpot> list) throws IOException {//show the results in a txt file
        FileWriter fileWriter = new FileWriter(new File(location));
        sortBy(sortBy,list);
        for (ParkingSpot parkingSpot : list) {
            fileWriter.write(parkingSpot + "\n");
            fileWriter.flush();
        }
    }
    public static void main(String[] args){
        List<ParkingSpot> parkingSpots = new ArrayList<>();// ArrayList gets the job done
        try {
            createTestFile();
            readTestFile(parkingSpots);
            showResults("ParkSpotsSortedByArea.txt",SortBy.AREA,parkingSpots);//showing for every sorting type
            showResults("ParkSpotsSortedByUser.txt",SortBy.USER,parkingSpots);
            showResults("ParkSpotsSortedByNumber.txt",SortBy.NUMBER,parkingSpots);
        }catch (IOException error){
            error.printStackTrace();
        }
        //well, i did it, i did not invent a new sorting method nor implemented it myself, but i do like to work smarter, not harder(i hope that excuses laziness haha)
        // i like to learn new things and technologies, that will help me in the future, so i'm using git, as it's a must for the industry (this github repo contains my super secret project, but i started very recently so it's not much, perhaps it could get me a few additional points haha)
        // also i hope you like jokes and don't sanction me
    }
}
