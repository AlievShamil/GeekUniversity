package java_core_advanced.lesson_1;

public class Wall extends Obstacle {
    int height;
    public Wall(int height){
        this.height = height;
    }
    @Override
    public void doIt(Animal a){
        a.jump(this.height);
    }
}
