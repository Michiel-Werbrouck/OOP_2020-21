package ui.view;

import domain.DomainException;
import domain.Familie;
import domain.Persoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainFamilie {
    public static void main(String[] args) {
        Persoon anne, bert, chris;
		Familie familie;

		try {
			anne = new Persoon("anne", 10);
			bert = new Persoon("bert", 12);
			chris = new Persoon("chris", 13);

			familie = new Familie("Rodenburg");

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Geef voornaam voor familielid");
			String naam = reader.readLine();
			System.out.println("Geef leeftijd van familielid");
			String leeftijd = reader.readLine();
			familie.voegFamilielidToe(naam, leeftijd);

			familie.voegFamilielidToe(anne);
			familie.voegFamilielidToe(bert);
			familie.voegFamilielidToe(chris);

			System.out.println(familie);
		} catch (IOException | DomainException e) {
			System.out.println(e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("Omwille van kenmerken van familie kan persoon niet toegevoegd worden.");
		}
    }
}
