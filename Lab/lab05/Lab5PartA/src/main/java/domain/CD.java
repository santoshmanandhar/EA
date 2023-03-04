package domain;

public class CD extends Product{
    private String artist;

    public CD(String artist) {
        this.artist = artist;
    }

    public CD(String name, String description, double price, String artist) {
        super(name, description, price);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
