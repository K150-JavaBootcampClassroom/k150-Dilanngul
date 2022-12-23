
import java.util.Scanner;
public class switchapp{


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int bakiye = 2500;
        System.out.println("kodluyoruz banka hoşgeldiniz.");


        System.out.println("Bakiyeniz = " + bakiye);
        System.out.println("1. Para Çekme");
        System.out.println("2. Para Yatırma");
        System.out.println("3. Bakiye sorgulama");


        System.out.print("yapmak istediğiniz işlemi seçiniz ");
        int islem = scan.nextInt();

        switch(islem) {
            case 1:
                System.out.println("Bakiyeniz = " + bakiye);
                System.out.print("Çekmek istediğiniz tutarı giriniz: ");
                int tutar = scan.nextInt();

        }
        bakiye -= tutar;
        System.out.println("Yeni bakiyeniz = " + bakiye);
        break;
        case 2:
        System.out.println("Bakiyeniz = " + bakiye);
        System.out.print("Yatırmak istediğiniz tutarı giriniz: ");
        tutar = scan.nextInt();

        break;
        case 3:
        System.out.println("Bakiyeniz = " + bakiye);
        break;
        case 4:
        System.out.println("Kartınızı almayı unutmayınız.!!");

    }
}
