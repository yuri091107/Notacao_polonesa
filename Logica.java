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
            
            
         /* Use a lógica do parêntese somente se for necessário, mas para isso deverá trocar o Queue */   
            
        //  else if(valor == '(') {
        //         pilha.add('(');
        //     }
        //     else if(valor == ')') {
        //         while(!pilha.isEmpty() && pilha.peek() != '(') {
        //             resposta+=pilha.poll();
        //         }
        //         if(!pilha.isEmpty()) {
        //             resposta+=pilha.poll();
        //         }
        //     }
            
            else {
                while(!pilha.isEmpty() && Prioridade(valor) == 1) {
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
