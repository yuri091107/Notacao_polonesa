import java.util.Stack;

public class Logica {
   public static int Prioridade(char x) {
        if(x == '*' || x == '/') {  //colocando prioridades nos operadores;
            return 1;
        }
        else if (x=='+' || x == '-') {
            return 0;
        }
        return -1;
    }
    public static String Numeros(String expressao) {
        String resposta = "";
        Stack<Character> pilha = new Stack<>();
        int transforma_char = expressao.length();

        for(int i=0; i < transforma_char; i++) {
            char valor = expressao.charAt(i);

            if(valor >= '0' && valor <= '9') {
                resposta+=valor; //atribuindo os numeros (operantes) na resposta;
            }
            
            
         /* Use a lógica do parêntese somente se for necessário, mas para isso deverá trocar o Queue */   
            
        //  else if(valor == '(') {
        //         pilha.add('(');
        //     }
        //     else if(valor == ')') {
        //         while(!pilha.isEmpty() && pilha.peek() != '(') {
        //             resposta+=pilha.pop();
        //         }
        //         if(!pilha.isEmpty()) {
        //             resposta+=pilha.pop();
        //         }
        //     }
            
            else {
                while(!pilha.isEmpty() && Prioridade(pilha.peek()) == 1) {
                    // System.out.println("operador no topo " + Prioridade(pilha.peek()));
                    resposta+=pilha.pop(); //alego que a pilha contém elementos (mesmo eu não tendo adicionando algum, devido fato de ela poder acessar elementos presentes em armazenamentos, ela consegue fazer o mesmo papel dentro do método de Prioridade, ele vai verificar os valores de X, aquele que estiver = 1, ele vai descer e atribuir ao resultado)
                
                }
                
                if(pilha.isEmpty()) {
                    pilha.add(valor); //O operador atual é empilhado, enquanto os operadores de maior prioridade já foram desempilhados.
                }
                // System.out.println("operador no topo atualmente " + Prioridade(pilha.peek()));
            }
        }
        
        while(!pilha.isEmpty() && Prioridade(pilha.peek()) == 0) {
            resposta+=pilha.pop();  //os removendo e atribuindo na respostas
        }
        
        
        // while(!pilha.isEmpty()) {
        //     resposta+=pilha.pop(); //os removendo e atribuindo na respostas
        // }

        return resposta;   
    } 
}
