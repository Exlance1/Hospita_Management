package UI;

import Model.HintTextModel;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends Frame
{
    public LoginPanel()
    {
        //Burada ilk girişteki UI'yı yapıyoruz.
        Panel panel = new Panel();
        Label nameLabel = new Label("Kullanıcı Adı");
        TextField nameField = new HintTextModel("Kullanıcı adı");
        Label passwordLabel = new Label("Şifre");
        TextField passwordField = new HintTextModel("Şifre");
        Button loginButton = new Button("Giriş Yap");
        Label info = new Label("Kullanıcı adı veya şifre hatalı!"); //Eğer kullanıcı adı veya şifre yanlış girilmiş ise ekranda bu hata çıkmıştır.

        info.setVisible(false);
        info.setBackground(Color.RED);
        passwordField.setEchoChar('*'); // Şifre kısmını gizliyoruz.

        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                System.exit(0);
            }
        };

        //Admin girişi için kontrol yapıyoruz.
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String password = passwordField.getText();

                if(name.equals("admin") && password.equals("admin"))
                {
                    info.setVisible(false);
                    nameField.setText("");
                    passwordField.setText("");

                    dispose();
                    HomePage homePage = new HomePage();//Giriş yapılıncı buraya yönlendiriliyor.
                }

                else
                {
                    info.setVisible(true);
                }
            }
        });

        nameLabel.setBounds(190,60,80,50);
        nameField.setBounds(190,100,100,30);
        passwordLabel.setBounds(215,125,50,50);
        passwordField.setBounds(190,160,100,30);
        loginButton.setBounds(190,200,80,30);
        info.setBounds(160,240,170,30);

        add(nameField);
        add(nameLabel);
        add(passwordField);
        add(passwordLabel);
        add(loginButton);
        add(info);
        add(panel);

        addWindowListener(windowListener);
        setBounds(800,300,500,500);
        setVisible(true);
        setTitle("Giriş Ekranı");
    }
}