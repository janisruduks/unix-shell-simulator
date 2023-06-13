package io.codelex.n00bterm.terminal;

import java.util.Optional;
import java.util.Scanner;

public class Terminal {

    private final String serverName;
    private final String rootFolderName;
    private Folder currentFolder;
    private StringBuilder path;

    public Terminal(String serverName, Folder rootFolder, String rootFolderName) {
        this.serverName = serverName;
        this.currentFolder = rootFolder;
        this.rootFolderName = rootFolderName;
        this.path = new StringBuilder("/" + rootFolderName);
    }

    public String getPath() {
        return path.toString();
    }

    public void cd(String name) {
        if (name.equals("..")) {
            if (currentFolder.getParent() != null) {
                currentFolder = currentFolder.getParent();
                path = new StringBuilder(removePath(path));
            }
        } else {
            FileSystemObject target = currentFolder.getFileSystemObject(name);
            if (target instanceof Folder) {
                currentFolder = (Folder) target;
                path.append("/").append(target.getName());
            } else {
                System.out.println("Invalid directory");
            }
        }
    }

    public void touch(String name) {
        File file = new File(name);
        currentFolder.add(file);
    }

    public Optional<File> getFile(String fileName) {
        return currentFolder.getFile(fileName);
    }

    public void textEditor(String fileName, Scanner keyboard) {
        Optional<File> optionalFile = getFile(fileName);
        if (optionalFile.isEmpty()) {
            System.out.println("No such file exits...");
        } else {
            optionalFile.get().writeContent(keyboard);
        }
    }

    public void rm(String fileName) {
        currentFolder.delete(fileName);
    }

    public void mkdir(String name) {
        Folder folder = new Folder(name, currentFolder);
        currentFolder.add(folder);
    }

    public void ls() {
        this.currentFolder.list();
    }

    public void cat(String name) {
        if (currentFolder.doesFileExist(name)) {
            System.out.println(currentFolder.getFileSystemObject(name).getContent());
        } else {
            System.out.println("Couldn't find file with name: " + name);
        }
    }

    public String getServerName() {
        return this.serverName;
    }

    public void printAllCommands() {
        System.out.println(StringsAndASCIIArt.getInfo());
    }

    private String removePath(StringBuilder path) {

        String[] newPath = path.toString().split("/");
        path = new StringBuilder("/");

        for (int i = 1; i < newPath.length - 1; i++) {
            path.append(newPath[i]);
            if (i < newPath.length - 2) {
                path.append("/");
            }
        }
        return path.toString();
    }

    public void printLogo() {
        System.out.println(StringsAndASCIIArt.LOGO);
    }

    public void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
