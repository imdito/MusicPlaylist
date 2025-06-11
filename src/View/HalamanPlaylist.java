package View;

import Controller.ControllerHalamanPlaylist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Akun.ModelAkun;
public class HalamanPlaylist extends JFrame {
    private JPanel MainPanel;
    private JTable tablePlaylist;
    private JTextField namafield;
    private JButton Insert;
    private JTable tablee;
    private JButton backButton;
    private JButton Update;
    private JButton deleteButton;
    private JButton lihatIsiPlaylistButton;
    private JButton clearButton;
    ControllerHalamanPlaylist controller;
    String kolomPlaylist[] = {"ID", "Nama Playlist"};
    Integer barisTerpilih;
    ModelAkun akun = new ModelAkun();

    public HalamanPlaylist(ModelAkun akun) {
        this.akun = akun;
        System.out.println("ID Akun: " + akun.getIdAkun());
        setTitle("Halaman Playlist");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(MainPanel);

        controller = new ControllerHalamanPlaylist(this, akun.getIdAkun());
        controller.tampilkanDaftarPlaylist();
        System.out.println("ID Akun: " + akun.getIdAkun());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanUtama(akun);
                dispose();
            }
        });
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (barisTerpilih != null) {
                    int idplaylist = (int) tablePlaylist.getValueAt(barisTerpilih, 0); // Assuming the first column is the ID
                    controller.updatePlaylist(idplaylist);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih lagu yang ingin diupdate!");
                }
            }
        });
        Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.tambahPlaylist();
            }
        });


        tablePlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                barisTerpilih = tablePlaylist.getSelectedRow();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (barisTerpilih != null) {
                    System.out.println("Baris terpilih: " + barisTerpilih);
                    controller.deletePlaylist(barisTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih lagu yang ingin dihapus!");
                }
            }
        });
        lihatIsiPlaylistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPlaylist = (int) tablePlaylist.getValueAt(barisTerpilih, 0);
                new HalamanIsiPlaylist(idPlaylist, akun);
                dispose();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                namafield.setText("");

            }
        });
    }

    public JTable getTablePlaylist() {
        return tablePlaylist;
    }
    public String getNamafield() {
        return namafield.getText();
    }




}
