
package reto5;

import java.util.Scanner;

public class RETO5 {
    
    public static void main(String[] args) {
        int valor = 0;
        //peticionDeDatos();
        
        //decimalBinario(valor);
        decimalOctal(valor);
        
    }
    
    public static void peticionDeDatos(){
        Scanner sc = new Scanner(System.in);
        String valor;
        System.out.println("** PROGRAMA DE CONVERSIONES **");
        System.out.println("Opción A: Convertir de decimal a binario");
        System.out.println("Opción B: Convertir de decimal a octal");
        System.out.println("Opción C: Convertir de decimal a hexadecimal");
        System.out.println("Opción D: Convertir de binario a decimal");
        System.out.println("Opción E: Convertir de octal a decimal");
        System.out.println("Opción F: Convertir de hexadecimal a decimal");
        
        System.out.println("¿Qué opción desea realizar?");
        valor = sc.next();
    }
    
    public static void decimalBinario(int numero){
        int n = 0;
        double resultado = 0; 
        while(resultado<numero){
            n++;
            resultado = Math.pow(2,n);
        }
        
        //System.out.println(n);
        
        System.out.print("Su valor binario es: ");
        
        while(n>0){
            n--;
            resultado = Math.pow(2,n);
            if(resultado<=numero){
                System.out.print("1");
                numero -= resultado;
            }else{
                System.out.print("0");
            }
        }
                
    }
    
    public static void decimalOctal(int numero){
        int sobrante[] = new int[100];
        
        for (int i = 0; numero>0;i++){
            sobrante[i] = (numero % 8);
            numero /= 8;
        }
        for (int r = 99; r>=0;r--){
            if(sobrante[r]!=0){
                System.out.print(sobrante[r]);
            }
        }
        if(numero<0){
            System.out.println("Número no válido.");
        }else if(numero==0){
            System.out.println("0");
        }
    }
}
