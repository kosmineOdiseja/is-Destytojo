	/**
	* stud - Programavimo Java mokymuisi skirtu pagalbiniu klasiu rinkinys
	*/
	package stud;
	/**
	* Klase skirta automobilio ir jo stoteliu duomenims ir busenai saugoti ir patikrinti ir perskaiciuoti
	* versija 0.0.1
	bet kas
	*/
	public class Automobilis {
		
		public String pav;
		public double greitis_v;
		public double atstum;
		public double laik;
		public Stotele[] stoteles;
		public int num_stoteliu;
		public int num_stoteliu_pravaziuota;
		public int[] nums_stoteliu_pravaziuotu;
		
		public Automobilis ( String pvd, double greitis, int num_stot ) {
			
			pav = pvd;
			greitis_v = greitis;
			num_stoteliu = num_stot;
			num_stoteliu_pravaziuota = 0;
			
			stoteles = new Stotele [ num_stoteliu ];
			nums_stoteliu_pravaziuotu = new int[ num_stoteliu ];
		}
		
		public double atstumas ( double laikas ) {
			
			atstum = laikas * greitis_v;
			laik = laikas;
			
			tikrintiStoteles();
			
			if ( atstum > stoteles [ num_stoteliu - 1 ].atst ) {
			
				atstum = stoteles [ num_stoteliu - 1 ].atst;
			}
			
			return atstum;
		}
		
		public void tikrintiStoteles() {
			
			num_stoteliu_pravaziuota = 0;
			
			for ( int i = 0; i < num_stoteliu; i++ ) {
			
				if ( stoteles [ i ].arTikKaPravaziavo ( atstum ) ) {
					
					// System.out.print ( "blaaaa !" );
					
					nums_stoteliu_pravaziuotu [ num_stoteliu_pravaziuota ] = i;

					num_stoteliu_pravaziuota++;
				}
			}
			// System.out.println ( "--" + num_stoteliu_pravaziuota );
		}
	}