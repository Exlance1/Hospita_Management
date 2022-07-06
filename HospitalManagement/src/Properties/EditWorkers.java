package Properties;

import java.io.*;
import java.util.ArrayList;

public class EditWorkers
{
    String id;
    int counter = 0;

    public EditWorkers(String id)
    {
        this.id = id;
    }

    //Silme işleminde kullanıcının ID'si ile silinmek istenen ID ile eşleştirmeye çalışıyoruz. Eşleşen değere kadar sayacımızı birer birer arttırıyoruz.
    //Daha sonra sayacımız eşleştiği anda duruyor. Böylece silmek istediğimiz verinin txt dosyasında kaçıncı indiste bulunduğunu bulmuş oluyoruz.
    public void editWorker()
    {
        ArrayList<String> fullnames = new ArrayList<>();
        ArrayList<String> jobs = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> salaries = new ArrayList<>();

        try
        {
            FileReader reader = new FileReader("Ids.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while((line = bufferedReader.readLine()) != null)
            {
                if(id.equals(line))
                {
                    break;
                }

                else
                {
                    counter++;
                }
            }

            reader.close();

            FileReader reader1 = new FileReader("Fullnames.txt");
            BufferedReader bufferedReader1 = new BufferedReader(reader1);
            String line1;
            String text1 = "";
            int counter1 = 0;

            while((line1 = bufferedReader1.readLine()) != null)
            {
                if(counter1 != counter)
                {
                    text1 += line1 + "\n";
                    fullnames.add(line1);
                    counter1++;
                }

                else
                {
                    counter1++;
                }
            }

            reader1.close();

            FileReader reader2 = new FileReader("Jobs.txt");
            BufferedReader bufferedReader2 = new BufferedReader(reader2);
            String line2;
            String text2 = "";
            int counter2 = 0;

            while((line2 = bufferedReader2.readLine()) != null)
            {
                if(counter2 != counter)
                {
                    text2 += line2 + "\n";
                    jobs.add(line2);
                    counter2++;
                }

                else
                {
                    counter2++;
                }
            }

            reader2.close();

            FileReader reader3 = new FileReader("Ids.txt");
            BufferedReader bufferedReader3 = new BufferedReader(reader3);
            String line3;
            String text3 = "";
            int counter3 = 0;

            while((line3 = bufferedReader3.readLine()) != null)
            {
                if(counter3 != counter)
                {
                    text3 += line3 + "\n";
                    ids.add(line3);
                    counter3++;
                }

                else
                {
                    counter3++;
                }
            }

            reader3.close();

            FileReader reader4 = new FileReader("Salaries.txt");
            BufferedReader bufferedReader4 = new BufferedReader(reader4);
            String line4;
            String text4 = "";
            int counter4 = 0;

            while((line4 = bufferedReader4.readLine()) != null)
            {
                if(counter4 != counter)
                {
                    text4 += line4 + "\n";
                    salaries.add(line4);
                    counter4++;
                }

                else
                {
                    counter4++;
                }
            }

            reader4.close();

            FileWriter writer = new FileWriter("Workers.txt",false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for(int i=0;i<fullnames.size();i++)
            {
                bufferedWriter.write("Ad-Soyad: " + fullnames.get(i) + "     Meslek: " + jobs.get(i) + "     ID: " + ids.get(i) + "     Maaş: " + salaries.get(i));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            FileWriter writer1 = new FileWriter("Fullnames.txt",false);
            BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);

            for(int i=0;i<fullnames.size();i++)
            {
                bufferedWriter1.write(fullnames.get(i));
                bufferedWriter1.newLine();
            }

            bufferedWriter1.close();

            FileWriter writer2 = new FileWriter("Jobs.txt",false);
            BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);

            for(int i=0;i<fullnames.size();i++)
            {
                bufferedWriter2.write(jobs.get(i));
                bufferedWriter2.newLine();
            }

            bufferedWriter2.close();

            FileWriter writer3 = new FileWriter("Ids.txt",false);
            BufferedWriter bufferedWriter3 = new BufferedWriter(writer3);

            for(int i=0;i<fullnames.size();i++)
            {
                bufferedWriter3.write(ids.get(i));
                bufferedWriter3.newLine();
            }

            bufferedWriter3.close();

            FileWriter writer4 = new FileWriter("Salaries.txt",false);
            BufferedWriter bufferedWriter4 = new BufferedWriter(writer4);

            for(int i=0;i<fullnames.size();i++)
            {
                bufferedWriter4.write(salaries.get(i));
                bufferedWriter4.newLine();
            }

            bufferedWriter4.close();
        }

        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
}