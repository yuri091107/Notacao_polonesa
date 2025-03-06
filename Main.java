
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite uma expressão\n");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.nextLine();
        
        System.out.println("o valor é: " + Logica.Numeros(resposta));
    }
}