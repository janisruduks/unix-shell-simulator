package io.codelex.n00bterm.terminal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Folder extends FileSystemObject {

    private final Map<String, FileSystemObject> children;
    private Folder parent;

    public Folder(String name, Folder parent) {
        super(name);
        this.children = new HashMap<>();
        this.parent = parent;
    }

    public Folder(String name) {
        super(name);
        this.children = new HashMap<>();
    }

    public void add(FileSystemObject file) {
        this.children.put(file.getName(), file);
    }

    public FileSystemObject getFileSystemObject(String name) {
        return this.children.get(name);
    }

    public Optional<File> getFile(String fileName) {
        FileSystemObject target = children.get(fileName);
        if (target instanceof File) {
            return Optional.of(((File) target));
        }
        return Optional.empty();
    }

    public Folder getParent() {
        return parent;
    }

    public boolean doesFileExist(String name) {
        return this.children.containsKey(name);
    }

    public void list() {
        for (String name : this.children.keySet()) {
            FileSystemObject object = this.children.get(name);
            if (object instanceof File) {
                System.out.println(name);
            } else if (object instanceof Folder) {
                System.out.println("/" + name);
            }
        }
    }


    public void delete(String name) {
        this.children.remove(name);
    }
}
