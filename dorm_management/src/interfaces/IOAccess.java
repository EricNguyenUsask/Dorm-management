package interfaces;

public class IOAccess {
    private static InputOutputInterface io;

    private IOAccess() {
    }

    public static InputOutputInterface getInstance() {
        if (io == null) {

        }
        return io;
    }
}
