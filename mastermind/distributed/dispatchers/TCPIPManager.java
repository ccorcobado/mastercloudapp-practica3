package mastermind.distributed.dispatchers;

import mastermind.utils.TCPIP;
import mastermind.types.Error;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIPManager extends TCPIP {
    
    private static final int PORT = 2020;

    public TCPIPManager(Socket socket) {
        super(socket);
    }

    public TCPIPManager(ServerSocket serverSocket, Socket socket) {
        super(serverSocket, socket);
    }

    public static TCPIPManager createClientSocket() {
        try {
            Socket socket = new Socket("localhost", TCPIPManager.PORT);
            System.out.println("Cliente> Establecida conexion");
            return new TCPIPManager(socket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TCPIPManager createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(TCPIPManager.PORT);
            System.out.println("Servidor> Esperando conexion...");
            Socket socket = serverSocket.accept();
            System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort());
            return new TCPIPManager(serverSocket, socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void send(Error error) {
        if (error == null) {
            this.send("null");
        } else {
            this.send(error.name());
        }
    }

    public Error receiveError() {
        String error = this.receiveLine();
        if (error.equals("null")) {
            return null;
        }
        return Error.valueOf(error);
    }

    public Integer receiveNumber() {
        String number = this.receiveLine();
        if (number.equals("null")) {
            return null;
        }
        
        return Integer.valueOf(number);
    }

    public void send(Integer number) {
        if (number == null) {
            this.send("null");
        } else {
            this.send(number);
        }
    }

    @Override
    public void close() {
        this.send(FrameType.CLOSE.name());
        super.close();
    }
}
