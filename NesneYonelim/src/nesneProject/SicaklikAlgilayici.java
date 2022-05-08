package nesneProject;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
   private int sicaklik;

    public SicaklikAlgilayici() {
        Random random=new Random();
        sicaklik=random.nextInt(30)+20;
    }

    @Override
    public int sicaklikDondur() {
        return sicaklik;
    }
}
