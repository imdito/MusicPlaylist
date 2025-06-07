package Controller;

import Model.Akun.DaoAkun;
import Model.Akun.InterfaceDAOAkun;
import Model.Akun.ModelAkun;
import View.akun.RegisterPage;
import java.util.List;

public class ControllerRegister {
    // This class can be used to handle registration logic
    // For now, it is empty and can be expanded later as needed
    List<ModelAkun> daftarAkun;
    InterfaceDAOAkun daoAkun = new DaoAkun();
    RegisterPage registerPage;
    public ControllerRegister(RegisterPage registerPage) {
        // Constructor logic if needed
        this.registerPage = registerPage;
        this.daftarAkun = daftarAkun;

    }

    // Add methods for registration logic here
    public void insertAkun() {
        try {
            ModelAkun akun = new ModelAkun();
            akun.setUsername(registerPage.getUsername());
            akun.setPassword(registerPage.getPassword());
            if ("".equals(registerPage.getUsername()) || "".equals(registerPage.getPassword())) {
                System.out.println("Username atau password tidak boleh kosong");
                return;
            }

            // Simpan akun ke database
            daoAkun.insertAkun(akun);
        }catch (Exception e){
            return ;
        }


    }
}
