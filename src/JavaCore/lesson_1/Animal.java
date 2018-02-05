package JavaCore.lesson_1;

public class Animal implements Challengeable {
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;
    private boolean onDistance;

    private String type;
    private String name;

    public Animal(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance){
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }
    @Override
    public void run(int distance){
        if(distance <= this.maxRunDistance){
            System.out.println(this.type + " " + this.name + " пробежал дистанцию");
        }else {
            this.onDistance = false;
            System.out.println(this.type + " " + this.name + " не пробежал дистанцию");
        }
    }
    @Override
    public void jump(int height){
        if(height <= this.maxJumpHeight){
            System.out.println(this.type + " " + this.name + " перепрыгнул препятствие");
        }else {
            this.onDistance = false;
            System.out.println(this.type + " " + this.name + " не перепрыгнул препятствие");
        }
    }
    @Override
    public void swim(int distance){
        if(this.maxSwimDistance == 0){
            System.out.println(this.type + " " + this.name + " не умеет плавать");
            this.onDistance = false;
        }else if(distance <= this.maxSwimDistance){
            System.out.println(this.type + " " + this.name + " проплыл дистанцию");
        }else {
            this.onDistance = false;
            System.out.println(this.type + " " + this.name + " не проплыл дистанцию");
        }
    }
    @Override
    public void printResult(){
        if(onDistance) System.out.println(this.type + " " + this.name + " прошел дистанцию");
        else System.out.println(this.type + " " + this.name + " не прошел дистанцию");
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }
}
