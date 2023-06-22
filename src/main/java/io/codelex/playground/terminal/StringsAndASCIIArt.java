package io.codelex.playground.terminal;

public class StringsAndASCIIArt {

    public static final String rootFileWelcome = """
            Welcome to N00bTerm!\s
            N00bTerm is a project in which I'm attempting to recreate a Unix shell-like simulation.\s
            While it won't mirror the original one-to-one, it's more of a gamified version of the Unix shell.\s
            The intention is to definitely include game-like structures and narratives similar to HackNet,\s
            program will exclusively reside within the 'terminal'; there will be no graphical user interface.\s
            For now I'm learning Java and all spaghetti code will be slowly 'hopefully' patched.\s
            """;

    protected static final String LOGO = """
            888b    888  .d8888b.   .d8888b.  888  88888888888                            \s
            8888b   888 d88P  Y88b d88P  Y88b 888      888                                \s
            88888b  888 888    888 888    888 888      888                                \s
            888Y88b 888 888    888 888    888 88888b.  888   .d88b.  888d888 88888b.d88b. \s
            888 Y88b888 888    888 888    888 888 "88b 888  d8P  Y8b 888P"   888 "888 "88b\s
            888  Y88888 888    888 888    888 888  888 888  88888888 888     888  888  888\s
            888   Y8888 Y88b  d88P Y88b  d88P 888 d88P 888  Y8b.     888     888  888  888\s
            888    Y888  "Y8888P"   "Y8888P"  88888P"  888   "Y8888  888     888  888  888\s
            """;

    protected static String getInfo() {
        String ls = "ls - Lists all the files and directories in the current directory.\n";
        String cd = "cd 'directory name' - Changes the current directory to the one specified.\n";
        String cd2 = "cd '..' - To move one directory up.\n";
        String mkdir = "mkdir 'directory name' - Creates new directory with specified name.\n";
        String rm = "rm 'file or directory name' - Deletes directory or file.\n";
        String touch = "touch 'file name' - Creates new text file with the specified name in the directory.\n";
        String nobvim = "nobvim 'file name' - Really bad text editor, but you get what you paid for.\n";
        String cat = "cat 'file name' - Prints contents of a specified file.\n";
        String clear = "clear - Clears terminal screen.\n";
        String connect = "connect 'server name' - Connects to different server";
        String logo = "logo - Shows you cool terminal logo :0\n";
        String exit = "exit() - Kills this sacred program, " +
                "as you watch it close it's bit eyes, one tear drop runs down... \n" +
                "'YOU MONSTER' program's children scream at you." +
                "'Don't you dare to use it' children say";
        return ls + cd + cd2 + mkdir + rm + touch + nobvim + touch + cat + clear + connect + logo + exit;
    }
}
