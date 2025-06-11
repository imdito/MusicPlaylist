package Controller;

import Model.Lagu.DAOLagu;
import Model.Lagu.InterfaceDAOLagu;
import Model.Lagu.ModelLagu;
import Model.Lagu.ModelTableLagu;
import Utils.ImageTableCellRenderer;
import View.HalamanLagu;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class ControllerHalamanLagu {

    List<ModelLagu> daftarLagu;
    InterfaceDAOLagu daoLagu;
    HalamanLagu halamanLagu;

    public ControllerHalamanLagu(HalamanLagu halamanLagu) {
        this.halamanLagu = halamanLagu;
        this.daoLagu = new DAOLagu();
    }

    public void tampilkanDaftarLagu() {
        daftarLagu = daoLagu.getAllLagu();
        ModelTableLagu modelTableLagu = new ModelTableLagu(daftarLagu);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(halamanLagu.kolomLagu);
        halamanLagu.getAllLagu().setModel(modelTableLagu);
        TableColumn imageColumn = halamanLagu.getAllLagu().getColumnModel().getColumn(5);
        imageColumn.setCellRenderer(new ImageTableCellRenderer());

    }

    public void inputLagu() {
        try {
            ModelLagu lagu = new ModelLagu();
            lagu.setJudulLagu(halamanLagu.getJudulLaguField().getText());
            lagu.setPenyanyi(halamanLagu.getPenyanyiField().getText());
            lagu.setAlbum(halamanLagu.getAlbumField().getText());
            lagu.setGenre(halamanLagu.getGenreField().getText());
            lagu.setGambar(halamanLagu.getGambarField().getText());
            lagu.setLinkLagu(halamanLagu.getLinkField().getText());

            if ("".equals(lagu.getJudulLagu()) || "".equals(lagu.getPenyanyi()) || "".equals(lagu.getAlbum()) || "".equals(lagu.getGenre()) || "".equals(lagu.getGambar()) || "".equals(lagu.getLinkLagu())) {
                throw new Exception("Semua field harus diisi!");
            }

            daoLagu.insertLagu(lagu);
            JOptionPane.showMessageDialog(null, "Lagu baru berhasil ditambahkan.");

            tampilkanDaftarLagu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", ERROR_MESSAGE);

        }
    }

    public void updateLagu(int id) {
        try {
            int selectedRow = halamanLagu.getAllLagu().getSelectedRow();
            if (selectedRow == -1) {
                throw new Exception("Pilih lagu yang ingin diupdate!");
            }

            ModelLagu lagu = daftarLagu.get(selectedRow);
            lagu.setJudulLagu(halamanLagu.getJudulLaguField().getText());
            lagu.setPenyanyi(halamanLagu.getPenyanyiField().getText());
            lagu.setAlbum(halamanLagu.getAlbumField().getText());
            lagu.setGenre(halamanLagu.getGenreField().getText());
            lagu.setGambar(halamanLagu.getGambarField().getText());
            lagu.setLinkLagu(halamanLagu.getLinkField().getText());

            if ("".equals(lagu.getJudulLagu()) || "".equals(lagu.getPenyanyi()) || "".equals(lagu.getAlbum()) || "".equals(lagu.getGenre()) || "".equals(lagu.getGambar()) || "".equals(lagu.getLinkLagu())) {
                throw new Exception("Semua field harus diisi!");
            }

            daoLagu.updateLagu(lagu);
            tampilkanDaftarLagu();
            JOptionPane.showMessageDialog(null, "Data lagu berhasil diupdate.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", ERROR_MESSAGE);
        }
    }

    public void deleteLagu(int rowIndex) {
        int id = (int) halamanLagu.getAllLagu().getValueAt(rowIndex, 0);
        String judul = halamanLagu.getAllLagu().getValueAt(rowIndex, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + judul + " ?",
                "Hapus Lagu",
                JOptionPane.YES_NO_OPTION
        );

        if(input == 0){
            try {
                daoLagu.deleteLagu(id);
                tampilkanDaftarLagu();
                JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            } catch (HeadlessException e) {
                System.out.println("error" + e);
            }

        }

    }
}
