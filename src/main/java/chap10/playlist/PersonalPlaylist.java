package chap10.playlist;

/**
 * 노래 삭제 기능이 추가된 플레이리스트
 */
public class PersonalPlaylist extends Playlist {

    //플레이리스트에서 노래 삭제 기능
    public void remove(Song song) {
        getTracks().remove(song);
        getSigners().remove(song.getSinger());
    }
}
