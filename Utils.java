	/**
	* stud - Programavimo Java mokymuisi skirtu pagalbiniu klasiu rinkinys
	*/
	package stud;
	/**
	* Klase skirta ivairioms universalioms funkcijoms (statiniams metodams)
	* versija 0.0.1
	*/
	public class Utils {
		
		public static String laikas ( double laikas_val ) {
			
			double laikas_sek_viso = laikas_val * 3600;
			int laikas_sek_viso_1st = 	( int ) laikas_sek_viso;													// _1st - vienos sekundes tikslumu
			int laikas_h = laikas_sek_viso_1st / 3600;
			int laikas_min = ( laikas_sek_viso_1st - laikas_h * 3600 ) / 60;
			int laikas_sek = laikas_min % 60;																// % - dalybos liekana
			
			String laikas_str = "" + laikas_h + ":" + ( laikas_min < 10 ? "0" : "" ) + laikas_min + ":" + ( laikas_sek < 10 ? "0" : "" ) + laikas_sek;
			
			return laikas_str;
		}
	}