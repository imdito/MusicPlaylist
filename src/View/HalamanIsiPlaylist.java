package View;

import Controller.ControllerIsiPlaylist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Akun.ModelAkun;
public class HalamanIsiPlaylist extends  JFrame {
    private JTable tableIsiPlaylist;
    private JTable tableListLagu;
    private JTextArea daftarIsiLaguDiTextArea;
    private JTextArea daftarLaguTersediaTextArea;
    private JButton deleteButton;
    private JButton insertButton;
    private JButton backButton;
    private JPanel MainPanel;

    ControllerIsiPlaylist controller = new ControllerIsiPlaylist(this);
    int idIsiPlaylist;
    Integer laguDalamPlaylistTerpilih;
    Integer laguTersediaTerpilih;
    public HalamanIsiPlaylist(int idIsiPlaylist, ModelAkun akun) {
        this.idIsiPlaylist = idIsiPlaylist;
        setTitle("Halaman Isi Playlist");
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        System.out.println("ID Isi Playlist: " + idIsiPlaylist);
        controller.tampilkanDaftarIsiPlaylist(idIsiPlaylist);
        controller.tampilkanDaftarLagu();
        tableIsiPlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                laguDalamPlaylistTerpilih = tableIsiPlaylist.getSelectedRow();
            }
        });
        tableListLagu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                laguTersediaTerpilih = tableListLagu.getSelectedRow();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(laguDalamPlaylistTerpilih != null){
                    int id = (int) tableIsiPlaylist.getValueAt(laguDalamPlaylistTerpilih, 0); // Assuming the first column is the ID
                    System.out.println("ID Isi Playlist yang akan dihapus: " + id);
                    controller.deleteLagu(id);
                    controller.tampilkanDaftarIsiPlaylist(idIsiPlaylist);
                    laguDalamPlaylistTerpilih = null;
                }else{

                    JOptionPane.showMessageDialog(null, "Pilih lagu yang ingin dihapus dari playlist.");

                }
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(laguTersediaTerpilih != null){
                    int idLaguTersedia = (int) tableListLagu.getValueAt(laguTersediaTerpilih, 0); // Assuming the first column is the ID
                    controller.insertLagu(idIsiPlaylist, idLaguTersedia);

                }else{

                    JOptionPane.showMessageDialog(null, "Pilih lagu yang ingin ditambahkan ke playlist.");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HalamanPlaylist(akun);
                dispose();
            }
        });
    }
    public JTable getTableIsiPlaylist() {
        return tableIsiPlaylist;
    }
    public JTable getTableListLagu() {
        return tableListLagu;
    }
    public JTextArea getDaftarIsiLaguDiTextArea() {
        return daftarIsiLaguDiTextArea;
    }
    public JTextArea getDaftarLaguTersediaTextArea() {
        return daftarLaguTersediaTextArea;
    }

}
