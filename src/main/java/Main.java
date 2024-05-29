import dao.FakeBooksDAO;

public class Main {

    public static void main(String[] args) {
        var bookResults = FakeBooksDAO.getBooks();
        System.out.println(bookResults);
    }
}
