package model;

public class Card {
    private String id;
    private int idBook;
    private int idStudent;
    private boolean status;
    private String borrowedDate;
    private String payDate;

    public Card(String id, int idBook, int idStudent, boolean status, String borrowedDate, String payDate) {
        this.id = id;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
    }

    public Card(int idBook, int idStudent, boolean status, String borrowedDate, String payDate) {
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

