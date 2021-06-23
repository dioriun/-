package bean;

public class AdminBean {
    private int Uno;
    private String Upass;


    public AdminBean(){
        super();
    }
    public AdminBean(int uno, String upass) {
        Uno = uno;
        Upass = upass;
    }



    public int getUno() {
        return Uno;
    }

    public void setUno(int uno) {
        Uno = uno;
    }

    public String getUpass() {
        return Upass;
    }

    public void setUpass(String upass) {
        Upass = upass;
    }


}
