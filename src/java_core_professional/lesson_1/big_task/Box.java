package java_core_professional.lesson_1.big_task;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> list;

    public Box(T... list) {
        this.list = new ArrayList<>(Arrays.asList(list));
    }

    private float getWeight() {
        if(list.size()==0) return 0;
        return list.get(0).getWeight()*list.size();
    }

    public boolean compare(Box box) {
        return Math.abs(getWeight()-box.getWeight())<0.0001f;
    }

    public void transferFruit(Box<? super T> box) {
        box.list.addAll(list);
        list.clear();
    }
}
