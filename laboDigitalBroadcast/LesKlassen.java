public class LesKlassen {

	public static void main ( String arg[] ) {

		Werknemer jan = new Werknemer( "Jan", "Janssens", 1, 20.0f );
		Werknemer herman = new Werknemer( "Herman", "Hermans", 2, 30.0f );
		Werknemer sarah = new Werknemer( "Sarah", "Jehin", 3, 50.0f );
		Werknemer thessa = new Werknemer( "Thessa", "Moerloos", 4, 10.0f );

		jan.SalarisVerhogen(10);
		herman.SalarisVerhogen(10);

		System.out.println( jan.voornaam + " verdient " + jan.GetSalaris() );
		System.out.println( herman.voornaam + " verdient " + herman.GetSalaris() );
		System.out.println( sarah.voornaam + " verdient " + sarah.GetSalaris() );
		System.out.println( thessa.voornaam + " verdient " + thessa.GetSalaris() );



		ParttimeWerknemer luna = new ParttimeWerknemer( "Luna", "Moerloos", 1, 55.0f, 3 );
		ParttimeWerknemer kaat = new ParttimeWerknemer( "Kaat", "Waterschoot", 2, 30.0f, 5 );

		luna.SalarisVerhogen(10);
		kaat.SalarisVerhogen(5);
	
		System.out.println( luna.voornaam + " verdient " + luna.GetSalaris() + " en heeft " + luna.urenGewerkt + " uren gewerkt." );
		System.out.println( kaat.voornaam + " verdient " + kaat.GetSalaris() + " en heeft " + kaat.urenGewerkt + " uren gewerkt." );

		System.out.println("Het RSZ percentage van jan is " + jan.GetRsz() );
		System.out.println("Het RSZ percentage van luna is " + luna.GetRsz() );

		kaat.SetRsz(40.0f);
		System.out.println("Het RSZ percentage van kaat is " + kaat.GetRsz() );


		StudentWerknemer peter = new StudentWerknemer( "Peter", "Peters", 1, 55.0f, 3 );
		

		System.out.println( "Peter betaald " + peter.GetRsz() + " RSZ." );


		jan.Betaal();
		luna.Betaal();
		peter.Betaal();

	
		Factuur factuur1 = new Factuur( 1, 100.0f );

		Betaalbaar[] betaalDingen = new Betaalbaar[2];
		betaalDingen[0] = jan;
		betaalDingen[1] = factuur1;


		for( int i = 0; i < 2; i++ ) {
			
			//gaat nu voor [0] jan  kijken naar de versie van Betaal van de Werknemer klasse ("Betaal het salaris .... van ...")
			//gaat voor [1] factuur1 kijken naar de versie van Betaal() van de Factuur klasse ("Betaal de factuur van...")
			betaalDingen[i].Betaal();

		}




	}

}