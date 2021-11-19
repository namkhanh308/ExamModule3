package model;

public class Book {
    private int id;
    private String name;
    private String actor;
    private String description;
    private int quantity;

    public Book(int id, String name, String actor, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.description = description;
        this.quantity = quantity;
    }

    public Book(String name, String actor, String description, int quantity) {
        this.name = name;
        this.actor = actor;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
