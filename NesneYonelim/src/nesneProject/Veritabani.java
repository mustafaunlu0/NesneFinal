package nesneProject;

import java.sql.*;
import java.util.ArrayList;

public class Veritabani {
    private static Veritabani instance;
    private static Connection connection;
    private String url="jdbc:postgresql://localhost:5432/usersdb";
    private String username="postgres";
    private String password="admin";
    ArrayList<String> kullaniciadlari=new ArrayList<String>();
    ArrayList<String> kullanicisifreleri=new ArrayList<String>();
    ArrayList<String> kullanicinolari=new ArrayList<String>();

    public Veritabani() throws SQLException {
        //Bağlantı kurulumu
        try{
            Class.forName("org.postgresql.Driver");
            this.connection= DriverManager.getConnection(url,username,password);
            System.out.println("Database Connection successful");

        //Sorgunun çalıştırılması
        String sql="SELECT \"kullanicino\", \"kullaniciadi\", \"kullanicisifre\"  FROM \"users\"";

        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(sql);

        connection.close();

        String kullaniciNo=null;
        String kullaniciAdi=null;
        String kullaniciSifre=null;

        while(rs.next()){
            //Veritabanından çekilen verilerin değişkenlere atanması
            kullaniciAdi= rs.getString("kullaniciadi");
            kullaniciSifre=rs.getString("kullanicisifre");
            kullaniciNo=rs.getString("kullanicino");

            kullaniciadlari.add(kullaniciAdi);
            kullanicisifreleri.add(kullaniciSifre);
            kullanicinolari.add(kullaniciNo);
        }
        rs.close();
        st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Database Connection Creation Failed: " + e.getLocalizedMessage());
        }
    }
    public static Veritabani getInstance(){
        try{
            if(instance==null){
                instance=new Veritabani();
            }
            return instance;

        }catch (SQLException e){
            e.printStackTrace();

        }
        return instance;
    }
    public boolean kullaniciDogrula(String kullaniciAdi,String kullaniciSifre){
        System.out.println("Kullanıcı doğrulama işlemi gerçekleştiriliyor..\n");
        try{
            Thread.sleep(1500);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        System.out.println("Veritabanı bağlantısı sağlandı. Kullanıcı doğrulanıyor..\n");
        try{
            Thread.sleep(1500);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        for (int i=0;i<kullaniciadlari.size();i++){
            if(kullaniciadlari.get(i).equals(kullaniciAdi) && kullanicisifreleri.get(i).equals(kullaniciSifre)){
                System.out.println("Kullanıcı doğrulandı..\n");
                return true;
            }
        }
        System.out.println("Kullanıcı doğrulanamadı!\n");
        return false;

    }
}
