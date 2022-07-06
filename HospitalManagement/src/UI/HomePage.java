package UI;

import java.awt.*;
import java.awt.event.*;

public class HomePage extends Frame
{
    public HomePage()
    {
        //Burada ana sayfanın UI'yını yapıyoruz.
        Panel panel = new Panel();
        Button addWorker = new Button("Çalışan Ekle");
        Button workers = new Button("Çalışanlar");
        Button deleteWorker = new Button("Çalışan Çıkart");
        Button logout = new Button("Çıkış");

        //Burada çalışan eklemek için buton koyuyoruz.
        addWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                NewWorker newWorker = new NewWorker();
            }
        });

        //Burada çalışanları görmek için buton koyuyoruz.
        workers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Workers workers1 = new Workers();
            }
        });

        //Burada çalışan silmek için buton koyuyoruz.
        deleteWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                DeleteWorker deleteWorker = new DeleteWorker();
            }
        });

        //Burada çıkış yapmak için buton koyuyoruz.
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                LoginPanel loginPanel = new LoginPanel();
            }
        });

        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                System.exit(0);
            }
        };

        addWorker.setBounds(190,140,90,30);
        workers.setBounds(190,190,90,30);
        deleteWorker.setBounds(190,240,90,30);
        logout.setBounds(190,290,90,30);

        add(addWorker);
        add(workers);
        add(deleteWorker);
        add(logout);
        add(panel);

        addWindowListener(windowListener);
        setBounds(800,300,500,500);
        setTitle("Ana Sayfa");
        setVisible(true);
    }
}