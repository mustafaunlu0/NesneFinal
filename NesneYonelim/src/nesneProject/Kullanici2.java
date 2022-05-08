package nesneProject;

public class Kullanici2 implements IObserver{

    @Override
    public void update(int temperature) {
        kullaniciIkiyiGuncelle(temperature);
    }
    public void kullaniciIkiyiGuncelle(int temp){
        System.out.println("3434 Nolu Mustafa - Yeni Sıcaklık: "+temp+"°C");
    }
}
