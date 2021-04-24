package domain;

public class Quiz {
	
	// TODO Vervang door een een gepaste collectie en initialiseer ze
	private Object opdrachten;
		
	public Quiz(){		
		// TODO
	}
	
	// hoeveel opdracht objecten zitten er in de opdrachtenCollectie
	public int getAantalOpdrachten(){
		// TODO
		return 0;
	}
		
	public boolean isLeeg(){
		// TODO
		return true;
	}
		
		
	//voegt een nieuwe opdracht toe achteraan de opdrachtenCollectie
	// let op opdracht mag niet al voorkomen volgens equals
	
	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		// TODO
		return true;
	}
	
		
	// TODO verwijder de eventuele opdracht op met opdrachtId in de opdrachtenCollectie
	//geeft de verwijderde opdracht terug TIP: gebruik iterator
	public Opdracht verwijderOpdracht(int opdrachtId) {
		return null;
	}

	//TODO geeft willekeurige opdracht terug	
	public Opdracht getRandomOpdracht(){
 		return null;
	}
		
	// TODO elke opdracht uit de opdrachtenCollectie(volgens toString van Opdracht klasse), elke
	//opdracht op een nieuwe lijn
	public String toString(){
		return null;
	}
}
