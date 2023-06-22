package io.codelex.playground.terminal;

abstract class FileSystemObject {

    protected String name;
    protected String content;

    public FileSystemObject(String name) {
        this.name = name;
    }

    public FileSystemObject(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
