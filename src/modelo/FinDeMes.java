
package modelo;

public class FinDeMes {
private int  Home;
private int  Retroceso;
private int  Avanzar;

public FinDeMes(){
    
}

public FinDeMes (int Home, int Retroceso, int Avanzar){
    this.Home = Home;
    this.Retroceso = Retroceso;
    this.Avanzar = Avanzar;
}

public int getHome(){
    return Home;
} 
              
public void Home (int Home){
    this.Home = Home;
}
        
public int getRetroceso(){
    return Retroceso;
} 
              
public void Retroceso (int Home){
    this.Retroceso = Retroceso;
}

 public int getAvanzar(){
      return Avanzar;
  }    
      
   
 
 public void Avanzar (int Avanzar){
    this.Avanzar = Avanzar;
}
  
   
}

