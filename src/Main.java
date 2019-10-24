import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int numPlayers;
    static String namePlayer[] = new String[numPlayers];
    static int randomNumbers[] = new int[numPlayers];
    static int maxNumber = randomNumbers[0];
    static String persona = namePlayer[0];

    public static void main(String[] args) throws IOException {
        System.out.println("Cuantos jugadores van a jugar?");
        numPlayers = sc.nextInt();

        for(int i=0;i<numPlayers;i++){
            System.out.println("Introduce el nombre del jugador "+(i+1));
            namePlayer[i] = sc.next();
        }
        System.out.println("Los jugadores son: ");
        for (int j=0; j<numPlayers; j++){
            System.out.println(namePlayer[j]);
        }

        for (int k=0; k<numPlayers; k++){
            System.out.print("\nLanza el dado "+namePlayer[k]+ "(Presiona Enter)");
            System.in.read();
            randomNumbers[k] = (int)(Math.random()*5+1);
            System.out.println("El resultado es: "+ randomNumbers[k]);
        }

        for(int a=0;a<numPlayers;a++){
            if (maxNumber<randomNumbers[a]){
                System.out.println("Unos valores se repiten");
                maxNumber = randomNumbers[a];
                persona = namePlayer[a];
            }
        }
        System.out.println("Numero maximo "+maxNumber+" persona: "+namePlayer.toString());
        
    }

    public static void startGame(){

    }

}
