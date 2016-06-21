/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class Oefening5 {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	public static void main ( String arg[] ) {
		
		Priemgetallen();

	}



	/**
	* Deze methode berekent alle priemgetalln van 3 tot en met 99.
	*
	*/
	public static void Priemgetallen()
	{
		
		Boolean isPriemgetal = false;
		int getal = 0;
		float deler = 0;
		
		for ( getal = 1; getal < 100; getal++) {

			for (deler = 2.0f; deler < getal; deler++) {
				
				
				if( getal % deler == 0) {
					
					break;

				}

		 
				

			}
			

			if (getal == deler){

				System.out.println( getal + " " );

			}
		
		}
		
			

	}




}


	