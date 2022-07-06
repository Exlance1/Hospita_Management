package Properties;

public class Stack
{
    String[] dizi;
    int size;
    int indis;

    public Stack(int size)
    {
        this.size = size;
        dizi = new String[size];
        indis = -1;
    }

    //Eleman ekleme.
    public void push(String data)
    {
        if (isFull())
        {
            System.out.println("Stack dolu");
        }

        else
        {
            dizi[++indis] = data;
        }

    }

    //Eleman silme.
    public String pop()
    {
        if (isEmpty())
        {
            return "Hata oluştu!";
        }

        else
        {
            return dizi[indis--];
        }
    }

    //Doluluk testi.
    public boolean isFull()
    {
        return indis == size - 1;
    }

    //Doluluk testi.
    public boolean isEmpty()
    {
        return indis == -1;
    }
}