import java.util.Random;
public class random {
    public static void main(String[]args)
    {
        random rastgele = new random();
        int counter =0;
        int Sayi;

        while (true)
        {
            Sayi = rastgele = (500) + 1;
            System.out.println("sayı:" + Sayi);

            if (Sayi >50 && Sayi <100)
            {
                counter++;
            }
            System.out.println("sayı"+ counter +"bulundu");
        }
        counter++;

    }
}