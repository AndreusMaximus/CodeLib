package template.library;


import processing.core.*;
import processing.core.PApplet;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class CodeLib{
	private PApplet myParent;
	
	private int dimensie; //Breedte van de liniaal
	private int limitX;   //Lengte x-liniaal
	private int limitY;   //Lengte y-liniaal
	private boolean liniaalAan = false;
	private boolean lReleased = true;

	private int myVariable = 0;
	

	private boolean[] keys = new boolean[5];
	private boolean[] keyCodes = new boolean[4];

	private boolean A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, LINKS, RECHTS, OMHOOG, OMLAAG, SPRINGEN, SHIFT, CONTROL, ALT;
	
	
	public CodeLib(PApplet theParent) {
		myParent = theParent;
	}

	public boolean botsingLinks(String graphic, int kleur, float x, float y, float breedte, float hoogte){
		  if(graphic == "rect"){  
		     return botsingCheckerRect(kleur, x, y, breedte, hoogte, "Links");
		  } 
		  else if(graphic == "ellipse"){        
		     return botsingCheckerEllipse(kleur, x, y, breedte, hoogte, "Links");
		  }
		  return false;
		}

		public boolean botsingRechts(String graphic, int kleur, float x, float y, float breedte, float hoogte){
		  if(graphic == "rect"){  
		     return botsingCheckerRect(kleur, x, y, breedte, hoogte, "Rechts");
		  } 
		  else if(graphic == "ellipse"){        
		     return botsingCheckerEllipse(kleur, x, y, breedte, hoogte, "Rechts");
		  }
		  return false;
		}
		public boolean botsingBoven(String graphic, int kleur, float x, float y, float breedte, float hoogte){
		  if(graphic == "rect"){  
		     return botsingCheckerRect(kleur, x, y, breedte, hoogte, "Boven");
		  } 
		  else if(graphic == "ellipse"){        
		     return botsingCheckerEllipse(kleur, x, y, breedte, hoogte, "Boven");
		  }
		  return false;
		}
		public boolean botsingOnder(String graphic, int kleur, float x, float y, float breedte, float hoogte){
		  if(graphic == "rect"){ 
		     return botsingCheckerRect(kleur, x, y, breedte, hoogte, "Onder");
		  } 
		  else if(graphic == "ellipse"){        
		     return botsingCheckerEllipse(kleur, x, y, breedte, hoogte, "Onder");
		  }
		  return false;
		}

		boolean botsing(String graphic, int kleur, float x, float y, float breedte, float hoogte){
		  if(graphic == "rect"){  
		     return botsingCheckerRect(kleur, x, y, breedte, hoogte, "alles");
		  } 
		  else if(graphic == "ellipse"){        
		     return botsingCheckerEllipse(kleur, x, y, breedte, hoogte, "alles");
		  }
		  return false;
		}
		   
		// Kijkt of een rechthoek ergens mee botst
		public boolean botsingCheckerRect(int kleur, float x, float y, float breedte, float hoogte, String kant){
		  // hoeveelheid meetpunten bepalen (iedere 5 pixels één) 
		  float meetpunten;
		  if(kant == "Boven" || kant == "Onder"){
		     meetpunten = breedte/5; 
		  }
		  else if(kant == "Rechts" || kant == "Links"){
		    meetpunten = hoogte/5; 
		  }
		  else{
		    meetpunten = (breedte >= hoogte ? breedte : hoogte)/5;
		    PApplet.print(meetpunten);
		  }
		  
		  //punten checken voor iedere zijde van de rechthoek
		  float optellerX = breedte/meetpunten;
		  float optellerY = hoogte/meetpunten;    
		  for(int i = 0; i < meetpunten+1; i += 1){
		    float xVar = x + (i*optellerX);
		    float yVar = y + (i*optellerY);

		    if((kant == "Boven" || kant == "alles") && myParent.get((int)(xVar), (int)y-1) == kleur){
		      return true;
		    }
		    if((kant == "Onder" || kant == "alles") && myParent.get((int)(xVar),(int)(y + hoogte + 1)) == kleur){
		      return true; 
		    }
		    if((kant == "Rechts" || kant == "alles") && myParent.get((int)x-1, (int)(yVar)) == kleur){
		      return true;
		    }
		    if((kant == "Links" || kant == "alles") && myParent.get((int)(x + breedte + 1), (int)(yVar)) == kleur){
		      return true; 
		    }
		    /*
		    //Visualisatie van meetpunten (werkt alleen als er geen botsing plaatsvindt)
		    fill(0,255,0);
		    ellipse(xVar,y-1, 5,5);
		    ellipse(xVar,y+hoogte+1, 5,5);
		    ellipse(x-1, yVar, 5,5);
		    ellipse(x + breedte + 1,yVar, 5,5); 
		    */    
		  }   
		  return false;
		}

		// Kijkt of een ellipse ergens mee botst.    
		public boolean botsingCheckerEllipse(int kleur, float x, float y, float breedte, float hoogte, String kant){
		  // hoeveelheid meetpunten bepalen (iedere 5 pixels één) 
		  float meetpunten;
		  if(kant == "Boven" || kant == "Onder"){
		     meetpunten = breedte/5; 
		  }
		  else if(kant == "Rechts" || kant == "Links"){
		    meetpunten = hoogte/5; 
		  }
		  else{
		    meetpunten = (breedte >= hoogte ? breedte : hoogte)/5;
		  }
		  
		  float opteller = breedte/meetpunten; 
		  float straalX = breedte/2;
		  float straalY = hoogte/2;
		  
		  //punt links en rechts bepalen
		  if(kant == "Links" || myParent.get((int)(x-straalX-1), (int)y) == kleur){      
		           //b.Links = true;  
		           return true;
		  }
		  if(kant == "Rechts" || myParent.get((int)(x + straalX + 1), (int)y) == kleur){             
		           //b.Rechts = true; 
		           return true;
		  }
		  /*
		  //Visualisatie van meetpunten
		  fill(0,255,0);
		  ellipse(x-straalX-1,y,5,5);
		  ellipse(x + straalX + 1,y,5,5);
		  */
		  //Punten checken voor alle kanten van de ellipse 
		  for(int i = 0; i < meetpunten + 1; i+= 1){
		    float var = (-straalX) + (i*opteller);
		    float j = PApplet.sqrt(PApplet.sq(straalY) - PApplet.sq(straalY)*PApplet.sq(var)/PApplet.sq(straalX));
		    float xVar;
		    if(i < meetpunten/2){
		      xVar = var + x-1;
		    }
		    else if(meetpunten/2>6){        
		      xVar = var + x+1;
		    }
		    else{
		       xVar = var + x;
		    }
		    float yVarBoven = -j+y -1;
		    float yVarOnder = j+y + 1;
		    
		    //botsingen checken
		    if(myParent.get((int)xVar,(int)yVarBoven) == kleur){
		       //boven links/rechts is true 
		       if(yVarBoven >= y-straalY){
		         if((kant == "Boven" || kant == "Rechts" || kant == "alles") && xVar < x ){
		           //b.Boven = true;
		           //b.Links = true;             
		         return true;  
		       }
		         if((kant == "Boven" ||  kant == "Links" || kant == "alles") && xVar > x){  
		           //b.Boven = true;         
		           //b.Rechts = true;  
		           return true;
		         }
		       }           
		       else if (kant == "Boven"){
		         //b.Boven = true;  
		         return true;
		       }
		    }
		    if(myParent.get((int)xVar, (int)yVarOnder) == kleur){
		      //onder links/rechts is true
		      if(yVarOnder < y + straalY){
		         if((kant == "Onder" || kant == "Links" || kant == "alles") && xVar < x){     
		          // b.Onder = true;        
		          // b.Links = true;   
		          return true;
		         }
		         if((kant == "Onder" || kant == "Rechts" || kant == "alles") && xVar > x){
		          // b.Onder = true;  
		          // b.Rechts = true; 
		          return true;            
		         }
		       }
		       else if (kant == "Onder"){
		        // b.Onder = true;  
		        return true;
		       }      
		    }
		         
		    //Visualisatie van meetpunten
		    myParent.fill(0,255,0);
		    myParent.ellipse(xVar,yVarBoven-1,5,5);
		    myParent.ellipse(xVar,yVarOnder+1,5,5);
		    
		  }
		  return false;
		}



		// Y besturing float
		public float bewegingVerticaal(float snelheidVar){
		  if((keyCodes[0] == true || keys[0] == true) && (keyCodes[1] == true || keys[1] == true)){
		   return 0; 
		  }  
		  if(keyCodes[0] == true || keys[0] == true){
		   return -snelheidVar;
		  }
		  if(keyCodes[1] == true || keys[1] == true){
		   return snelheidVar;
		  }
		  return 0;
		}

		//Y besturing int
		public int bewegingVerticaal(int snelheidVar){
		  if((keyCodes[0] == true || keys[0] == true) && (keyCodes[1] == true || keys[1] == true)){
		   return 0; 
		  }  
		  if(keyCodes[0] == true || keys[0] == true){
		   return -snelheidVar;
		  }
		  if(keyCodes[1] == true || keys[1] == true){
		   return snelheidVar;
		  }
		  return 0;
		}


		// links en rechts besturing float
		public float bewegingHorizontaal(float snelheidVar){
		  if((keyCodes[2] == true || keys[2] == true) && (keyCodes[3] == true || keys[3] == true)){
		   return 0;
		  }
		  if(keyCodes[2] == true || keys[2] == true){
		   return -snelheidVar;
		  }
		  if(keyCodes[3] == true || keys[3] == true){
		   return snelheidVar;
		  }
		  return 0;
		}

		// links en rechts besturing int
		public int bewegingHorizontaal(int snelheidVar){
		  if((keyCodes[2] == true || keys[2] == true) && (keyCodes[3] == true || keys[3] == true)){
		   return 0;
		  }
		  if(keyCodes[2] == true || keys[2] == true){
		   return -snelheidVar;
		  }
		  if(keyCodes[3] == true || keys[3] == true){
		   return snelheidVar;
		  }
		  return 0;
		}

		public void keyPressed(){
		  newPressed();
		  oldPressed();
		}
		
		private void newPressed() {
			
			switch(myParent.key) {
			  case 'a':
			    A = true;
			    break;
			  case 'b':
			    B = true;
			    break;
			  case 'c':
			    C = true;
			    break;
			  case 'd':
			    D = true;
			    break;
			  case 'e':
			    E = true;
			    break;
			  case 'f':
			    F = true;
			    break;
			  case 'g':
			    G = true;
			    break;
			  case 'h':
			    H = true;
			    break;
			  case 'i':
			    I = true;
			    break;
			  case 'j':
			    J = true;
			    break;
			  case 'k':
			    K = true;
			    break;
			  case 'l':
			    L = true;
			    break;
			  case 'm':
			    M = true;
			    break;
			  case 'n':
			    N = true;
			    break;
			  case 'o':
			    O = true;
			    break;
			  case 'p':
			    P = true;
			    break;
			  case 'q':
			    Q = true;
			    break;
			  case 'r':
			    R = true;
			    break;
			  case 's':
			    S = true;
			    break;
			  case 't':
			    T = true;
			    break;
			  case 'u':
			    U = true;
			    break;
			  case 'v':
			    V = true;
			    break;
			  case 'w':
			    W = true;
			    break;
			  case 'x':
			    X = true;
			    break;
			  case 'y':
			    Y = true;
			    break;
			  case 'z':
			    Z = true;
			    break;
			  case 'A':
			    A = true;
			    break;
			  case 'B':
			    B = true;
			    break;
			  case 'C':
			    C = true;
			    break;
			  case 'D':
			    D = true;
			    break;
			  case 'E':
			    E = true;
			    break;
			  case 'F':
			    F = true;
			    break;
			  case 'G':
			    G = true;
			    break;
			  case 'H':
			    H = true;
			    break;
			  case 'I':
			    I = true;
			    break;
			  case 'J':
			    J = true;
			    break;
			  case 'K':
			    K = true;
			    break;
			  case 'L':
			    L = true;
			    break;
			  case 'M':
			    M = true;
			    break;
			  case 'N':
			    N = true;
			    break;
			  case 'O':
			    O = true;
			    break;
			  case 'P':
			    P = true;
			    break;
			  case 'Q':
			    Q = true;
			    break;
			  case 'R':
			    R = true;
			    break;
			  case 'S':
			    S = true;
			    break;
			  case 'T':
			    T = true;
			    break;
			  case 'U':
			    U = true;
			    break;
			  case 'V':
			    V = true;
			    break;
			  case 'W':
			    W = true;
			    break;
			  case 'X':
			    X = true;
			    break;
			  case 'Y':
			    Y = true;
			    break;
			  case 'Z':
			    Z = true;
			    break;
			  case ' ':
			    SPRINGEN  = true;
			    break;
			  }

			  switch(myParent.keyCode) {
			  case PApplet.LEFT:
			   LINKS = true;
			    break;
			  case PApplet.RIGHT:
			    RECHTS = true;
			    break;
			  case PApplet.UP:
			    OMHOOG = true;
			    break;
			  case PApplet.DOWN:
			    OMLAAG = true;
			    break;
			  }
		}
		
		private void oldPressed() {
			
			//pijltjes
			  if(myParent.keyCode == PApplet.UP){
			    keyCodes[0] = true;
			  }
			  if(myParent.keyCode == PApplet.DOWN){    
			    keyCodes[1] = true;
			  }
			  if(myParent.keyCode == PApplet.LEFT){
			    keyCodes[2] = true;    
			  }
			  if(myParent.keyCode == PApplet.RIGHT){
			    keyCodes[3] = true;    
			  }  
			  
			  //wsad
			  if(myParent.key == 'w'){
			    keys[0] = true;    
			  }
			  if(myParent.key == 's'){
			    keys[1] = true;    
			  }
			  if(myParent.key == 'a'){
			    keys[2] = true;    
			  }
			  if(myParent.key == 'd'){
			    keys[3] = true;    
			  }  
			  
			  //space
			  if(myParent.key == ' '){
			    keys[4] = true;    
			  }
		}
		

		public void keyReleased(){
		  newReleased();
		  oldReleased();
		}
		
		private void newReleased() {
			switch(myParent.key) {
			  case 'a':
			    A = false;
			    break;
			  case 'b':
			    B = false;
			    break;
			  case 'c':
			    C = false;
			    break;
			  case 'd':
			    D = false;
			    break;
			  case 'e':
			    E = false;
			    break;
			  case 'f':
			    F = false;
			    break;
			  case 'g':
			    G = false;
			    break;
			  case 'h':
			    H = false;
			    break;
			  case 'i':
			    I = false;
			    break;
			  case 'j':
			    J = false;
			    break;
			  case 'k':
			    K = false;
			    break;
			  case 'l':
			    L = false;
			    break;
			  case 'm':
			    M = false;
			    break;
			  case 'n':
			    N = false;
			    break;
			  case 'o':
			    O = false;
			    break;
			  case 'p':
			    P = false;
			    break;
			  case 'q':
			    Q = false;
			    break;
			  case 'r':
			    R = false;
			    break;
			  case 's':
			    S = false;
			    break;
			  case 't':
			    T = false;
			    break;
			  case 'u':
			    U = false;
			    break;
			  case 'v':
			    V = false;
			    break;
			  case 'w':
			    W = false;
			    break;
			  case 'x':
			    X = false;
			    break;
			  case 'y':
			    Y = false;
			    break;
			  case 'z':
			    Z = false;
			    break;
			  case 'A':
			    A = false;
			    break;
			  case 'B':
			    B = false;
			    break;
			  case 'C':
			    C = false;
			    break;
			  case 'D':
			    D = false;
			    break;
			  case 'E':
			    E = false;
			    break;
			  case 'F':
			    F = false;
			    break;
			  case 'G':
			    G = false;
			    break;
			  case 'H':
			    H = false;
			    break;
			  case 'I':
			    I = false;
			    break;
			  case 'J':
			    J = false;
			    break;
			  case 'K':
			    K = false;
			    break;
			  case 'L':
			    L = false;
			    break;
			  case 'M':
			    M = false;
			    break;
			  case 'N':
			    N = false;
			    break;
			  case 'O':
			    O = false;
			    break;
			  case 'P':
			    P = false;
			    break;
			  case 'Q':
			    Q = false;
			    break;
			  case 'R':
			    R = false;
			    break;
			  case 'S':
			    S = false;
			    break;
			  case 'T':
			    T = false;
			    break;
			  case 'U':
			    U = false;
			    break;
			  case 'V':
			    V = false;
			    break;
			  case 'W':
			    W = false;
			    break;
			  case 'X':
			    X = false;
			    break;
			  case 'Y':
			    Y = false;
			    break;
			  case 'Z':
			    Z = false;
			    break;
			  case ' ':
			    SPRINGEN  = false;
			    break;
			  }

			  switch(myParent.keyCode) {
			  case PApplet.LEFT:
			    LINKS = false;
			    break;
			  case PApplet.RIGHT:
			    RECHTS = false;
			    break;
			  case PApplet.UP:
			    OMHOOG = false;
			    break;
			  case PApplet.DOWN:
			    OMLAAG = false;
			    break;
			  }
			
		}
		
		private void oldReleased() {
			
			//pijltjes
			  if(myParent.keyCode == PApplet.UP){
			    keyCodes[0] = false;
			  }
			  if(myParent.keyCode == PApplet.DOWN){    
			    keyCodes[1] = false;
			  }
			  if(myParent.keyCode == PApplet.LEFT){
			    keyCodes[2] = false;    
			  }
			  if(myParent.keyCode == PApplet.RIGHT){
			    keyCodes[3] = false;    
			  }  
			  
			  //wsad
			  if(myParent.key == 'w'){
			    keys[0] = false;    
			  }
			  if(myParent.key == 's'){
			    keys[1] = false;    
			  }
			  if(myParent.key == 'a'){
			    keys[2] = false;    
			  }
			  if(myParent.key == 'd'){
			    keys[3] = false;    
			  }  
			  

				 if( myParent.key == 'l' || myParent.key == 'L'){
				   lReleased = true;
				 }
		}

		public void liniaal() {
		  myParent.strokeWeight(1);
		  myParent.stroke(0);
		  if (myParent.keyPressed && (myParent.key == 'l' || myParent.key == 'L') ) { //Druk op 'l' om de liniaal te gebruiken
		    if(lReleased){
		      if(!liniaalAan){
		       liniaalAan = true; 
		      }
		      else{
		       liniaalAan = false;   
		      } 
		      lReleased = false;  
		    }
		     
		  }
		  
		  if(liniaalAan){    
		      if (myParent.height > myParent.width) {
		        dimensie = Math.max(30, (int)(0.08*myParent.width));  //Breedte afhankelijk van breedte scherm, minimaal 30
		      } else {
		        dimensie = Math.max(30, (int)(0.08*myParent.height));
		      }
		      limitX = (myParent.width/100)+1;
		      limitY = (myParent.height/100)+1;
		      myParent.fill(200);
		      myParent.rect(0, 0, myParent.width, dimensie);  //Teken x-liniaal
		      myParent.fill(0);
		      for (int i = 1; i < limitX; i += 1) {  //Elke 100 pixels
		    	  myParent.line(100*i, 0.5f*dimensie, 100*i, dimensie);  //Tekent langere lijn
		        myParent.text(100*i, 100*i+2, 0.5f*dimensie);  //Schrijft x-coordinaat
		      }
		      for (int i = 1; i < limitX*10; i += 1) { //Elke 10 pixels
		    	  myParent.line(10*i, 0.8f*dimensie, 10*i, dimensie); //Tekent kleinere lijn
		      }
		      myParent.fill(200);
		      myParent.rect(0, 0, dimensie, myParent.height);  //Idem voor y-liniaal
		      myParent.fill(0);
		      for (int i = 1; i < limitY; i += 1) {
		    	  myParent.line(0.5f*dimensie, 100*i, dimensie, 100*i);
		    	  myParent.text((char)100*i, 0.20f*dimensie-2, 100*i-3);
		      }
		      for (int i = 1; i < limitY*10; i += 1) {
		    	  myParent.line(0.8f*dimensie, 10*i, dimensie, 10*i);
		      }
		      if (myParent.mouseY >= dimensie && myParent.mouseX >= dimensie) {  //Wanneer de muis binnen het scherm valt
		    	myParent.strokeWeight(2); 
		        myParent.cursor(PApplet.CROSS);  //Vervang muis door kruis
		        myParent.stroke(200, 0, 0);  //Teken rode lijn op liniaal op de coordinaten van de muis
		        myParent.line(0.5f*dimensie, myParent.mouseY, dimensie, myParent.mouseY);
		        myParent.line(myParent.mouseX, 0.5f*dimensie, myParent.mouseX, dimensie);
		      } else myParent.noCursor(); //Geen cursor wanneer muis op de liniaal zit
		    }else myParent.cursor(PApplet.ARROW);  //Normale muis als liniaal uit staat
		}
	
}

