package View;

import Controller.ControllerHalamanUtama;
import View.akun.LoginPage;
import Model.Akun.ModelAkun;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HalamanUtama extends JFrame {
    ModelAkun akun = new ModelAkun();
    private JPanel MainPanel;
    private JTable tableLagu;
    private JTable tablePlaylist;
    private JButton aturPlaylistButton;
    private JButton aturLaguButton;
    private JScrollPane scrollPaneLagu;
    private JScrollPane scrollPlaylist;
    private JTextPane header;
    private JButton exitButton;

    ControllerHalamanUtama controller;
    String kolomLagu[] = {"Judul Lagu", "Penyanyi", "Album", "Genre", "Gambar", "Link Lagu"};
    String kolomPlaylist[] = {"Nama Playlist"};


    public HalamanUtama(ModelAkun akun) {
        this.akun = akun;
        setTitle("Halaman Utama");
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        controller = new ControllerHalamanUtama(this);
        controller.tampilkanDaftarLagu();
        controller.tampilkanDaftarPlaylist();
        // Initialize components and add action listeners if needed
        aturPlaylistButton.addActionListener(e -> {
            // Logic for managing playlists
            new HalamanPlaylist(akun);
            dispose();
        });

        aturLaguButton.addActionListener(e -> {
            // Logic for managing songs
            new HalamanLagu(akun);
            dispose();
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
        tablePlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = tablePlaylist.rowAtPoint(e.getPoint());
            }
        });
    }



    public JTable getTableLagu() {
        return tableLagu;
    }
    public JTable getTablePlaylist() {
        return tablePlaylist;
    }



}
