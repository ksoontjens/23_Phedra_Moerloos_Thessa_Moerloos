public class Werknemer implements Betaalbaar{

	//variabelen
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float rszPercentage = 33.0f;
	public int factuurbedrag = 100;


	public Werknemer ( String voornaam, String achternaam, int wNummer, float salaris ) {
		
	this.voornaam = voornaam;
	this.achternaam = achternaam;
	wNummer = werknemerNummer;
	this.salaris = salaris;

	}
	



	//methode
	public void SalarisVerhogen( int percentage ) {
		
		salaris = salaris * (1 + ( percentage/100.0f ));

	}



	public float GetSalaris() {
		
		return salaris;

	}


	public float GetRsz() {

		return rszPercentage;	

	}


	public void SetRsz( float rsz ) {

		rszPercentage = rsz;	

	}



	public void Betaal() {

		System.out.println( "Betaal het salaris van " + salaris + " van werknemer: " + voornaam + " " + achternaam);	

	}	





}