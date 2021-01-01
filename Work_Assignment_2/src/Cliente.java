import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Cliente {
    protected final Socket socket_cliente;
    protected DataInputStream in;
    protected DataOutputStream out;

    final int OK = 100;
    /**
     * Método construtor
     * @param host      do socket do cliente
     * @param port      do socket do cliente
     * @throws IOException
     */
    public Cliente(String host, int port) throws IOException{
        this.socket_cliente = new Socket(host, port);
        this.out = new DataOutputStream(socket_cliente.getOutputStream());
        this.in = new DataInputStream(socket_cliente.getInputStream());
    }

    /**
     * Disconecta o cliente do servidor
     * @throws IOException
     */
    public void disconnect() throws IOException{
        this.out.close();
        this.in.close();
        this.socket_cliente.close();
    }

    /**
     * Teste
     * @throws IOException
     */
    public void teste() throws IOException{
        this.out.writeUTF("Welelelele");
        this.out.flush();
    }

    /**
     * Main da classe Cliente
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        try {
            Cliente c = new Cliente("127.0.0.1", 1234); /* Trata da interligação da interface com os comandos executados pelo utilizador, comunicando estes com o sevidor */

            while (true){
                try {
                    c.teste();
                    c.disconnect();
                }catch (IOException e){
                    c.disconnect();
                    return;
                }
            }
        }catch (ConnectException e){
            System.err.println("O servidor não se encontra conectável.");
        }
    }
}
