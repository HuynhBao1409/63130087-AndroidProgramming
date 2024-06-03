package thi.Bao63130087.Dethi2;

public class Subject {
    int  IDMon;
    int MaMon;
    String BookName;

    public Subject(int IDMon, int maMon, String bookName) {
        this.IDMon = IDMon;
        MaMon = maMon;
        BookName = bookName;
    }

    public int getIDMon() {
        return IDMon;
    }

    public void setIDMon(int IDMon) {
        this.IDMon = IDMon;
    }

    public int getMaMon() {
        return MaMon;
    }

    public void setMaMon(int maMon) {
        MaMon = maMon;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }
}
