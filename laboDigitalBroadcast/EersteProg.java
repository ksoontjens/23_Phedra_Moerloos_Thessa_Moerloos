/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class EersteProg {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	public static void main ( String arg[] ) {

		drukaf( 100 );
		WhileVanFor();

	}

	


	/**
	*Deze methode zal de getallen vanaf 0 tot (niet en met) het getal dat je meegeeft aan de methode afdrukken
	*
	*/
	public static void drukaf ( int m )
	{
	
		int a;
		for ( a = 0; a < m; a++) {
		
			System.out.println( a );

		}

		System.out.println( ~10 + 1 );
	
	}


	public static void WhileVanFor()
	{

	
		int i = 55;

		while ( i > 34 ) {

			System.out.println( i );	
			
			i--;
		}

		
	
	}

}