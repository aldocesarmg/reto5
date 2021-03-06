
package reto5;

import java.util.Scanner;

public class RETO5 {
    
    public static void main(String[] args) {
        String respuesta, valor;
        Scanner sc = new Scanner(System.in);
        mostrarMenu();
        
        do{
            System.out.println("Tipo de conversión?");
            respuesta = sc.next();
            System.out.println("Número a convertir?");
            valor = sc.next();
            switch(respuesta){
                case "A":
                case "a":
                    System.out.println("El número "+valor+ " en base binario es: ");
                    decimalBinario(Integer.parseInt(valor));
                    break;
                case "B":
                case "b":
                    System.out.println("El número "+valor+ " en base cotal es: ");
                    decimalOctal(Integer.parseInt(valor));
                    break;
                case "C":
                case "c":
                    System.out.println("El número "+valor+" en base hexadecimal es: ");
                    decimalHexadecimal(Integer.parseInt(valor));
                    break;
                case "D":
                case "d":
                    System.out.println("El número binario "+valor+" en base decimal es: ");
                    binarioDecimal(valor);
                    break;
                case "E":
                case "e":
                    System.out.println("El número octal "+valor+" en base decimal es: ");
                    octalDecimal(valor);
                    break;
                case "F":
                case "f":
                    System.out.println("El número hexadecimal "+valor+" en base decimal es: ");
                    hexadecimalDecimal(valor);
                    break;
            }
            System.out.println("Otra conversión? S/N");
            respuesta = sc.next();
        }while(respuesta.equals("s")||respuesta.equals("S"));
    }
    
    public static void mostrarMenu(){
        System.out.println("** PROGRAMA DE CONVERSIONES **");
        System.out.println("Opción A: Convertir de decimal a binario");
        System.out.println("Opción B: Convertir de decimal a octal");
        System.out.println("Opción C: Convertir de decimal a hexadecimal");
        System.out.println("Opción D: Convertir de binario a decimal");
        System.out.println("Opción E: Convertir de octal a decimal");
        System.out.println("Opción F: Convertir de hexadecimal a decimal");
    }
    
    public static void decimalBinario(int numero){
        int n = 0;
        double resultado = 0; 
        if(numero<0){
            System.out.println("Este programa solo calcula valores positivos. Lo sentimos.");
        }else if(numero==0){
            System.out.println("0");
        }else{
        while(resultado<numero){
            n++;
            resultado = Math.pow(2,n);
        }
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
        System.out.println("");
    }
    
    public static void decimalOctal(int numero){
        int sobrante[] = new int[100];
        if(numero<0){
            System.out.println("Número no válido.");
            return;
        }else if(numero==0){
            System.out.println("0");
            return;
        }
        for (int i = 0; numero>0;i++){
            sobrante[i] = (numero % 8);
            numero /= 8;
        }
        for (int r = 99; r>=0;r--){
            if(sobrante[r]!=0){
                System.out.print(sobrante[r]);
            }
        }
        System.out.println("");
    }
    
    public static void decimalHexadecimal(int numero){
        String sobrante[] = new String[100];
        String valoresHex[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        for (int i = 0; numero>0;i++){
            sobrante[i] = Integer.toString(numero % 16);
            numero /= 16;
            sobrante[i] = valoresHex[Integer.parseInt(sobrante[i])-1];
        }
        for (int r = 99; r>=0;r--){
            if(sobrante[r] != null){
                System.out.print(sobrante[r]);
            }
        }
        if(numero<0){
            System.out.println("Número no válido.");
        }else if(numero==0){
            System.out.println("0");
        }
    }
    
    public static void binarioDecimal(String numero){
        String temp;
        for(int i = 0; numero.length()>i; i++){
            temp = String.valueOf(numero.charAt(i));
            if(temp.equals("0")||temp.equals("1")){
            }else{
                System.out.println("Solamente puede escribir unos o ceros");
                return;
            }
        }
        double elevado = 0, resultado = 0, n = 0;
        for(int i = numero.length(); i>0; i--){
            temp = String.valueOf(numero.charAt(i-1));
            switch (temp) {
                case "1":
                    elevado = Math.pow(2, n);
                    resultado += elevado;
                    break;
            }
            n += 1;
        }
        System.out.println(resultado);
    }
    
    public static void octalDecimal(String numero){
        if (Integer.parseInt(numero)<0){
            System.out.println("Número no válido");
            return;
        }
        int resultado = 0;
        String temp;
        double n = numero.length()-1;
        for(int i = 0; numero.length()>i; i++){
                temp = String.valueOf(numero.charAt(i));
                resultado += Integer.parseInt(temp)*Math.pow(8, n);
                n--;
            }
        System.out.println(resultado);
    }
    
    public static void hexadecimalDecimal(String numero){
        String numeroDec[] = new String[50];
        String valorHex[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String temp;
        int resultado = 0;
        double n = numero.length()-1;
        for(int i = 0; numero.length()>i; i++){ //DEFINE CUANTAS VECES SE REPETIRÁ EL FOR
            temp = String.valueOf(numero.charAt(i));
            for(int r = 0; valorHex.length > r; r++){ //RECORRE EL ARREGLO valorHex[] EN BUSCA DEL NUMERO EQUIVALENTE
                if(temp.equals(valorHex[r])){
                    numeroDec[i] = String.valueOf(r);
                }else{
                    System.out.println("Número no válido. Lo sentimos."); //SI SE INTRODUCE UN NÚMERO DISTINTO A HEXADECIMAL, SE SALE
                    return;
                }
            }
            resultado += Integer.parseInt(numeroDec[i])*(Math.pow(16, n)); //MULTIPLICA EL NÚMERO CONVERTIDO POR 16 A LA n Y LO SUMA A RESULTADO
            System.out.println(resultado);
            n--;
        }
    }
}
