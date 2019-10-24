import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numPlayers;
        player pl1;




        System.out.println("Cuantos jugadores van a jugar?");
        numPlayers = sc.nextInt();
        String namePlayer[] = new String[numPlayers];
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
            System.out.println("El resultado es: "+((int)(Math.random()*5)+1));
        }
        System.out.println();

    }

    public void startGame(){

    }

}
