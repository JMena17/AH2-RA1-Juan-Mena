package clase01; // \ 
import java.util.Scanner;
import java.nio.file.FileSystemException;
public class Clase01 {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {       
        //inicio del juego 
        //boolean inicio = true;
        //while (inicio) {1}
        // Se crea jugador y las trampas (indicadores)
        char[][] player = new char[8][8];
        player[7][7] = '@';
        char[][] trampas = new char[8][8];
        trampas[7][7] = '#';
        int posicionPlayer = 0;
        // Funciones del juego 
        char p = 'p'; // Pausar juego
        char r = 'r'; // Tirar dado
        char f = 'f'; // Finalizar juego
        // Permite al usuario ingresar una opcion
        Scanner opt = new Scanner(System.in);
        System.out.println("====== Menu Principal ======");
        System.out.println("\n"+"Escoge una de las opciones");
        System.out.println("1: Iniciar juego");
        System.out.println("2: Renaudar juego"+"\n"+"3: Finalizar");
        int n = opt.nextInt();
        // Aqui se crea el menu para que el usuario pueda ingresar una de las 4 opciones
        // tambien se muestra el resultado de la opcion ingresada
        switch(n){
            case 1:
                System.out.println("============= Iniciar juego ============="+"\n");
                break;
            case 2:
                System.out.println("Renaudar juego"+"\n");
                break; 
            case 3:
                System.out.println("Has salido del juego.");
                System.exit(0);
                break; 
        }    
        // Tabla general
        int[][] tabla = new int[8][8];
        int num = 64;
        boolean inverso = true;
        //Creacion de penalizacion
        int castigo = (int)(Math.random()*(4-1)+1);
        int filaCastigo = (int)(Math.random()*(4-1)+1);
        int castigoTabla = tabla[7][7];
        
        for (int i = 0; i < tabla.length; i++) {
            if (inverso) {
                // Se crea tabla invertida
                // for inverso
                for (int j = tabla[i].length -1; j >= 0; j--) {
                    tabla[i][j] = num;
                    num--;
                }
                inverso = false;
            } else {
                for (int j = 0; j < tabla[i].length; j++){
                    tabla[i][j] = num;
                    num--;
                } inverso = true; 
            }
        }
        for (int i = 0; i < castigoTabla; i++) {
            int posicionCastigo = castigo;
            int castigoFila = filaCastigo;
            trampas[posicionCastigo][castigoFila] = '#';  
        }
        
        while(posicionPlayer <= 64) {
            // Se imprime tabla
            for (int i = 0; i < tabla.length; i++) {
                for (int j = 0; j < tabla[i].length; j++) {
                    System.out.print("|  "+tabla[i][j]);
            // Se agrega un espacio en la tabla si el numero es menor que 10 para tener la misma longitud
                    if(tabla[i][j] < 10) {
                        System.out.print(" ");
                    }
                }
            // se imprime tabla con jugador 
                System.out.println("|   ");
                for (int j = 0; j < player.length; j++) {
                    System.out.print("|   "+player[i][j]+trampas[i][j]);
                }
                System.out.println("\n"+"-----------------------------------------");
            } // se borra el espacio anterior del jugador
            for (int i = 0; i < player.length; i++) {
                for (int j = 0; j < tabla[i].length; j++) {
                    player[i][j] = ' ';
                }
            }
            // Menu de opciones
            System.out.println("\n"+"======= Escoge una de las opciones ======="+"\n");
            System.out.println("Presiona R para tirar el dado: ");
            System.out.println("Presiona P para pausar el juego: ");
            System.out.println("Presiona F para salir del juego: ");
            String palabra = opt.nextLine();
            int dado = (int)(Math.random()*(6-2)+2); // Generar un número aleatorio
            switch(palabra){
                case "r":
                    System.out.println(Integer.toString(dado));
                    System.out.println("Tu número es: "+dado);
                    posicionPlayer += dado;
                    int i = 0;
                    int j = 0;
                    if (player[i][j] >= tabla[0][7]) {
                        System.out.println("¡Felicidades! ¡Has ganado la partida!");
                    }
                    else if (posicionPlayer >= 56) {
                        player[0][ 7 - (posicionPlayer - 56)] = '@';
                        
                    } else if (posicionPlayer >= 48) {
                        player[1][7-(posicionPlayer - 48)] = '@';
                        
                    } else if (posicionPlayer >= 40) {
                        player[2][7 - (posicionPlayer - 40)] = '@';
                        
                    } else if (posicionPlayer >= 32) {
                        player[3][7 - (posicionPlayer - 32)] = '@';
                        
                    } else if (posicionPlayer >= 24) {
                        player[4][7 - (posicionPlayer - 24)] = '@';
                        
                    } else if (posicionPlayer >= 17) {
                        player[5][7 + (posicionPlayer - 17 )] = '@';
                        
                    } else if (posicionPlayer >= 8) {
                        player[6][posicionPlayer - 8] = '@';
                        
                    } else {
                        player[7][7 - posicionPlayer] = '@';
                    }                       
                    break;
                case "p":
                    System.out.println("El juego esta en pausa.");
                    System.console();
                    break;
                case "f":
                    System.out.println("Has salido del juego.");
                    System.exit(0);
                    break;
            } 
        }  
    }                   
}