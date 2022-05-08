package nesneProject;

public class KullaniciFactory {

    public IObserver getObserver(String kullanici){
        if(kullanici==null)
            return null;
        if(kullanici.equalsIgnoreCase("k1"))
            return new Kullanici1();
        else if(kullanici.equalsIgnoreCase("k2"))
            return new Kullanici2();
        return null;
    }
}
