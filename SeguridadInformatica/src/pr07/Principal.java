class Principal{

  
  
public String alf="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:-()"


public String[] mensaje_cifrado=["3O0ONvTNSVCtZZVPCNyNPNXXG0t7TGEA2T4EEDy,vE1YNDAVT5vAUQV",
"AKsFGKUVy4NAtnvXGFB,yWVFM5zy,yN5zyR2A9wJ4FBRtT5yAKwF4YE9",
"LG3ROE1LwEWKPEMZRtMVwLJKFAU3DtJTHI25VADKGEC2DtQZSOL8LTJ",
"wc)Xdlyl02pu24.abu4kAtRf CFc0,pq48saXeTnpg8bnaXoahyg47ikFs",
"pvW b Y6hulWrYQ-qf hUa(10eb mFnaX)iblbyl26Yjb Fyp(,eena",
"Ct3SGVINR2QuCV7KZJyZCSCYROIMFGRO0yVPVRXVDLNAG(OCXRvSRy-QRSF",
"OUpFOFtRaQNyASBJYFuKwJ4Tt9hGVFtWpSTNRKtZ,yBZlSGIE2hS6JtUl",
"HLURytk,SOWXRtZ,HtMVVDNKPU7KQIW4RtJ2JURVQtUVwIWTXLL5wEUKGI1ZPUU5",
"jq3b BSaTfleVfikFdV2LtRXdBQc42F.9haCJ 4fau,XpyJs4fjkRY Fyc-fveZ4",
"mB3 Z52j,esys63,egijFd.Q1a,lhX :X9:crhX 51(aocpF,R06jfrvz a52nsazA"]

public String[] claves_cifrado=["CAJFN","ARhFNF","DAJR","hcR4ahFa09","ahFaYXY:b",
    "CAJFN","ARhFNF","DAJR","hcR4ahFa09","ahFaYXY:b"]

 

public String alf2="aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()"


public String[] mensaje_cifrado2=["ZKXLxpZFKÉFvOPÑOAAABLKYvVp5PryFÚMÑIFsp5vBOZCzvRPPpFNÍÉ",
"JpZfvÓPRx1JrISP3pÑhV2ÑWfÑYOIEvWK8aF9v8vF2wÓfÑYOIfv0v7zF3",
"RITvQRy:IÑOtIJQñpINFtHFIibZVBtvIRñú33BupÍRanÑEÍHMÚPxj9J",
"daÉvd0Z(aaJs96W SVeákéayvvV91cñPn0jÚsjvv5,éosvs:ídrjOd5 1s",
"puT á8U5hujTrUÑ-pé fRa(XWéá lBnaT)iálávlY4Uíá Evp(,eena",
"xp0OrÓÑFJMUwrN0JWwAÑyOAÚBIÑÉxpVPÓpÑOTEYJzHJxr,UvPÁAUFp9PÓFF",
"YzVfDJpÑaNJpÑhVÑHÑáv0A7uv3vÓoBEBVsIRÑIrV pÓñFWpQjNJÍ9jvNA",
"ÑNKvBIYv5YOFKA6AfINFRzJIrv(EOHJUIfnU5JDÍAZj.VWETHI4afZEÉHOÑ0An3",
"4orP ce1 sFc0j,dfÉ.PúéaaÉu996 Evsc6íeaFnPjh vTeá,acñB,PóÚcuOoYa1",
"mA0 V2Yí,eqvs309egiiBd,ÑXa,lfU :T7.crfU 2X(añcñB,OW3íéruw a2Yñsayx"]

public String[] claves_cifrado2=["xvFB","JvÑfB","JBzvFÑfbÑ","1afBaV6","afBaUTU.á",
    "xvFB","JvÑfB","JBzvFÑfbÑ","1afBaV6","afBaUTU.á"]



	
 public static void main(String[] args) {
    		Principal objeto = new Principal();
        for (int i = 0; i<mensaje_cifrado.length(); i++){
           system.out.println("Fila " + i + ": " + objeto.descifrar(mensaje_cifrado[i], claves_cifrado[i], alf));    
        }
        for (int i = 0; i<mensaje_cifrado2.length(); i++){
           system.out.println("Fila " + i + ": " + objeto.descifrar(mensaje_cifrado2[i], claves_cifrado2[i], alf2));    
        }
  
       system.out.println("Fin del programa");
        
 }
  
  
  
 public String descifrar(String texto, String clave, String alfabeto){
   
   int cola = texto.length() % clave.lentgh();
   int divisionEntera = texto.length() / clave.lentgh();
   
   int[] claveNumerica = codificacionNumerica(clave, alfabeto);
   
   int[] textoNumerico = codificacionNumerica(texto, alfabeto);
   
   int[] resultado = new int[texto.length()];
   
   for (int j = 0; j<divisionEntera; j++){
     
     
   }
     
     
     if(cola != 0){
       
     }
   
   
   
 }
   
public int[] codificacionNumerica(String original, String alfabeto){
  //no tiene en cuenta si alguna palabra no esta en el alfabeto, se da por supuesto.
  int[] resultado = new int[original.length()];
  int index = 0;
  for (String e: original){
    int contador = 0;
    for (String letra: alfabeto){
      if (e == letra)
        break;
      else
        contador++;
    }
    resultado[index] = contador;
    index++;
       
  }
  return resultado;
}
  
  

}
