package mmh2.src;

public abstract class Item {

    protected String _title;
    protected int _publishYear;


    public Item(String title, int year) {
        _title = title;
        _publishYear = year;
    }


    public Item(Item other) {
        _title = other._title;
        _publishYear = other._publishYear;
    }


    public String getTitle() {
        return _title;
    }


    public int getPublishYear() {
        return _publishYear;
    }


    public void setTitle (String newTitle) {
        _title = newTitle;
    }


    public void setPublishYear(int newYear) {
        _publishYear = _publishYear;
    }


    public String toString() {
        return _title + " \t Published at: " + _publishYear;
    }


    public abstract void play();

}
