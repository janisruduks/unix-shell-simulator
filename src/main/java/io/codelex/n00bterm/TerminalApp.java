package io.codelex.n00bterm;

import io.codelex.n00bterm.sound.BackgroundSound;
import io.codelex.n00bterm.terminal.*;

import java.util.HashMap;
import java.util.Scanner;

public class TerminalApp {

    //TODO maybe try to fix nobvim so it displays old content or something.
    //TODO Implement colors is a must!
    //TODO Add different types of files. (idk for what reason)
    //TODO split help section into parts?

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String rootFolderName = "root";
        Folder rootFolder = new Folder(rootFolderName);
        File rootFile = new File("info", StringsAndASCIIArt.rootFileWelcome);
        rootFolder.add(rootFile);
        Terminal rootTerminal = new Terminal("MyPC", rootFolder, rootFolderName);

        String SSECRootFolderName = "ssec";
        Folder SSECRootFolder = new Folder(SSECRootFolderName);
        File SSECFile = new File("info", "Hello world!");
        SSECRootFolder.add(SSECFile);
        Terminal SSECTerminal = new Terminal("SSEC", SSECRootFolder, SSECRootFolderName);

        HashMap<String, Terminal> serverList = new HashMap<>();
        serverList.put("root", rootTerminal);
        serverList.put("SSEC", SSECTerminal);

        TerminalServers allServers = new TerminalServers(serverList, rootTerminal);

        rootTerminal.printLogo();

        BackgroundSound sound = new BackgroundSound();

        while (true) {
            System.out.print(allServers.getRootTerminal().getPath() + "$ ");
            commands(keyboard, allServers, sound);
        }
    }

    private static void commands(Scanner keyboard, TerminalServers servers, BackgroundSound music) {

        switch (keyboard.next()) {
            case "help" -> servers.getServerConnectedTo().printAllCommands();
            case "cd" -> servers.getServerConnectedTo().cd(keyboard.next());
            case "mkdir" -> servers.getServerConnectedTo().mkdir(keyboard.next());
            case "rm" -> servers.getServerConnectedTo().rm(keyboard.next());
            case "touch" -> servers.getServerConnectedTo().touch(keyboard.next());
            case "nobvim" -> servers.getServerConnectedTo().textEditor(keyboard.next(), keyboard);
            case "ls" -> servers.getServerConnectedTo().ls();
            case "cat" -> servers.getServerConnectedTo().cat(keyboard.next());
            case "clear" -> servers.getServerConnectedTo().clear(); // ugly way to clear terminal
            case "connect" -> servers.connectToDifferentServer(keyboard.next());
            case "logo" -> servers.getServerConnectedTo().printLogo();
            case "play-music" -> music.playSound();
            case "exit()" -> System.exit(0);
            default -> System.out.println("Sorry I did not get that... Try using 'help'");
        }
    }
}