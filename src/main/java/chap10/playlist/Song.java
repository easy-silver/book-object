package chap10.playlist;

/**
 * 음악 정보를 저장하는 클래스
 */
public class Song {

    private String singer;
    private String title;

    public Song(String singer, String title) {
        this.singer = singer;
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }
}
