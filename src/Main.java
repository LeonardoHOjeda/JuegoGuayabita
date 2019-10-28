import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int numPlayers;
    static int apuesta = 0;
    static int dice;
    static int respuestaDice;


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
        showPlayers(arrayPlayers);

        /**
         * Se empieza a apostar
         */
        apuestaGeneral(arrayPlayers);

        /**
         * Empieza el juego lanzando el dado
         */
        do {
            lanzarDado(arrayPlayers);
        }while (apuesta > 0);
        System.out.println("El juego ha terminado!");

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


        //System.out.println("\nEmpieza a tirar el jugador: "+persona+" Numero maximo "+maxNumber+" persona: "+persona);
    }

    public static void apuestaGeneral(player arrayPlayer[]){
        System.out.println("\nTODOS LOS JUGADORES APUESTAN!");
        for (int i=0; i<arrayPlayer.length; i++){
            System.out.print(arrayPlayer[i].getNombre() + " ya puso su dinero!");
            arrayPlayer[i].setDinero(arrayPlayer[i].getDinero()-1);
            System.out.println("\tDinero actual: "+arrayPlayer[i].getDinero());
            apuesta++;
        }
    }

    public static void lanzarDado(player arrayPlayers[]) throws IOException {
        int randomNumbers[] = new int[numPlayers]; //Numeros aleatorios
        int pivote = 0;

        for (int k=0; k<numPlayers; k++){// Lanzamiento de dado
            System.out.print("\nLanza el dado "+arrayPlayers[k].getNombre()+ "(Presiona Enter) **APUESTA $"+apuesta+"** **DINERO $"+arrayPlayers[k].getDinero()+"**");
            System.in.read();
            dice = (int)(Math.random()*(5+1)+1);

            System.out.println("Primer lanzamiento: "+dice);
            System.out.println("Que quieres hacer?");
            System.out.println("1) Ir por la apuesta!");
            System.out.println("2) Ir por TODOOO!");
            respuestaDice = sc.nextInt();
            switch (respuestaDice){
                case 1:
                    if(arrayPlayers[k].getDinero() >= 1){
                        System.out.println("Elegiste apuesta!");
                        System.out.print("Vuelve a lanzar el dado!");
                        System.in.read();
                        randomNumbers[k] = (int)(Math.random()*(5+1)+1);
                        System.out.println("Segundo lanzamiento: "+ randomNumbers[k]+"\n");
                        if(randomNumbers[k] > dice){
                            System.out.println("Ganaste! Recoge una moneda");
                            arrayPlayers[k].setDinero(arrayPlayers[k].getDinero()+1);
                            apuesta--;
                            System.out.println("El dinero de "+arrayPlayers[k].getNombre()+" es de: "+arrayPlayers[k].getDinero());
                        } else {
                            System.out.println("Perdiste, entrega una moneda");
                            arrayPlayers[k].setDinero(arrayPlayers[k].getDinero()-1);
                            apuesta++;
                            System.out.println("El dinero de "+arrayPlayers[k].getNombre()+" es de: "+arrayPlayers[k].getDinero());
                        }
                    } else{
                        System.out.println("Lo sentimos, no tienes fondos suficientes para realizar esta accion");
                        break;
                    }
                    break;
                case 2:
                    if (arrayPlayers[k].getDinero() >= apuesta){
                        System.out.println("*********ELEGISTE TODO!!********");
                        System.out.print("Vuelve a lanzar el dado!");
                        System.in.read();
                        randomNumbers[k] = (int)(Math.random()*(5+1)+1);
                        System.out.println("Segundo lanzamiento: "+ randomNumbers[k]+"\n");
                        if(randomNumbers[k] > dice){
                            System.out.println("Ganaste! Recoge todas las monedas!");
                            arrayPlayers[k].setDinero(arrayPlayers[k].getDinero() + apuesta);
                            apuesta -= apuesta;
                            System.out.println("El dinero de "+arrayPlayers[k].getNombre()+" es de: "+arrayPlayers[k].getDinero());
                        } else {
                            System.out.println("Perdiste, entrega "+apuesta+" monedas");
                            pivote = arrayPlayers[k].getDinero();
                            arrayPlayers[k].setDinero(arrayPlayers[k].getDinero()-apuesta);
                            apuesta += apuesta;
                            System.out.println("El dinero de "+arrayPlayers[k].getNombre()+" es de: "+arrayPlayers[k].getDinero());
                        }
                    } else {
                        System.out.println("Lo sentimos, no tienes fondos suficientes para realizar esta accion");
                        break;
                    }
                    break;
                default:
                    System.out.println("Esa opcion no existe");
            }
            System.out.println("Dinero actual de la apuesta: $"+apuesta);

        }
    }

    public static void showPlayers(player arrayPlayers[]){
        System.out.println("Los jugadores son: ");
        for (int j=0; j<numPlayers; j++){
            System.out.println("Jugador "+(j+1)+": "+arrayPlayers[j].getNombre()+" Dinero: $"+arrayPlayers[j].getDinero());
        }
    }
}

// Comentario de prueba 2 en main... por SanxgoStarck
