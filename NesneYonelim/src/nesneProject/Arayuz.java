package nesneProject;

import java.util.Scanner;

public class Arayuz {
    public Arayuz(String kullaniciadi){
        KullaniciFactory kullaniciFactory=new KullaniciFactory();
        IObserver k1=kullaniciFactory.getObserver("k1");
        IObserver k2=kullaniciFactory.getObserver("k2");

        //Kullanici1 k1=new Kullanici1();
        //Kullanici2 k2=new Kullanici2();

        Publisher p=new Publisher();
        p.attach(k1);
        p.attach(k2);

        int secim=1;
        MerkeziSistem merkeziSistem=new MerkeziSistem();

        do{
            Scanner reader=new Scanner(System.in);
            System.out.println("1- Soğutucuyu aç");
            System.out.println("2- Soğutucuyu kapat");
            System.out.println("3- Sıcaklık görüntüle");
            System.out.println("4- Çıkış");
            System.out.println("Seçim: ");
            secim=reader.nextInt();

            switch (secim){
                case 1:
                    //Soğutucu açık mı kontrol ediliyor. Açık değilse açılıyor
                    if(merkeziSistem.sogutucuAcikMi()){
                        System.out.println("Soğutucu açık durumda!");
                    }
                    else{
                        merkeziSistem.eyleyiciyiCalistir("Ac");
                    }
                    break;
                case 2:
                    //Soğutucu kapalımı mı kontrol ediliyor. Kapalı değilse kapatılıyor
                    if(merkeziSistem.sogutucuKapaliMi()){
                        System.out.println("Soğutucu kapalı durumda!");
                    }
                    else{
                        merkeziSistem.eyleyiciyiCalistir("Kapat");
                    }
                    break;
                case 3:
                    SicaklikAlgilayici sicaklikAlgilayici=new SicaklikAlgilayici();
                    System.out.println("Sıcaklık algılanıyor..");
                    try {
                        Thread.sleep(1500);
                    }catch (Exception e){
                        e.getLocalizedMessage();
                    }
                    System.out.print("Sıcaklık: ");
                    int sicaklik=sicaklikAlgilayici.sicaklikDondur();
                    System.out.print(sicaklik);
                    System.out.print("°C\n");
                    if(kullaniciadi.equals("Mustafa"))
                        k2.update(sicaklik);
                    else
                        k1.update(sicaklik);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Hatalı Seçim!");
                    break;
            }
        }while (secim != 4);
    }

}
