package UI;

import Properties.AddWorker;
import java.awt.*;
import java.awt.event.*;

public class NewWorker extends Frame
{
    public NewWorker()
    {
        //Burada UI'yı ayarlıyoruz.
        Panel panel = new Panel();
        Label workerFullName = new Label("Ad-Soyad");
        TextField workerNameField = new TextField();
        Label workerJob = new Label("Meslek");
        TextField workerJobField = new TextField();
        Label workerId = new Label("Id");
        TextField workerIdField = new TextField();
        Label workerSalary = new Label("Maaş");
        TextField workerSalaryField = new TextField();
        Button confirmButton = new Button("Ekle");
        Button cancelButton = new Button("İptal");

        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                System.exit(0);
            }
        };

        //Burada çalışanımızı eklediğimizin onayını alıyoruz.
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AddWorker addWorker = new AddWorker(1);
                addWorker.enQueue(workerNameField.getText(),workerJobField.getText(),workerIdField.getText(),workerSalaryField.getText());

                dispose();
                HomePage homePage = new HomePage();
            }
        });

        //İptal butonuna basarak ana sayfaya dönüyoruz.
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                HomePage homePage = new HomePage();
            }
        });

        workerFullName.setBounds(85,130,80,50);
        workerNameField.setBounds(150,140,130,30);
        workerJob.setBounds(95,190,80,50);
        workerJobField.setBounds(150,200,130,30);
        workerId.setBounds(120,250,80,50);
        workerIdField.setBounds(150,260,130,30);
        workerSalary.setBounds(110,310,80,50);
        workerSalaryField.setBounds(150,320,130,30);
        confirmButton.setBounds(100,400,130,30);
        cancelButton.setBounds(260,400,130,30);

        add(workerNameField);
        add(workerFullName);
        add(workerJobField);
        add(workerJob);
        add(workerIdField);
        add(workerId);
        add(workerSalaryField);
        add(workerSalary);
        add(confirmButton);
        add(cancelButton);
        add(panel);

        addWindowListener(windowListener);
        setBounds(800,300,500,500);
        setTitle("Çalışan Ekleme Sayfası");
        setVisible(true);
    }
}