package JavaCore.lesson_1;

public class Cross extends Obstacle {
    int length;
    public Cross(int length){
        this.length = length;
    }
    @Override
    public void doIt(Animal a){
        a.run(this.length);
    }
}
