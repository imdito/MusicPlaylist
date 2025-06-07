/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.akun;

/**
 *
 * @author dhima
 */

//import Controller.;
//import Controller.ControllerAuth;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Model.Akun.ModelAkun;
import Controller.ControllerAkun;
import Controller.ControllerRegister;

public class RegisterPage extends JFrame {
    //ControllerAuth controller;
    
    // Components
    JLabel header = new JLabel("REGISTER", SwingConstants.CENTER);
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");
    JLabel labelConfirmPassword = new JLabel("Confirm Password");
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    JPasswordField inputConfirmPassword = new JPasswordField();
    JButton tombolRegister = new JButton("Register");
    JButton tombolKembali = new JButton("Already have an account? Login");
    ModelAkun akun = new ModelAkun();
    ControllerRegister controller = new ControllerRegister(this);

    public RegisterPage() {
        setTitle("Registration System");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(500, 500);
        getContentPane().setBackground(new Color(240, 240, 240));

        // Customize header
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(70, 130, 180)); // Steel blue
        header.setBounds(0, 30, 500, 30);

        // Customize labels
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        labelUsername.setBounds(50, 80, 400, 20);
        
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        labelPassword.setBounds(50, 160, 400, 20);
        
        labelConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        labelConfirmPassword.setBounds(50, 240, 400, 20);

        // Customize input fields
        inputUsername.setBounds(50, 110, 400, 35);
        inputUsername.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10))
        );
        
        inputPassword.setBounds(50, 190, 400, 35);
        inputPassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10))
        );
        
        inputConfirmPassword.setBounds(50, 270, 400, 35);
        inputConfirmPassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10))
        );

        // Customize buttons
        tombolRegister.setBounds(50, 330, 400, 40);
        tombolRegister.setFont(new Font("Arial", Font.BOLD, 14));
        tombolRegister.setBackground(new Color(70, 130, 180)); // Steel blue
        tombolRegister.setForeground(Color.WHITE);
        tombolRegister.setBorderPainted(false);
        tombolRegister.setFocusPainted(false);
        
        tombolKembali.setBounds(50, 380, 400, 30);
        tombolKembali.setFont(new Font("Arial", Font.PLAIN, 12));
        tombolKembali.setContentAreaFilled(false);
        tombolKembali.setBorderPainted(false);
        tombolKembali.setForeground(new Color(70, 130, 180)); // Steel blue
        tombolKembali.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components
        add(header);
        add(labelUsername);
        add(labelPassword);
        add(labelConfirmPassword);
        add(inputUsername);
        add(inputPassword);
        add(inputConfirmPassword);
        add(tombolRegister);
        add(tombolKembali);
        
        //controller = new ControllerAuth(this);

        // Add action listeners
        tombolRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("".equals(inputUsername.getText())) {
                    JOptionPane.showMessageDialog(null, "Username atau password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    inputPassword.getPassword();
                    if (!getPassword().equals(getConfirmPassword())) {
                        JOptionPane.showMessageDialog(null, "Password tidak cocok", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    akun.setUsername(inputUsername.getText());
                    akun.setPassword(new String(inputPassword.getPassword()));
                    controller.insertAkun();
                }
                dispose();
                new LoginPage();
            }
        });

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });
    }
    
    public String getUsername() {
        return inputUsername.getText();
    }
    
    public String getPassword() {
        return new String(inputPassword.getPassword());
    }
    
    public String getConfirmPassword() {
        return new String(inputConfirmPassword.getPassword());
    }
}