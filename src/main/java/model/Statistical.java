package model;

public class Statistical {
    private String id;
    private String nameBook;
    private String actor;
    private String nameStudent;
    private String classStudent;
    private String borrowedDate;
    private String payDate;

    public Statistical(String id, String nameBook, String actor, String nameStudent, String classStudent, String borrowedDate, String payDate) {
        this.id = id;
        this.nameBook = nameBook;
        this.actor = actor;
        this.nameStudent = nameStudent;
        this.classStudent = classStudent;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
    }

    public Statistical(String nameBook, String actor, String nameStudent, String classStudent, String borrowedDate, String payDate) {
        this.nameBook = nameBook;
        this.actor = actor;
        this.nameStudent = nameStudent;
        this.classStudent = classStudent;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
