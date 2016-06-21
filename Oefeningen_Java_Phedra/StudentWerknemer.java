public class StudentWerknemer extends ParttimeWerknemer {

	public StudentWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGewerkt) {
		
		//moet op 1ste lijn -> roept constructor op van ParttimeWerknemer
		super(voornaam, achternaam, wNummer, salaris, urenGewerkt);
		
		SetRsz(5.0f);
		

	}


}