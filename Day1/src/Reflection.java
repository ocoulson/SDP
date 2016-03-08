/**
 * Created by Oliver Coulson on 05/01/2016.
 */
public class Reflection {
    private int id;
    private String name;

    public Reflection(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayHi() {
        return "Hello " + name;
    }
}
