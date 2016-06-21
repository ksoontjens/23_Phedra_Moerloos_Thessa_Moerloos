public class Factuur implements Betaalbaar{

	public float factuurBedrag = 0;
	public int factuurNr = 0;
	

	public Factuur(int factuurNr, float factuurBedrag) {

		this.factuurNr = factuurNr;
		this.factuurBedrag = factuurBedrag;	

	}


	public void Betaal() {

		System.out.println( "Betaal de factuur van " + factuurBedrag );	

	}


}