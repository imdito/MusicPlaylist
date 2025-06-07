/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.akun;

/**
 *
 * @author dhima
 */
//import Controller;

//import Controller.;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.ControllerAkun;
import Model.Akun.ModelAkun;
import View.HalamanUtama;

public class LoginPage extends JFrame {
    //ControllerAuth controller;
    
    // Components
    JLabel header = new JLabel("LOGIN", SwingConstants.CENTER);
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    JButton tombolLogin = new JButton("Login");
    JButton tombolRegister = new JButton("Belum punya akun? Registrasi");
    ModelAkun akun = new ModelAkun();
    ControllerAkun controller = new ControllerAkun(this);
    public LoginPage() {
        setTitle("Login System");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(500, 400);
        getContentPane().setBackground(new Color(240, 240, 240));

        // Customize header
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(70, 130, 180)); // Steel blue
        header.setBounds(0, 30, 500, 30);

        // Customize labels
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        labelUsername.setBounds(50, 90, 400, 20);
        
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        labelPassword.setBounds(50, 170, 400, 20);

        // Customize input fields
        inputUsername.setBounds(50, 120, 400, 35);
        inputUsername.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10))
        );
        
        inputPassword.setBounds(50, 200, 400, 35);
        inputPassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10))
        );

        // Customize buttons
        tombolLogin.setBounds(50, 260, 400, 40);
        tombolLogin.setFont(new Font("Arial", Font.BOLD, 14));
        tombolLogin.setBackground(new Color(70, 130, 180)); // Steel blue
        tombolLogin.setForeground(Color.WHITE);
        tombolLogin.setBorderPainted(false);
        tombolLogin.setFocusPainted(false);
        
        tombolRegister.setBounds(50, 310, 400, 30);
        tombolRegister.setFont(new Font("Arial", Font.PLAIN, 12));
        tombolRegister.setContentAreaFilled(false);
        tombolRegister.setBorderPainted(false);
        tombolRegister.setForeground(new Color(70, 130, 180)); // Steel blue
        tombolRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components
        add(header);
        add(labelUsername);
        add(labelPassword);
        add(inputUsername);
        add(inputPassword);
        add(tombolLogin);
        add(tombolRegister);
        
        //controller = new ControllerAuth(this);

        // Add action listeners
        tombolLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("".equals(inputUsername.getText()) || "".equals(inputPassword.getText())) {

                    JOptionPane.showMessageDialog(null, "Username atau password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String username = inputUsername.getText();
                    String password = new String(inputPassword.getPassword());
                    akun.setUsername(username);
                    akun.setPassword(password);
                    if (controller.checkAkun(akun) == true) {
                        JOptionPane.showMessageDialog(null, "Login Berhasil");
                        ;
                        new HalamanUtama(akun);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Username atau password salah", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        tombolRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterPage();
            }
        });
    }
    
    public String getUsername() {
        return inputUsername.getText();
    }
    
    public String getPassword() {
        return new String(inputPassword.getPassword());
    }
}