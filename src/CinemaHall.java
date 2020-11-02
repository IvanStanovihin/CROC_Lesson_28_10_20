import java.util.LinkedHashSet;


public class CinemaHall {

    private final String nameHall;
    private final int numberRow;
    private final int numberSeatsInRow;
    private LinkedHashSet<Seat> setSeatInHall = new LinkedHashSet<Seat>();

    /**
     * Sets the parameters of the hall and calls the method for generating seats
     * @param nameHall Cinema hall name
     * @param numberRow Number of rows in the hall
     * @param numberSeatsInRow Number of seats in one row. All rows have the same number of seats.
     */
    public CinemaHall(String nameHall, int numberRow, int numberSeatsInRow){
        this.nameHall = nameHall;
        this.numberRow = numberRow;
        this.numberSeatsInRow = numberSeatsInRow;
        generateSetSeatInHall();
    }

    public LinkedHashSet<Seat> getSetSeatInHall(){
        return setSeatInHall;
    }

    public int getNumberRow(){
        return numberRow;
    }

    public int getNumberSeatsInRow(){
        return numberSeatsInRow;
    }

    /**
     * Generates many seats that are in the hall
     */
    private void generateSetSeatInHall(){
        for (int  i = 1; i <= numberRow ; i ++){
            for (int j = 1; j <= numberSeatsInRow; j++ ){
                setSeatInHall.add(new Seat(i, j));
            }
        }
    }


}
