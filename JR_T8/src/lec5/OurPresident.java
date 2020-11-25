package lec5;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }

    }

    public static synchronized OurPresident getOurPresident() {
        return president;
    }
}
