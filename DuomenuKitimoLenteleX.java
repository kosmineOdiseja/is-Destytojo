	/**
	* stud - Programavimo Java mokymuisi skirtu pagalbiniu klasiu rinkinys
	*/
	package stud;
	/**
	* Klase skirta pavaizduoti duomenu kitimo lentele programos vygdymo metu
	* versija 0.0.1
	*/
	public class DuomenuKitimoLenteleX extends Lentele {
				
		/**
		* DuomenuKitimoLenetele - specialus metodas - klases konstruktorius - turi vadintis taip pat kaip klase
		* @param String[] duomenu_kitimo_lentele -  lenteles grafos - stulpeliu pavadinimai, rekomenduojama su tarpais ir stulpeliu skyrimo simboliais, pilnu plociu, pvz.: { "| laikas |", " atstumas |" }
		*/
		 public DuomenuKitimoLenteleX ( String[] pavadinimai_lenteleliu_grafu ) {

			pav_lent_grafu = pavadinimai_lenteleliu_grafu;								// isimenamos lenteles grafos
			skPoz();															// skaiciuojamos atstumu (simboliais) iki stulpeliu masyvo len_iki_stulp ir visos lenteles plocio (simboliais) total_sum reiksmes
		}
		
		/**
		 * iLentele - metodas atvaizduojantis viena laukeli vienoje eiluteje
		* @param int kodoEil - kodo eilute, kurioje gaunama pateikiamo kintamojo reiksme
		* @param String laukelis - nurodomas sulpelio pavadinimas ( grafa ), kurios pozcijoje pateikiama reiksme
		* @param String pateikiam reiksme
		*/
		public void iLentele ( int kodoEil, String laukelis, String duom ) {
			
			int lent_x = pav_lent_grafu.length + 1;									// lent_x stulpelio, kuriam bus pateikiama reiksme nr  - pradzioje nustatoma uz paskutinio stulpelio
			
			for ( int i = 0; i < pav_lent_grafu.length; i++ ) {							// pertikrinamos stulpeliu pavadinimai (grafos)
			
				if ( laukelis == pav_lent_grafu [ i ] ) {								// jei nurodytas laukelis sutampa su grafos pavadinimu ..
			
					lent_x = i;													// .. jo numeris isimenamas lent_x kintamajame
				}
			}
			String 
					frmt														// frmt - format'o eilute, nurodanti kaip suformatuoti lenteles eilute vaizduojant kintamojo ar israiskos reiksme 
					, i_lentele													// suformuota lenteles eilutes eilute
				;													
			
			if ( lent_x == 1 ) {													// atvejis kai reiksme talpinama pirmoje pozicijoje ..
																			//..  tai po jos yra nurodomas ilgas tarpas su lenteles krasto simboliu "|"
				frmt = "| %"+ ( len_iki_stulp [ 1 ] - 4 ) + "d | %"  + ( pav_lent_grafu [ lent_x ].length() - 3 ) + "s |" + "%" + ( total_len - len_iki_stulp [ 2 ] - 2 ) + "s |";
				i_lentele = String.format ( frmt, kodoEil,  duom, " " );
				
			} else {
			
				if ( lent_x == ( pav_lent_grafu.length - 1  ) ) {							// atvejis kai reiksme talpinama paskutine pozicijoje ..
																			//..  tai pries ja yra nurodomas ilgas tarpas apimatis visus iki tol einancius stulpelius
					frmt = "| %"+ ( len_iki_stulp [ 1 ] - 4 ) + "d | %" + ( len_iki_stulp [ lent_x ] - len_iki_stulp [ 1 ]  - 3 ) + "s | %" + ( pav_lent_grafu [ lent_x  ].length() - 3 ) + "s |";
					i_lentele = String.format ( frmt, kodoEil, " ",  duom );
					
				} else {														// atvejis kai reiksme talpinama tarpineje pozicijoje ..
																			//..  apima abu pries tai buvusius atvejus
					frmt = "| %"+ ( len_iki_stulp [ 1 ] - 4 ) + "d | %" + ( len_iki_stulp [ lent_x ] - len_iki_stulp [ 1 ]  - 3 ) + "s | %" + ( pav_lent_grafu [ lent_x ].length() - 3 ) + "s |%" + ( total_len - len_iki_stulp [ lent_x + 1 ] - 2 ) + "s |";
					i_lentele = String.format ( frmt, kodoEil, " ",  duom, " " );
				}
			}
			System.out.println (  i_lentele );											// "uzrasoma" suformuota eilute
			horizEil();															// "nubreziama horizontali linija
		}
	}