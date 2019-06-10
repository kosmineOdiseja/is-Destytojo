	/**
	* stud - Programavimo Java mokymuisi skirtu pagalbiniu klasiu rinkinys
	*/
	package stud;
	/**
	* Klase skirta stoteles duomenims ir busenai saugoti ir patikrinti 
	* versija 0.0.1
	*/
	public class Stotele {
		
		public String pav;
		public boolean pravaziuota;
		public double atst;
		public double t_prav;
			
		
		public Stotele() {
		}
		
		public Stotele ( String pvd, double atstumas, double greitis_automobilio ) {
			
			tokia ( pvd, atstumas, greitis_automobilio );
		}
		
		public void tokia ( String pvd, double atstumas, double greitis_automobilio ) {
			
			pav = pvd;
			pravaziuota = false;
			atst = atstumas;
			t_prav = 0;
			
			if ( greitis_automobilio > 0 ) {
				
				t_prav = atstumas / greitis_automobilio;
			}
		}		
		
		public boolean arTikKaPravaziavo ( double atstumas ) {
			
			boolean tik_ka_pravaziavo = false;
		
			if ( ! pravaziuota ) {
			
				if ( atst < atstumas ) {

					pravaziuota = true;
					tik_ka_pravaziavo = true;
				}
			}
			return tik_ka_pravaziavo;
		}
	}
	