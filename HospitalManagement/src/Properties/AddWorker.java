package Properties;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddWorker extends Frame
{
    String [] fullNameArray;
    String [] jobArray;
    String [] idArray;
    String [] salaryArray;
    int size;
    int front;
    int rear;

    public AddWorker(int size)
    {
        this.size = size;
        fullNameArray = new String[size];
        jobArray = new String[size];
        idArray = new String[size];
        salaryArray = new String[size];
        front = 0;
        rear = -1;
    }

    //Burada enQueue fonksiyonu ile eklemek istediğimiz elemanları kuyruk yapısına sokarak txt dosyalarına kaydediyoruz.
    public void enQueue(String fullName, String job, String id, String salary)
    {
        if(isFull())
        {
            JOptionPane.showMessageDialog(this,"Şu an ekleme yapamazsınız!","Ekleme hatası",JOptionPane.WARNING_MESSAGE);
        }

        else
        {
            rear++;
            fullNameArray[rear] = fullName;
            jobArray[rear] = job;
            idArray[rear] = id;
            salaryArray[rear] = salary;
        }

        try
        {
            FileWriter fileWriter = new FileWriter("Workers.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String text = "Ad-Soyad: " + fullNameArray[front] + "     Meslek: " + jobArray[front] + "     ID: " + idArray[front] + "     Maaş: " + salaryArray[front];

            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.close();

            FileWriter fileWriter1 = new FileWriter("Fullnames.txt",true);
            BufferedWriter  bufferedWriter1 = new BufferedWriter(fileWriter1);

            bufferedWriter1.write(fullNameArray[front]);
            bufferedWriter1.newLine();
            bufferedWriter1.close();

            FileWriter fileWriter2 = new FileWriter("Jobs.txt",true);
            BufferedWriter  bufferedWriter2 = new BufferedWriter(fileWriter2);

            bufferedWriter2.write(jobArray[front]);
            bufferedWriter2.newLine();
            bufferedWriter2.close();

            FileWriter fileWriter3 = new FileWriter("Ids.txt",true);
            BufferedWriter  bufferedWriter3 = new BufferedWriter(fileWriter3);

            bufferedWriter3.write(idArray[front]);
            bufferedWriter3.newLine();
            bufferedWriter3.close();

            FileWriter fileWriter4 = new FileWriter("Salaries.txt",true);
            BufferedWriter  bufferedWriter4 = new BufferedWriter(fileWriter4);

            bufferedWriter4.write(salaryArray[front]);
            bufferedWriter4.newLine();
            bufferedWriter4.close();

            deQueue();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public void deQueue()
    {
        if(isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Şu an çıkartma yapamazsınız!","Silme hatası",JOptionPane.WARNING_MESSAGE);
        }

        else
        {
            for(int i=1;i<=rear;i++)
            {
                fullNameArray[i-1] = fullNameArray[i];
                jobArray[i-1] = jobArray[i];
                idArray[i-1] = idArray[i];
                salaryArray[i-1] = salaryArray[i];
            }

            rear--;
        }
    }

    private boolean isEmpty()
    {
        return rear == -1;
    }

    private boolean isFull()
    {
        return rear == size;
    }
}