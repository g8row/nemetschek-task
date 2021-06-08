package g8row;

import java.util.Comparator;

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
                return (o1.firstName+" "+o1.lastName).compareTo(o2.firstName+" "+o2.lastName);
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

