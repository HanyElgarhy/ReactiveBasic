package com.reactive.observerdesignpattern;

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Book book = new Book("life","sci-fi","Hany",120D,"soldout");
        EndUser user1 = new EndUser("Bob",book);
        EndUser user2 = new EndUser("Rob",book);
        System.out.println(book.getInStock());
        book.setInStock("In stock ");
    }
}
