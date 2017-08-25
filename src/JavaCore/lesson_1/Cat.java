package JavaCore.lesson_1;

public class Cat extends Animal {
    public Cat(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance){
        super(name, maxRunDistance, maxJumpHeight, maxSwimDistance);
        setType("Cat");
    }
}
