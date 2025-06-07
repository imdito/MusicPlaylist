package Model.Lagu;

public class ModelLagu {

    private String judulLagu, penyanyi, album, genre, gambar, linkLagu;
    private int idLagu;

    public int getIdLagu() {
        return idLagu;
    }
    public void setIdLagu(int idLagu) {
        this.idLagu = idLagu;
    }
    public String getJudulLagu() {
        return judulLagu;
    }
    public void setJudulLagu(String judulLagu) {
        this.judulLagu = judulLagu;
    }
    public String getPenyanyi() {
        return penyanyi;
    }
    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGambar() {
        return gambar;
    }
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
    public String getLinkLagu() {
        return linkLagu;
    }
    public void setLinkLagu(String linkLagu) {
        this.linkLagu = linkLagu;
    }

}
