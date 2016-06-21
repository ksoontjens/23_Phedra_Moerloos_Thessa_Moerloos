public class ParttimeWerknemer extends Werknemer{

	int urenGewerkt;
	
	public ParttimeWerknemer( String voornaam, String achternaam, int wNummer, float salaris, int urenGewerkt ) {

		super( voornaam, achternaam, wNummer, salaris );
		this.urenGewerkt = urenGewerkt;	

	}


	public void SalarisVerhogen ( int percentage ) {
		
		//als meer dan 5% willen verhogen foutmelding en niks doen
		if( percentage > 5 ) {

			System.err.println( "Fout: ParttimeWerknemers kunnen slechts 5% opslag krijgen." );

		}


		//anders gewoon de originele methode SalarisVerhogen gebruiken van de klasse Werknemer ( de superklasse )
		else {

			super.SalarisVerhogen( percentage );

		}	


	}


}