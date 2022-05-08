package nesneProject;

public class MerkeziSistem {
    private boolean acik=false;

    public MerkeziSistem(){
        Eyleyici eyleyici=new Eyleyici();
    }
    public void eyleyiciyiCalistir(String durum){
        Eyleyici eyleyici=new Eyleyici();
        System.out.println("İstek eyleyiciye bildiriliyor");
        try{
            Thread.sleep(1500);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        //Soğutucunun açılıp kapatılması
        if(durum.equals("Ac")){
            eyleyici.sogutucuAc();
            acik=true;
        }
        else{
            eyleyici.sogutucuKapa();
            acik=false;
        }
    }
    public boolean sogutucuAcikMi(){
        if(acik)
            return true;
        else
            return false;
    }
    public boolean sogutucuKapaliMi(){
        if(acik)
            return false;
        else
            return true;
    }


}
