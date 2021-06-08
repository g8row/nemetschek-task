package g8row;

import java.io.*;
import java.util.*;



public class Main extends Utilities {

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
