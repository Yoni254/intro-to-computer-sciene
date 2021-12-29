package mmh2.src;

public class Video extends Item {

    private String _director;


    public Video(String title, int year, String director) {
        super(title, year);
        _director = director;
    }


    public Video(Video other) {
        super(other._title, other._publishYear);
        _director = other._director;
    }


    public String getDirector() {
        return _director;
    }


    public void setDirector(String director) {
        _director = director;
    }


    public boolean isOlder(int year) {
        return this._publishYear < year;
    }


    @Override
    public String toString() {
        return "Video - " + super.toString() + " \t directed by: " + _director;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + _title + "directed by " + _director + ", enjoy watching...");
    }
}
