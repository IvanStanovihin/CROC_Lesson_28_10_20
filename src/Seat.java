public class Seat {

    private final int row;

    private final int seat;

    /**
     * Set the numbers seat and row
     * @param row number row
     * @param seat number seat
     */
    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }

    public int getRow(){
        return row;
    }

    public int getSeat(){
        return seat;
    }

}
