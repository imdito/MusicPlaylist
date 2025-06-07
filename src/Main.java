//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


//import View.HalamanLoginDaftar;
import View.HalamanUtama;
import View.akun.LoginPage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}