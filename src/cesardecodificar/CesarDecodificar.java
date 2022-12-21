package cesardecodificar;
import java.util.Scanner;
public class CesarDecodificar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String abecedario= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String codificado, decodificado, fraseCodificar, fraseDecodificar;
        int desplazamiento1, desplazamiento2;
        System.out.println("INGRESE UNA FRASE CODIFICADA: ");
        fraseDecodificar = sc.nextLine();
        System.out.println("INGRESE EL DESPLAZAMIENTO: ");
        desplazamiento1 = sc.nextInt();
        decodificado=decodificar(abecedario,fraseDecodificar,desplazamiento1);
        System.out.println("Frase Decodificada: "+decodificado);
    }
    public static String codificar(String abecedario, String texto, int desplazamiento){
        String textoCodificado = "";
        texto = texto.toUpperCase();
        char caracter;
        int posicion;
        for (int i = 0; i < texto.length(); i++) {
            caracter=texto.charAt(i);
            posicion=abecedario.indexOf(caracter);
            if (posicion==-1){
                textoCodificado+=caracter;
            }else{
                textoCodificado+= abecedario.charAt((posicion+desplazamiento) % abecedario.length());
            }            
        }
        return textoCodificado;
    }
    public static String decodificar(String abecedario, String texto, int desplazamiento){
        String textoDecodificado = "";
        texto = texto.toUpperCase();
        char caracter;
        int posicion;
        for (int i = 0; i < texto.length(); i++) {
            caracter=texto.charAt(i);
            posicion=abecedario.indexOf(caracter);            
            if (posicion==-1){
                textoDecodificado+=caracter;
            }else{
                if(posicion-desplazamiento<0){
                    textoDecodificado+= abecedario.charAt(abecedario.length()+(posicion-desplazamiento));
                }else{
                    textoDecodificado+= abecedario.charAt((posicion-desplazamiento)%abecedario.length());
                }
            }
            
        }
        return textoDecodificado;
    }
}
