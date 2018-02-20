package java_core_advanced.lesson_1;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new Obstacle[]{
                new Cross(500),
                new Wall(400),
                new Water(500)
        });


        Team teamA = new Team("Собака и 3 кота", new Animal[]{
                new Dog("BullDog", 1750, 1380, 1536),
                new Cat("Васька", 750, 380, 0),
                new Cat("Мурка", 645, 425, 0),
                new Cat("Шнурок", 870, 512, 0),
        });

        Team teamB = new Team("Кот и 3 пса", new Animal[]{
                new Dog("Матро́скин", 580, 280, 0),
                new Cat("Шарик", 960, 674, 621),
                new Cat("Полкан", 1432, 987, 756),
                new Cat("Мухтар", 1241, 1120, 2874),
        });

        course.doIt(teamA);
        course.doIt(teamB);

        teamA.showResults();
//        teamA.allMemberInfo();

        teamB.showResults();
//        teamB.allMemberInfo();

    }
}