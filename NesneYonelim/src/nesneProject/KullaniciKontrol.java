package nesneProject;

import java.util.Scanner;

public class KullaniciKontrol {
    public KullaniciKontrol() {
        String kullaniciAdi;
        String kullaniciSifre;
        boolean giris=false;
        //Kullanıcının giriş bilgilerinin kontrol edilmesi
        while(!giris){
            Scanner reader=new Scanner(System.in);
            System.out.print("Kullanıcı Adı: ");
            kullaniciAdi=reader.next();
            System.out.print("Şifre: ");
            kullaniciSifre=reader.next();

            //Kullanıcı başarılı bir şekilde giriş yaparsa arayüze yönlendirilir.
            if(Veritabani.getInstance().kullaniciDogrula(kullaniciAdi,kullaniciSifre)){
                Arayuz arayuz=new Arayuz(kullaniciAdi);
            }
            giris=true;

        }
    }
}
