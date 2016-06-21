/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class Oefening3 {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	public static void main ( String arg[] ) {

		pi();

	}



	/*
	* Deze methode berekent het getal pi
	*
	*/
	public static void pi()
	{

	int plaats;
	int noemer = 1;
	double pi = 0;
	double som = 0;
	
	for ( plaats = 0; plaats < 10000; plaats++) 
	{
		
		//even plaatsen
		if ( plaats%2 == 0 ) 
		{
			som += (1.0f/noemer);
		}

		//oneven plaatsen
		else
		{
			som -= (1.0f/noemer);
		}

	

		noemer = noemer + 2;

	}

	pi = 4*som;

	System.out.println( pi );

		

		
	}

}


	