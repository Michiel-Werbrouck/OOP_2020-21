package ui;

import javax.swing.*;

import db.OpdrachtDatabank;
import domain.*;

import java.util.Scanner;

public class OpdrachtUI {

	public static void main(String[] args) {
		JFrame f = new JFrame();

		// We maken 1 opdracht
		int id = 1;
		String auteur = "Leentje";
		String categorie = Opdracht.CATEGORIE_AARDRIJKSKUNDE;
		String vraag = "Wat is de hoofdstad van Belgie?";
		String antwoordhint = "Je vindt er het atomium";
		String antwoord = "Brussel";
		boolean isHoofdlettergevoelig = true;
		Opdracht opdracht1 = new Opdracht(id, vraag, antwoord,
				isHoofdlettergevoelig, antwoordhint, categorie, auteur);
		System.out.println(opdracht1);

		// bestand te lezenen en hier een Quiz van te maken
		OpdrachtDatabank db = new OpdrachtDatabank("Opdrachten-1.txt");
		Quiz quiz = new Quiz();

		for (Opdracht opdracht : db.getOpdrachten())
			quiz.voegOpdrachtToe(opdracht);

		System.out.println(quiz);

		// Kies een willekeurige opdracht en toon de vraag aan de gebruiker in de console,
		Opdracht opdracht = quiz.getRandomOpdracht();
		System.out.println(opdracht.getVraag());

		// waarbij hij een antwoord kan geven in de console dat gecontroleerd wordt met het juiste antwoord.
		Scanner in = new Scanner(System.in);
		String inAntwoord = in.nextLine();

		// bij foutieve antwoord van de gebruiker kan de hint gegeven worden
		if (opdracht.getAntwoord().equals(inAntwoord)) {
			JOptionPane.showMessageDialog(f,"Juist");
		} else {
			JOptionPane.showMessageDialog(f,"Fout, hint: " + opdracht.getAntwoordHint());
		}
	}

}
