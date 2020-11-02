public class Main {

    public static void main(String[] args) {
        CinemaHall hall1 = new CinemaHall("Hall A", 3, 3);
        Showtime showtime1 = new Showtime("Ice", hall1);

        Thread thread1 = new Thread(new BookTicket(showtime1));
        thread1.setName("first thread");
        thread1.start();
        Thread thread2 = new Thread(new BookTicket(showtime1));
        thread2.setName("second name");
        thread2.start();
    }
}

   class BookTicket implements Runnable{

   public static Showtime showtime;

    public BookTicket(Showtime showtime){
        this.showtime = showtime;
    }

       public void run(){
        //блокировка на изменение информации о сеансе сразу несколькими потоками(только 1 поток может одномоментно изменять
           //кол- во свободных мест на сеанс)
        synchronized(showtime) {
            for (int i = 1; i < showtime.getNumberRowPerShowtime(); i++) {
                for (int j = 1; j < showtime.getNumberSeatsInRowPerShowtime(); j++) {
                    bookTicket(i, j);
                }
            }
        }
        }

      public void bookTicket(int numberRow, int numberSeat){
           if(showtime.bookSeat(new Seat(numberRow, numberSeat))){
               System.out.println("Вы успешно забронировали билет! Ряд - " + numberRow + " место - " + numberSeat);
           }else{
               System.out.println("Невозможно забронировать билет! Место - " + numberSeat + " ряд - " + numberRow + " уже занято!" );
           }
       }

    }

