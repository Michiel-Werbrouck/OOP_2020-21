package domain;

import java.util.ArrayList;
import java.util.Random;

public class Quiz {

	private final ArrayList<Opdracht> opdrachten;
		
	public Quiz(){		
		this.opdrachten = new ArrayList<>();
	}

	public int getAantalOpdrachten(){
		return opdrachten.size();
	}
		
	public boolean isLeeg(){
		return opdrachten.isEmpty();
	}

	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		if (opdrachtNieuw == null || opdrachten.contains(opdrachtNieuw))
			return false;

		opdrachten.add(opdrachtNieuw);
		return true;
	}

	public Opdracht verwijderOpdracht(int opdrachtId) {
		Opdracht opdracht = opdrachten.get(opdrachtId);
		opdrachten.remove(opdracht);
		return opdracht;
	}

	public Opdracht getRandomOpdracht(){
		return opdrachten.get(new Random().nextInt(opdrachten.size() - 1));
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder("Opdrachten\n");

		for (Opdracht opdracht : opdrachten)
			stringBuilder.append(opdracht.toString()).append("\n");

		return stringBuilder.toString();
	}
}
