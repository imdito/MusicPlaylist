package Controller;

import Model.Akun.*;

import View.akun.LoginPage;
import java.util.List;

public class ControllerAkun {

    List<ModelAkun> daftarAkun;
    InterfaceDAOAkun daoAkun;
    LoginPage halamanLoginDaftar;
    public ControllerAkun(LoginPage login) {
        this.halamanLoginDaftar = login;
        this.daoAkun = new DaoAkun();
    }

    public boolean checkAkun(ModelAkun akun) {
        if (akun.getUsername() != null && akun.getPassword() != null) {
            if (daoAkun.checkAkun(akun) == true) {
                // Jika akun ditemukan, set idAkun pada objek akun
                akun.setIdAkun(akun.getIdAkun());
            } else {
                // Jika akun tidak ditemukan, set idAkun menjadi -1 atau nilai yang sesuai
                return false;
            }
            return true; // Akun ditemukan
        } else {
            return false; // Akun tidak ditemukan
        }
    }



}
