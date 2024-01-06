package com.design.patterns.creational.prototype;

// Prototype interface
interface CloneablePrototype extends Cloneable {
    CloneablePrototype clone();
}

// Concrete prototype - Movie Streaming Service
class MovieStreamingService implements CloneablePrototype {
    private String movieTitle;

    public MovieStreamingService(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public MovieStreamingService clone() {
        try {
            return (MovieStreamingService) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        System.out.println("Playing movie: " + movieTitle);
    }
}

// Concrete prototype - Music Streaming Service
class MusicStreamingService implements CloneablePrototype {
    private String songTitle;

    public MusicStreamingService(String songTitle) {
        this.songTitle = songTitle;
    }

    @Override
    public MusicStreamingService clone() {
        try {
            return (MusicStreamingService) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        System.out.println("Playing song: " + songTitle);
    }
}

// Client code
public class StreamingApp {
    public static void main(String[] args) {
        // Create prototype instances
        MovieStreamingService moviePrototype = new MovieStreamingService("The Matrix");
        MusicStreamingService musicPrototype = new MusicStreamingService("Imagine");

        // Clone prototypes to create new objects
        MovieStreamingService newMovie = moviePrototype.clone();
        MusicStreamingService newSong = musicPrototype.clone();

        // Play the cloned objects
        newMovie.play();
        newSong.play();
    }
}
