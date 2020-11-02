import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Showtime {

    final private String movieName;
    private LinkedHashSet<Seat> freeSeats;
    final private CinemaHall cinemaHall;

     public Showtime(String movieName, CinemaHall hall){
     this.movieName = movieName;
     this.cinemaHall = hall;
     this.freeSeats = hall.getSetSeatInHall();

     }

     public LinkedHashSet<Seat> getFreeSeats(){
         return freeSeats;
     }

     public int getNumberRowPerShowtime(){
         return cinemaHall.getNumberRow();
     }

     public int getNumberSeatsInRowPerShowtime(){
         return cinemaHall.getNumberSeatsInRow();
     }

     public String getMovieName(){
         return movieName;
     }

    /**
     * The method reserves(remove from set of freeSeats) a given seat.
     * @param seat Seat to be booked.
     * @return True - if seat successfully booked. False - if failed to book seat.
     */
     public boolean bookSeat(Seat seat){
         if (checkFreeSeat(seat)){
             deleteSeatFromFreeSeat(seat);
             return(true);
         }else{
             return(false);
         }
     }

    /**
     * The method checks if there is a place in the freeSeats set, or is already booked.
     * @param seat Place that is checked.
     * @return True - if seat is free. False - if seat is booked.
     */
     public boolean checkFreeSeat(Seat seat){
         boolean result = false;

         //сравниваем поочерёдно все места из множества свободных с местом которое передаётся в метод (сравнивается
         // номер ряда и номер места). Если находится свободное место с такими же параметрами как у поступившего в метод
         // объекта, то присваеваем результату который будет возвращён из метода значение true.
         for(Seat freeSeat: freeSeats){
             if (freeSeat.getRow() == seat.getRow() && freeSeat.getSeat() == seat.getSeat()){
                 result = true;
                 break;
             }
         }
         return result;
     }

    /**
     * The method iterates over the set of FreeSeats and removes the given place.
     * @param seat Seat to be remove from the set of freeSeats.
     */
    private void deleteSeatFromFreeSeat(Seat seat){
         Iterator<Seat> iterator = freeSeats.iterator();
         while(iterator.hasNext()){
             Seat freeSeat = iterator.next();
             if (freeSeat.getRow() == seat.getRow() && freeSeat.getSeat() == seat.getSeat()){
                 iterator.remove();
         }
         }
     }

}
