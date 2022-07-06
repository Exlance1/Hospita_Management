package UI;

import Model.HintTextModel;
import Properties.SearchWorker;
import Properties.WantingWorker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Workers extends Frame
{
    public Workers()
    {
        //Burada UI'yı ayarlıyoruz.
        Panel panel = new Panel();
        TextField searchField = new HintTextModel("ID giriniz");
        Icon icon = new ImageIcon("C:\\Users\\MONSTER\\Desktop\\HospitalManagement\\searchh.png");
        Icon icon1 = new ImageIcon("C:\\Users\\MONSTER\\Desktop\\HospitalManagement\\refresh.png");
        Icon icon2 = new ImageIcon("C:\\Users\\MONSTER\\Desktop\\HospitalManagement\\back.png");
        JButton searchButton = new JButton(icon);
        JButton refreshButton = new JButton(icon1);
        JButton backButton = new JButton(icon2);
        TextArea workerArea = new TextArea();
        SearchWorker searchWorker = new SearchWorker();

        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                System.exit(0);
            }
        };

        //Aramak istediğimiz çalışanın ID'sini giriyoruz ve butona basıyoruz.
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                WantingWorker wantingWorker = new WantingWorker(searchField.getText());
                wantingWorker.initializeIds();
                wantingWorker.findWorker(workerArea);
            }
        });

        //Yenile butonuna basarak kayıtlı verileri yeniliyoruz.
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                workerArea.setText(searchWorker.workers());
            }
        });

        //Geri butonuyla ana sayfaya dönüyoruz.
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                HomePage homePage = new HomePage();
            }
        });

        searchField.setBounds(140,100,190,30);
        searchButton.setBounds(350,100,30,30);
        refreshButton.setBounds(400,100,30,30);
        backButton.setBounds(440,450,30,30);
        workerArea.setBounds(30,160,440,250);

        workerArea.setText(searchWorker.workers());

        add(searchField);
        add(searchButton);
        add(refreshButton);
        add(workerArea);
        add(backButton);
        add(panel);

        addWindowListener(windowListener);
        setBounds(800,300,500,500);
        setTitle("Çalışanlar Sayfası");
        setVisible(true);
    }
}