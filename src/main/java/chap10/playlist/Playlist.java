package chap10.playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 음악 목록을 저장하는 클래스
 */
public class Playlist {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> signers = new HashMap<>();

    public void append(Song song) {
        getTracks().add(song);
        signers.put(song.getSinger(), song.getTitle());
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSigners() {
        return signers;
    }
}
