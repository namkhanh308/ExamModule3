package controller;

import dao.Book.BookDAO;
import dao.Book.IBook;
import dao.Card.CardDAO;
import dao.Student.IStudent;
import dao.Student.StudentDAO;
import model.Book;
import model.Card;
import model.Statistical;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ServletCard", value = "/card")
public class ServletCard extends HttpServlet {
    IBook bookDAO = new BookDAO();
    IStudent studentDAO = new StudentDAO();
    CardDAO cardDAO = new CardDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showFormBorrow(request,response);
                break;
            case "statistical":
                showStatisticalForm(request,response);
                break;
            case "pay":
                payBook(request,response);
                break;
            case "searchByNameBook":
                searchByNameBook(request,response);
                break;
            case "searchByNameStudent":
                searchByNameStudent(request,response);
                break;
            default:
                showAllProduct(request,response);
                break;
        }
    }

    private void searchByNameStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameStudent");
        List<Statistical> statisticalList =  cardDAO.findByNameStudent(name);
        request.setAttribute("statisticalList",statisticalList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Book/statistical.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByNameBook(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Statistical> statisticalList =  cardDAO.findByNameBook(name);
        request.setAttribute("statisticalList",statisticalList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Book/statistical.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void payBook(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Card card = cardDAO.findByIdCard(id);
        card.setStatus(true);
        cardDAO.updateCard(id,card);
        int idBook = card.getIdBook();
        Book book = bookDAO.findById(idBook);
        book.setQuantity(book.getQuantity()+1);
        bookDAO.update(idBook,book);
        try {
            response.sendRedirect("/card");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStatisticalForm(HttpServletRequest request, HttpServletResponse response) {
        List<Statistical> statisticalList= cardDAO.findAllStatistical();
        request.setAttribute("statisticalList",statisticalList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Book/statistical.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormBorrow(HttpServletRequest request, HttpServletResponse response) {
        String MMS = request.getParameter("MMS");
        int idBook = Integer.parseInt(request.getParameter("id"));
        String borrowDate = LocalDate.now().toString();
        List<Student> studentList = studentDAO.findAll();
        Book book = bookDAO.findById(idBook);
        request.setAttribute("book",book);
        request.setAttribute("borrowDate",borrowDate);
        request.setAttribute("studentList",studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Book/borrow.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Book> listBook = bookDAO.findAll();
        request.setAttribute("listBook",listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Book/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                borrowBook(request,response);
                break;
            default:
                showAllProduct(request,response);
                break;
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String mms = (request.getParameter("mms"));
        String nameBook = request.getParameter("nameBook");
        String borrowDate = request.getParameter("borrowDate");
        String payDate = request.getParameter("payDate");
        int IDstudent = Integer.parseInt(request.getParameter("IDstudent"));
        Book book = bookDAO.findById(idBook);
        if(book.getQuantity() == 0){
            try {
                response.sendRedirect("/card");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            book.setQuantity(book.getQuantity()-1);
            bookDAO.update(idBook,book);
            Card card = new Card(mms,idBook,IDstudent,false,borrowDate,payDate);
            cardDAO.add(card);
            try {
                response.sendRedirect("/card");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
