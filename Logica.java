import java.util.PriorityQueue;
import java.util.Queue;

public class Logica {
   public static int Prioridade(char x) {
        if(x == '*' || x == '/') {
            return 1;
        }
        else if (x=='+' || x == '-') {
            return 0;
        }
        return -1;
    }
    public static String Numeros(String expressao) {
        String resposta = "";
        @SuppressWarnings("Convert2Diamond")
        Queue<Character> pilha = new PriorityQueue<Character>();
        int transforma_char = expressao.length();

        for(int i=0; i < transforma_char; i++) {
            char valor = expressao.charAt(i);

            if(valor >= '0' && valor <= '9') {
                resposta+=valor;
            }
            
            else {
                while(!pilha.isEmpty() && Prioridade(pilha.peek()) >= Prioridade(valor)) {
                    resposta+=pilha.poll();
                }
                pilha.add(valor);
            }
        }
        while(!pilha.isEmpty()) {
            resposta+=pilha.poll();
        }
        return resposta;   
    } 
}
