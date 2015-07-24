/**
 * Created by admin on 24.07.2015.
 */
public class Test {
    private final String separator = java.io.File.separator;
    private String currentPath;
    private boolean modifiable = true;

    public Test(String path) {
        currentPath = path + separator;
    }

    public static void main(String[] args) {
        Test test = new Test("C:");
        test.folder("program files")
                .folder("adobe reader")
                .folder("profile")
                .folder("configuration")
                .file("user.config");
        System.out.println(test.toString());
    }

    public Test folder(String folderName) {
        if (modifiable)
            currentPath += folderName + separator;
        return this;
    }

    public Test file(String fileName) {
        if (modifiable)
            currentPath += fileName;
        modifiable = false;
        return this;
    }

    public java.io.File toFile() {
        return new java.io.File(currentPath);
    }

    @Override
    public String toString() { return currentPath; }
}
