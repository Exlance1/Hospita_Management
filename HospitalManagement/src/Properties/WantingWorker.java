package Properties;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WantingWorker
{
    Node head;
    String id;

    //Aramak istediğimiz çalışanın ID'sini head olarak belirliyoruz.
    public WantingWorker(String id)
    {
        this.id = id;
        head = new Node();
        head.id = id;
        head.next = null;
    }

    //Burada bağlı listeler için bir tanımlama gerçekleştiriyoruz. Ve bağlı listeye kaydediyoruz.
    public void initializeIds()
    {
        ArrayList<String> idArrayList = new ArrayList<>();

        try
        {
            FileReader reader = new FileReader("Ids.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while((line = bufferedReader.readLine()) != null)
            {
                idArrayList.add(line);
            }

            reader.close();
        }

        catch(IOException exception)
        {
            exception.printStackTrace();
        }

        for(int i=0;i<idArrayList.size();i++)
        {
            Node newNode = new Node();
            newNode.id = idArrayList.get(i);
            newNode.next = null;

            addElementLast(newNode);
        }
    }

    //Bağlı listeye elemanları ekliyoruz. Bu fonksiyonu initializeIds() fonksiyonunda çağırarak devamlı bir ekleme işlemi yapmayı sağlıyoruz.
    public void addElementLast(Node newNode)
    {
        Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    //temp değişkenimiz aradığımız ID'yi saklamaktadır. temp2 değişkenimiz ise bağıl listedeki tüm elemanları saklamaktadır.
    public void findWorker(TextArea workerArea)
    {
        Node temp = head;
        Node temp2 = head.next;
        int counter = 0;

        while(temp2 != null)
        {
            if(temp.id.equals(temp2.id))
            {
                break;
            }

            else
            {
                counter++;
                temp2 = temp2.next;
            }
        }

        //Burada txt dosyalarından ilgili ID'nin özelliklerini buluyoruz.
        try
        {
            FileReader reader = new FileReader("Fullnames.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            String text = "";
            int counter2 = 0;

            while((line = bufferedReader.readLine()) != null)
            {
                if(counter2 == counter)
                {
                    text += "Ad-Soyad: " + line;
                    break;
                }

                else
                {
                    counter2++;
                }
            }

            reader.close();

            FileReader reader1 = new FileReader("Jobs.txt");
            BufferedReader bufferedReader1 = new BufferedReader(reader1);
            String line1;
            int counter3 = 0;

            while((line1 = bufferedReader1.readLine()) != null)
            {
                if(counter3 == counter)
                {
                    text += "     Meslek: " + line1;
                    break;
                }

                else
                {
                    counter3++;
                }
            }

            reader1.close();

            FileReader reader2 = new FileReader("Ids.txt");
            BufferedReader bufferedReader2 = new BufferedReader(reader2);
            String line2;
            int counter4 = 0;

            while((line2 = bufferedReader2.readLine()) != null)
            {
                if(counter4 == counter)
                {
                    text += "     ID: " + line2;
                    break;
                }

                else
                {
                    counter4++;
                }
            }

            reader2.close();

            FileReader reader3 = new FileReader("Salaries.txt");
            BufferedReader bufferedReader3 = new BufferedReader(reader3);
            String line3;
            int counter5 = 0;

            while((line3 = bufferedReader3.readLine()) != null)
            {
                if(counter5 == counter)
                {
                    text += "     Maaş: " + line3;
                    break;
                }

                else
                {
                    counter5++;
                }
            }

            reader3.close();

            workerArea.setText(text);
        }

        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
}