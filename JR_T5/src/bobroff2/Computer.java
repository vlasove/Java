package bobroff2;

public class Computer {
    private Keyboard keyboard;
    private Monitor monitor;
    private  Mouse mouse;

    public Computer(Keyboard keyBoard,Mouse mouse, Monitor monitor) {
        this.keyboard = keyBoard;
        this.monitor = monitor;
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
