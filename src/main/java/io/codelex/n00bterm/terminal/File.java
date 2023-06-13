package io.codelex.n00bterm.terminal;

import java.util.Scanner;

public class File extends FileSystemObject {

    public File(String name) {
        super(name + ".txt");
    }

    public File(String name, String content) {
        super(name + ".txt", content);
    }

    public void writeContent(Scanner keyboard) {

        StringBuilder text = new StringBuilder();
        System.out.println("Welcome to N00bVim, type ':exit' on new line to exit");

        while (true) {
            String line = keyboard.nextLine();
            if (line.trim().equals(":exit")) {
                break;
            }
            text.append(line);
            text.append(System.lineSeparator());
        }
        content = text.toString();
    }
}
