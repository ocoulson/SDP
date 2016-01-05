import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver Coulson on 05/01/2016.
 */
public class Test {

    public static void main(String[] args) {
//        List<Lion> enclosure = new ArrayList<>();
//        enclosure.add(new Lion(12));
//        enclosure.add(new Lion(18));

        List<Animal> zoo  = new ArrayList<>();

        zoo.add(new Lion(14));
        zoo.add(new Zebra(12));



    }

    public static <A extends Comparable<? super A>> void sort(List<A> list) {
        throw new NotImplementedException();
    }


}

class Animal implements Comparable<Animal>{
    private Integer age;

    @Override
    public int compareTo(Animal o) {
        return age.compareTo(o.age);
    }
}
class Lion extends Animal { // implements Comparable<Lion> {
    private Integer age;

    public Lion(int age) {
        this.age = age;
    }

}

class Zebra extends Animal { //implements Comparable<Zebra> {
    private Integer age;

    public Zebra(Integer age) {
        this.age = age;
    }

}