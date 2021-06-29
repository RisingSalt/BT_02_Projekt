import java.util.Scanner;
public class GleichstromRechner 
{
	//Volt (U)
	private double spannung;
	//Stromst�rke (I)
	private double strom;
	//Ohm (R)
	private double widerstand;
	//Watt (P)
	private double leistung;
	
	/*
	 * Main -> agiert als Men� 
	 * In der Main kann der User sich im Programm fortbewegen
	 */
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int menue = 0;
		double eingabe = 0;
		do 
		{
			GleichstromRechner gr = new GleichstromRechner();
			do 
			{
				System.out.printf("\n<----------Menue---------->");
				System.out.printf("\n<1> Spannung berechnen");
				System.out.printf("\n<2> Stromst�rke berechnen");
				System.out.printf("\n<3> Widerstand berechnen");
				System.out.printf("\n<4> Leistung berechnen");
				System.out.printf("\n<0> Programm beenden");
				System.out.printf("\nWas m�chten Sie erledigen: ");
				menue = sc.nextInt();
			}while(menue != 0 && menue != 1 && menue != 2 && menue != 3 && menue != 4);
			
			if(menue != 0)
			{
				int u_menue = 0;
				switch(menue)
				{
					case 1:
						do
						{
							do 
							{
								System.out.printf("\n<---Sapnnung berechnen--->");
								System.out.printf("\n<1> Spannung berechnen(R*I)");
								System.out.printf("\n<2> Spannung berechnen(P/I)");
								System.out.printf("\n<3> Spannung berechnen(Wurzel(P*R))");
								System.out.printf("\n<0> Zur�ck zum Hauptmenue");
								System.out.printf("\nWas m�chten Sie erledigen: ");
								u_menue = sc.nextInt();
							}while(u_menue != 0 && u_menue != 1 && u_menue != 2 && u_menue != 3);
							
							if(u_menue != 0)
							{
								switch(u_menue)
								{
									case 1:
										do
										{
											System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");	
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Widerstand(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n| %s | ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Strom(eingabe);							
										
										gr.berechne_Spannung_Variante_01();
										gr.ausgabe(1);	
									break;
									
									case 2:	
										
										do
										{
											System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Leistung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Strom(eingabe);
										
										gr.berechne_Spannung_Variante_02();
										gr.ausgabe(1);											
									break;
										
									case 3:
										do
										{
											System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Leistung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Widerstand(eingabe);
										
										gr.berechne_Spannung_Variante_03();
										gr.ausgabe(1);										
									break;
								}
							}
						}while(u_menue != 0);
					break;
						
					case 2:
						do
						{
							do 
							{
								System.out.printf("\n<---Stromst�rke berechnen--->");
								System.out.printf("\n<1> Stromst�rke berechnen(U/R)");
								System.out.printf("\n<2> Stromst�rke berechnen(Wurzel(P/R))");
								System.out.printf("\n<3> Stromst�rke berechnen(P/U)");
								System.out.printf("\n<0> Zur�ck zum Hauptmenue");
								System.out.printf("\nWas m�chten Sie erledigen: ");
								u_menue = sc.nextInt();
							}while(u_menue != 0 && u_menue != 1 && u_menue != 2 && u_menue != 3);
							
							if(u_menue != 0)
							{
								switch(u_menue)
								{
									case 1:
										do
										{
											System.out.printf("\nGeben Sie bitte die Spannung in Volt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Spannung in Volt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Spannung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Widerstand in Ohn ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Widerstand in Ohn ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);			
										gr.set_Widerstand(eingabe);
										
										gr.berechne_Strom_Variante_01();
										gr.ausgabe(2);	
									break;
									
									case 2:	
										do
										{
											System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Leistung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Widerstnad in Ohn ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Widerstnad in Ohn ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Widerstand(eingabe);
										
										gr.berechne_Strom_Variante_02();
										gr.ausgabe(2);											
									break;
										
									case 3:	
										do
										{
											System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Leistung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Spannung in Volt ein ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Spannung in Volt ein ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Spannung(eingabe);
										
										gr.berechne_Strom_Variante_03();
										gr.ausgabe(2);										
									break;
								}
							}
						}while(u_menue != 0);
					break;
				
					case 3:
						do
						{
							do 
							{
								System.out.printf("\n<---Widerstand berechnen--->");
								System.out.printf("\n<1> Widerstand berechnen(U/I)");
								System.out.printf("\n<2> Widerstand berechnen(P/(I^2))");
								System.out.printf("\n<3> Widerstand berechnen((U^2)/P)");
								System.out.printf("\n<0> Zur�ck zum Hauptmenue");
								System.out.printf("\nWas m�chten Sie erledigen: ");
								u_menue = sc.nextInt();
							}while(u_menue != 0 && u_menue != 1 && u_menue != 2 && u_menue != 3);
							
							if(u_menue != 0)
							{
								switch(u_menue)
								{
									case 1:
										do
										{
											System.out.printf("\nGeben Sie bitte den Spannung in Volt ein ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Spannung in Volt ein ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);
										gr.set_Spannung(eingabe);								
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Spannung in Volt ein ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);			
										gr.set_Strom(eingabe);
										
										gr.berechne_Widerstand_Variante_01();
										gr.ausgabe(3);	
									break;
									
									case 2:	
										do
										{
											System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Leistung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Spannung in Volt ein ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Strom(eingabe);
										
										gr.berechne_Widerstand_Variante_02();
										gr.ausgabe(3);											
									break;
										
									case 3:										
										do
										{
											System.out.printf("\nGeben Sie bitte den Spannung in Volt ein ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Strom(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Leistung in Watt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Leistung(eingabe);
										
										gr.berechne_Widerstand_Variante_03();
										gr.ausgabe(3);										
									break;
								}
							}
						}while(u_menue != 0);
					break;
				
					case 4:
						do
						{
							do 
							{
								System.out.printf("\n<---Leistung berechnen--->");
								System.out.printf("\n<1> Leistung berechnen(U*I)");
								System.out.printf("\n<2> Leistung berechnen((I^2)*R)");
								System.out.printf("\n<3> Leistung berechnen((U^2)/R)");
								System.out.printf("\n<0> Zur�ck zum Hauptmenue");
								System.out.printf("\nWas m�chten Sie erledigen: ");
								u_menue = sc.nextInt();
							}while(u_menue != 0 && u_menue != 1 && u_menue != 2 && u_menue != 3);
							
							if(u_menue != 0)
							{
								switch(u_menue)
								{
									case 1:
										do
										{
											System.out.printf("\nGeben Sie bitte die Spannung in Volt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Spannung in Volt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	 
										gr.set_Spannung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);				
										gr.set_Strom(eingabe);
										
										gr.berechne_Leistung_Variante_01();
										gr.ausgabe(4);	
									break;
									
									case 2:		
										do
										{
											System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Stromst�rke in Ampere ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Strom(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Widerstand(eingabe);
										
										gr.berechne_Leistung_Variante_02();
										gr.ausgabe(4);											
									break;
										
									case 3:										
										do
										{
											System.out.printf("\nGeben Sie bitte die Spannung in Volt ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte die Spannung in Volt ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	 
										gr.set_Spannung(eingabe);
										
										do
										{
											System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											while(!sc.hasNextDouble())
											{								
												String err = sc.next(); 														
												System.out.printf("\n|%s| ist keine G�ltiger Wert!",err);
												System.out.printf("\nGeben Sie bitte den Widerstand in Ohm ein: ");
											}
											eingabe = sc.nextDouble();
										}while(gr.fehlerpruefer(eingabe) == 0);	
										gr.set_Widerstand(eingabe);
										
										gr.berechne_Leistung_Variante_03();
										gr.ausgabe(4);										
									break;
								}
							}
						}while(u_menue != 0);
					break;
				}
			}
		}while(menue != 0);
		sc.close();
	}
	/*
	 * Standardkonstruktor
	 */
	public GleichstromRechner()
	{
		spannung = 0;
		strom = 0;
		widerstand = 0;
		leistung = 0;
	}
		
	/*
	 * 4 Setter Methoden
	 * F�r alle Einheiten(U/R/I/P)
	 */
	public void set_Spannung(double eingabe)
	{
		spannung = eingabe;
	}
	
	public void set_Strom(double eingabe)
	{
		strom = eingabe;
	}
	
	public void set_Widerstand(double eingabe)
	{
		widerstand = eingabe;
	}
	
	public void set_Leistung(double eingabe)
	{
		leistung = eingabe;
	}
	
	/*
	 * Fehler�berpr�fung
	 */
	public int fehlerpruefer(double eingabe)
	{
		if(eingabe < 0 || eingabe == 0)
		{
			System.out.printf("\nGeben Sie bitte ein G�ltigen Wert ein!");
			return 0;
		}else
		{
			return 1;
		}
	}
	
	/*
	 * Rechnungen f�r alle Varianten
	 */
	public void berechne_Spannung_Variante_01()
	{
		spannung = widerstand * strom;
	}
	
	public void berechne_Spannung_Variante_02()
	{
		spannung = leistung / strom;
	}
	
	public void berechne_Spannung_Variante_03()
	{
		spannung =  Math.sqrt(leistung * widerstand);
	}
	
	public void berechne_Strom_Variante_01()
	{
		strom = spannung / widerstand;
	}
	
	public void berechne_Strom_Variante_02()
	{
		strom = Math.sqrt(leistung / widerstand);
	}
	
	public void berechne_Strom_Variante_03()
	{
		strom =  leistung / spannung;
	}
	
	public void berechne_Widerstand_Variante_01()
	{
		widerstand = spannung / strom;
	}
	
	public void berechne_Widerstand_Variante_02()
	{
		widerstand = leistung / (strom*strom);
	}
	
	public void berechne_Widerstand_Variante_03()
	{
		widerstand = (spannung*spannung) / leistung;
	}
	
	public void berechne_Leistung_Variante_01()
	{
		leistung = spannung * strom;
	}
	
	public void berechne_Leistung_Variante_02()
	{
		leistung = (strom*strom) * widerstand;
	}
	
	public void berechne_Leistung_Variante_03()
	{
		leistung = (spannung*spannung) / widerstand;
	}
	
	/*
	 * Ausgabe
	 */
	public void ausgabe(int auswahl)
	{
		switch(auswahl)
		{
			case 1:
				System.out.printf("\nDie Spannung betr�gt %.2f Volt\n", spannung);	
			break;
				
			case 2:
				System.out.printf("\nDie Stromst�rke betr�gt %.2f Ampere\n", strom);	
			break;
		
			case 3:
				System.out.printf("\nDer Widerstand betr�gt %.2f Ohm\n", widerstand);	
			break;
		
			case 4:
				System.out.printf("\nDie Leistung betr�gt %.2f Watt\n", leistung);
			break;
		}
	}
}