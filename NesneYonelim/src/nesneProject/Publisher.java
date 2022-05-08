package nesneProject;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{
    private List<IObserver> kullanicilar=new ArrayList<>();
    @Override
    public void attach(IObserver o) {
        kullanicilar.add(o);
    }

    @Override
    public void detach(IObserver o) {
        kullanicilar.remove(o);
    }

    @Override
    public void notify(int temperature) {
        for(IObserver subscriber : kullanicilar){
            subscriber.update(temperature);
        }
    }
}
