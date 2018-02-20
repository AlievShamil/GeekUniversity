package java_core_advanced.lesson_1;

public class Water extends Obstacle {
    int length;
    public Water(int length){
        this.length = length;
    }
    @Override
    public void doIt(Animal a){
        a.swim(this.length);
    }
}