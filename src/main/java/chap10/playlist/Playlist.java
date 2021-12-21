package chap10.playlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 음악 목록을 저장하는 클래스
 */
public class Playlist {
    private List<Song> tracks = new ArrayList<>();

    public void append(Song song) {
        getTracks().add(song);
    }

    public List<Song> getTracks() {
        return tracks;
    }

}
