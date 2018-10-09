package df;

public class Obj {
    String type;
    int a;
    double b;
    boolean c;
    long d;
    String e;

    public Obj(String val) {
        e = val;
        type = "String";
    }

    public Obj(int val) {
        a = val;
        type = "int";
    }

    public Obj(double val) {
        b = val;
        type = "double";
    }

    public Obj(boolean val) {
        c = val;
        type = "boolean";
    }

    public Obj(long val) {
        d = val;
        type = "long";
    }

    public void printObj() {
        switch (type) {
            case "String":
                System.out.print(e);
                break;
            case "int":
                System.out.print(a);
                break;
            case "double":
                System.out.print(b);
                break;
            case "boolean":
                System.out.print(c);
                break;
            case "long":
                System.out.print(d);
                break;
            default:
                System.out.print("Verу bаd error");
        }
    }
}