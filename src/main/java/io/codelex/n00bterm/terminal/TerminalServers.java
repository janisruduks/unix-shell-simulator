package io.codelex.n00bterm.terminal;

import java.util.HashMap;

public class TerminalServers {

    private final HashMap<String, Terminal> terminalList;
    private Terminal rootTerminal;
    private Terminal serverConnectedTo;

    public TerminalServers(HashMap<String, Terminal> terminalList, Terminal rootTerminal) {
        this.terminalList = terminalList;
        this.rootTerminal = rootTerminal;
        this.serverConnectedTo = rootTerminal;
    }

    public void connectToDifferentServer(String serverName) {
        Terminal target = terminalList.get(serverName);
        if (target == null) {
            prettifyConnection(serverName, false, 5);
        } else {
            prettifyConnection(serverName, true, 10);
            serverConnectedTo = target;
            rootTerminal = target;
        }

    }

    public Terminal getServerConnectedTo() {
        return serverConnectedTo;
    }

    public Terminal getRootTerminal() {
        return rootTerminal;
    }

    public void prettifyConnection(String serverName, boolean validServer, int delay) {

        String connectionMessage;
        if (validServer) {
            connectionMessage = "Connected to " + serverName;
        } else {
            connectionMessage = "Failed to connect to " + serverName;
        }

        for (int i = 0; i < delay; i++) {
            System.out.print("█");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        System.out.println(connectionMessage);
    }
}
