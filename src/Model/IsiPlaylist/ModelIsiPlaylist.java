package Model.IsiPlaylist;

import Model.Lagu.ModelLagu;
import Model.PlayList.ModelPlaylist;

import java.util.List;

public class ModelIsiPlaylist {

    private String judulLagu;
    private String penyanyi;
    private String gambar;
    private String genre;
    private String namaPlaylist;

    private int idIsiPlaylist;
    private int idPlaylist;
    private int idLagu;

    public int getIdIsiPlaylist() {
        return idIsiPlaylist;
    }

    public void setIdIsiPlaylist(int idIsiPlaylist) {
        this.idIsiPlaylist = idIsiPlaylist;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

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

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }
    public String getGambar() {
        return gambar;
    }
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNamaPlaylist() {
        return namaPlaylist;
    }
    public void setNamaPlaylist(String namaPlaylist) {
        this.namaPlaylist = namaPlaylist;
    }

}
