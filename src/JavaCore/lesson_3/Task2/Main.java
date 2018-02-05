package JavaCore.lesson_3.Task2;

import JavaCore.lesson_3.Task1;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(8925,"Мегафон");
        phoneBook.add(8963,"БиЛайн");
        phoneBook.add(8999,"Йота");
        phoneBook.add(8926,"Мегафон");
        phoneBook.add(8977,"Теле2");
        phoneBook.add(8964,"БиЛайн");
        phoneBook.add(8915,"МТС");
        phoneBook.add(8929,"Мегафон");
        phoneBook.add(8985,"МТС");
        phoneBook.add(8967,"БиЛайн");
        phoneBook.add(8916,"МТС");
        phoneBook.add(8965,"БиЛайн");
        //Добавим пару дубликатов
        phoneBook.add(8929,"Мегафон");
        phoneBook.add(8985,"МТС");
        phoneBook.add(8967,"БиЛайн");
        phoneBook.add(8916,"МТС");

        phoneBook.get("БиЛайн");


        PhoneB book = new PhoneB();
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");
        book.add("Bob1","123");




    }
}
