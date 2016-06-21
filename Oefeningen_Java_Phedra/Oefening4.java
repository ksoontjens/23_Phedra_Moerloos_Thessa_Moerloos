/**
*
*Dit is een programma
*@author Phedra Moerloos
*
*/


public class Oefening4 {

	/**
	* Dit is de main methode
	*arg zijn parameters die met de commandline (cmd) meekomen
	*
	*/	

	public static void main ( String arg[] ) {
		
		int l = 4302;
		Negatief(l);

	}



	/*
	* Deze methode berekent het negatief getal
	*
	*/
	public static void Negatief(int g)
	{
		int negatiefGetal = ( ~ g + 1 );
		System.out.println( negatiefGetal );
	}

}


	