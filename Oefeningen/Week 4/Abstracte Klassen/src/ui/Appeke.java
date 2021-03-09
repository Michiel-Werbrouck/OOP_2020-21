package ui;

import domain.Festival;
import domain.Loonwerknemer;

import java.time.LocalDate;

public class Appeke {

    public static void main(String[] args) {
        Festival festival = new Festival("Emmerkesfuif", LocalDate.now(), LocalDate.now().plusDays(10));
        Loonwerknemer loonwerknemer = new Loonwerknemer("Mikkel", "Werbrouck", "11.11.11-111.11");
        festival.addWerknemer(loonwerknemer);
        System.out.println(festival.getWerknemers());
    }

}
