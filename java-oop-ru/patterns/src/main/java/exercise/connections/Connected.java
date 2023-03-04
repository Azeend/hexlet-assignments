package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection tcp;

    public Connected(TcpConnection tcp) {
        this.tcp = tcp;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error. Already connected");
    }

    @Override
    public void disconnect() {
        TcpConnection c = this.tcp;
        c.setConnection(new Disconnected(c));
        System.out.println("Disconnected");
    }

    @Override
    public void write(String string) {
        System.out.println(string + " added");
    }
}
// END
