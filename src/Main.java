import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int numPlayers;
    static int apuesta;
    static int dice;


    public static void main(String[] args) throws IOException {
        startGame();
    }

    public static void startGame() throws IOException{
        System.out.println("Cuantos jugadores van a jugar?");
        numPlayers = sc.nextInt();

        String namePlayer[] = new String[numPlayers]; // Numero de personas

        player arrayPlayers[] = new player[numPlayers]; // Numero de personas (objeto)
        for(int i=0;i<numPlayers;i++){
            //player p = new player();

            System.out.println("Introduce el nombre del jugador: "+(i+1));
            String nombre = sc.next();
            System.out.println("Ingrese la cantidad que tiene: ");
            int money = sc.nextInt();
            arrayPlayers[i] = new player(nombre,money);
            //namePlayer[i] = sc.next();
        }

        /**
         * Listado de los jugadores disponibles
         */
        System.out.println("Los jugadores son: ");
        for (int j=0; j<numPlayers; j++){
            System.out.println("Jugador "+(j+1)+": "+arrayPlayers[j].getNombre()+" Dinero: $"+arrayPlayers[j].getDinero());
            //System.out.println("Jugador "+(j+1)+": "+namePlayer[j]);
        }


        int randomNumbers[] = new int[numPlayers]; //Numeros aleatorios

        for (int k=0; k<numPlayers; k++){// Lanzamiento de dado
            System.out.println("Lanza el dado "+arrayPlayers[k].getNombre()+ "(Presiona Enter)");
            System.in.read();
            dice = (int)(Math.random()*(5+1)+1);

            System.out.println("Primer lanzamiento: "+dice);
                System.out.println("Vuelve a lanzar el dado");
                System.in.read();
                randomNumbers[k] = (int)(Math.random()*(5+1)+1);

                if(randomNumbers[k] > dice){
                    System.out.println("Ganaste! Recoge una moneda");
                    arrayPlayers[k].setDinero(arrayPlayers[k].getDinero()+1);
                    System.out.println("El dinero de "+arrayPlayers[k].getNombre()+" es de: "+arrayPlayers[k].getDinero());
                } else {
                    System.out.println("Perdiste, entrega una moneda");
                    arrayPlayers[k].setDinero(arrayPlayers[k].getDinero()-1);
                    System.out.println("El dinero de "+arrayPlayers[k].getNombre()+" es de: "+arrayPlayers[k].getDinero());
                }
                System.out.println("El resultado es: "+ randomNumbers[k]+"\n");
        }

        do {

        }while (apuesta > 0);

        int maxNumber = 0;//randomNumbers[0];
        String persona = namePlayer[0];
        int valormaximo[] = new int [numPlayers]; //Se introducen los valores maximos
        /*for(int a=0; a<randomNumbers.length; a++){
            if(maxNumber<randomNumbers[a]){
                maxNumber = randomNumbers[a];
                persona = namePlayer[a];
            }
                if(maxNumber==randomNumbers[a]){
                    System.out.println("MaxNumber = "+maxNumber+" RNb["+a+"] = "+randomNumbers[a]);
                    if(maxNumber==0){
                        break;
                    } else {
                        valormaximo[a] = maxNumber;
                    }
                }
        }
        for(int c=0; c<valormaximo.length;c++){
            System.out.println("Longitud: "+valormaximo.length+": "+valormaximo[c]);
        }*/


        System.out.println("\nEmpieza a tirar el jugador: "+persona+" Numero maximo "+maxNumber+" persona: "+persona);
    }
}
