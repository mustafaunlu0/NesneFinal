package nesneProject;

public class Kullanici1 implements IObserver{

    @Override
    public void update(int temperature) {
        kullaniciBiriGuncelle(temperature);
    }
    public void kullaniciBiriGuncelle(int temp){
        System.out.println("3535 Nolu Sercan - Yeni Sıcaklık: "+temp+"°C");
    }
}
