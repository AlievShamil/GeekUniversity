package JavaCore.lesson_1;

import static java.lang.String.format;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Animal animal : team.getMembers()) {
            System.out.println(format("Команда \"%s\" Дистанцию проходит %s по имени %s:",
                    team.getName(),animal.getType(),animal.getName()));

            for (Obstacle obs : obstacles) {
                obs.doIt(animal);
            }
            System.out.println();
        }
    }
}
