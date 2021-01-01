import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    /**
     * Main da classe Servidor
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);

        int i = 0;
        while(true){
            Socket cliente = servidor.accept(); /* Socket que liga o cliente ao servidor */

            System.out.println("Ligou-se um cliente ao servidor.");

            Thread c = new Thread(new WorkThread(cliente)); /* Thread responsável pela execução daquilo que o cliente pretende, ao interagir com o servidor */
            c.start();
        }
    }
}
