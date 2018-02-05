package JavaCore.lesson_1;

import static java.lang.String.format;

public class Team {
    private String name;
    private Animal[] members;


    public Team(String name, Animal[] members) {
        this.name = name;
        this.members = members;
    }

    public void showResults() {
        System.out.println(format("Победители команды \"%s\"",name));
        for (Animal animal : members)  {
            if(animal.isOnDistance()) {
                animal.printResult();
            }
        }
        System.out.println();
    }

    public void allMemberInfo() {
        System.out.println(format("Инфомация о команде \"%s\"",name));
        for(Animal animal: members) {
            System.out.println(format("%s по имени %s, дистанция бега - %s, высота прыжка - %s, дистанция заплыва - %s",
                    animal.getType(),animal.getName(),animal.getMaxRunDistance(),animal.getMaxJumpHeight(),animal.getMaxSwimDistance()));
        }
    }

    public String getName() {
        return name;
    }

    public Animal[] getMembers() {
        return members;
    }
}
