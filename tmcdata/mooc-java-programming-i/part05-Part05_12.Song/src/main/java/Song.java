
public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;

    public Song(String artist, String name, int durationInSeconds) {
        this.artist = artist;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public boolean equals(Object compared) {

        if (this == compared) {
            return true;
        }
        // if the type of the compared object is not Song, the objects are not equal
        if (!(compared instanceof Song)) {
            return false;
        }
        // convert the Object type compared object
        // into a Song type object called comparedSong
        Song comparedSong = (Song) compared;

        // if the values of the object variables are the same, the objects are equal
        if (this.artist == comparedSong.artist &&
            this.name == comparedSong.name &&
            this.durationInSeconds == comparedSong.durationInSeconds) {
            return true;
        }

        // otherwise the objects are not equal
        return false;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.durationInSeconds + " s)";
    }

}
