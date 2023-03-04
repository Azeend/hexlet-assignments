package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcp;

    public Disconnected(TcpConnection tcp) {
        this.tcp = tcp;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        TcpConnection c = this.tcp;
        c.setConnection(new Connected(c));
        System.out.println("Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error.Already disconnected");
    }

    @Override
    public void write(String string) {
        System.out.println("Error.No connection");
    }
}
// END
