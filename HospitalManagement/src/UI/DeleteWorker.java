package UI;

import Model.HintTextModel;
import Properties.EditWorkers;
import Properties.SearchWorker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteWorker extends Frame
{
    public DeleteWorker()
    {
        //Burada UI'yı ayarlıyoruz.
        Panel panel = new Panel();
        TextField deleteField = new HintTextModel("ID giriniz");
        Icon icon = new ImageIcon("C:\\Users\\MONSTER\\Desktop\\HospitalManagement\\trash.png");
        Icon icon1 = new ImageIcon("C:\\Users\\MONSTER\\Desktop\\HospitalManagement\\back.png");
        Icon icon2 = new ImageIcon("C:\\Users\\MONSTER\\Desktop\\HospitalManagement\\refresh.png");
        JButton deleteButton = new JButton(icon);
        JButton backButton = new JButton(icon1);
        JButton refreshButton = new JButton(icon2);
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

        //Silme işlemini burada yapıyoruz.
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                EditWorkers editWorkers = new EditWorkers(deleteField.getText());
                editWorkers.editWorker();
            }
        });

        //Yenileme işlemini burada yapıyoruz.
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                workerArea.setText(searchWorker.workers());
            }
        });

        //Ana sayfaya gelme işlemini burada yapıyoruz.
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                HomePage homePage = new HomePage();
            }
        });

        deleteField.setBounds(140,100,190,30);
        deleteButton.setBounds(350,100,30,30);
        refreshButton.setBounds(400,100,30,30);
        backButton.setBounds(440,450,30,30);
        workerArea.setBounds(30,160,440,250);

        workerArea.setText(searchWorker.workers());

        add(deleteField);
        add(deleteButton);
        add(refreshButton);
        add(backButton);
        add(workerArea);
        add(panel);

        addWindowListener(windowListener);
        setBounds(800,300,500,500);
        setTitle("Çalışan Çıkartma Sayfası");
        setVisible(true);
    }
}