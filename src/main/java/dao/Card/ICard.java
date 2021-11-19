package dao.Card;

import dao.IDao;
import model.Card;
import model.Statistical;

import java.util.List;

public interface ICard extends IDao<Card> {
    public Card findByIdCard(String id);
    public void updateCard(String id, Card card);
    public List<Statistical> findByNameBook(String nameBook);
    public List<Statistical> findByNameStudent(String nameStudent);
}
