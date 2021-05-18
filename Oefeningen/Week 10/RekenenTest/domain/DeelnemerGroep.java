package domain;

import java.util.*;

public class DeelnemerGroep {

	private Queue<String> groep ;
	private Map <String,ArrayList<Boolean>> scores;
	
	public DeelnemerGroep(List <String> deelnemers){
		groep = new LinkedList<>(deelnemers);
		scores = new TreeMap<>();

		for (int i = 0; i< deelnemers.size();i++){
			scores.put(deelnemers.get(i), new ArrayList<>());
		}
	}	
	
	/**
	 * Geeft een lijst terug van alle deelnemers die geregistreerd zijn.
	 * 
	 * @return een lijst met alle deelnemers
	 */
	public List<String> getDeelnemers() {
		return new ArrayList<>(groep);
	}
	
	public int getAantalDeelnemers(){
		return groep.size();
	}

	/**
	 * Geeft de deelnemer terug die nu aan beurt is. 
	 * 
	 * @return de deelnemer die nu aan beurt is
	 */
	public String getDeelnemerAanBeurt() {
		return groep.peek();
	}

	/**
	 * Geeft de deelnemer terug die nu aan beurt is en zet de beurt op voorbij. 
	 * Telkens men deze methode opgeroept, wordt de volgende deelnemer dus aan beurt gezet.
	 * De deelnemer wordt vooraan uit de queue gehaald en er achteraan terug bijgezet
	 * @return de deelnemer die nu aan beurt is
	 */
	public String getEnVerplaatsDeelnemerAanBeurt() {
		String s = this.groep.remove();
		this.groep.add(s);
		return s;
	}

	public void registreerScore(String deelnemer, boolean juistAntwoord){
		scores.get(deelnemer).add(juistAntwoord);
	}
	
	/**
	 * de lijst met juist/fout antwoorden van de deelnemer wordt overlopen
	 * voor elk juist antwoord verdient de deelnemer 1 punt
	 * @return score deelnemer
	 */	
	public int getScore(String deelnemer){
		int score = 0;

		for (boolean antwoord : scores.get(deelnemer)) {
			if (antwoord) score++;
		}

		return score;
	}

	/**
	 * Geeft de deelnemer terug met het meeste punten.
	 * 
	 * @return de deelnemer met het meeste punten
	 */

	public String getWinnaar(){
        int max = vindHoogstePunt();
        for(String deelnemer : groep) {
        	int score = getScore(deelnemer);
            if(score==max)
                return deelnemer;
        }
        return null;
    }
	
	/**
	 * Geeft de verzameling van deelnemers terug met het meeste punten.
	 * Deze verzameling van winnaars is alfabetisch geordend
	 * @return de deelnemers met het meeste punten
	 */
	public Set<String> getWinnaars() {
		Set<String> winnaars = new TreeSet<>(getDeelnemers());
		winnaars.removeIf(deelnemer -> getScore(deelnemer) != getScore(getWinnaar()));

		return winnaars;
	}

	// wat is de hoogste score van de ganse deelnemer groep
	public int vindHoogstePunt() {
		int max = 0;
		for(String deelnemer : groep) {
			int score = getScore(deelnemer);
			if(score > max)
				max = score;
		}
		return max;
	}
	
	//lijst in tekstformaat van de punten per student
	//dez lijst is geordend van hoogste naar laagste score
	//bij gelijke punten zijn de deelnemers alfabetisch geordend
	
	public String getPuntenOverzicht(){
		// TO DO
		//tip1 gebruik een map met als key een mogelijke score(key geordend van hoge naar lage score)
		// en als value een verzameling van deelnemers die deze score hebben behaald
		//tip2 je zal een Comparator klsse moeten maken want scores zijn georden van hoog naar laag
		Map <Integer, Set<String>> scores = new TreeMap<>();

		//Collections.sort(, new Sortbyname());

		/*for (String deelnemer : getDeelnemers()) {

		}*/
				
		// hier wordt de juiste output aangemaakt uit de inhoud van de score map		
		StringBuilder output = new StringBuilder();
		Set <Map.Entry<Integer, Set<String>>> set = scores.entrySet();
		for (Map.Entry<Integer, Set<String>> entry:set){
			int score = entry.getKey();
			Set <String> deelnemers = entry.getValue();
			for (String deelnemer:deelnemers){
				output.append(String.format("%10s: %2d", deelnemer, score)).append("\n");
			}
		}
		return output.toString();
	}		

	public Map <String,ArrayList<Boolean>> getScoresDeelnemerGroep(){
		return scores;
	}
}
