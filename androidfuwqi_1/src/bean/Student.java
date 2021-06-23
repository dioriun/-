package bean;

public class Student {
    private int Sno;
    private String Spass;
    private String Sname;
    private String Sclass;
    private String Ssex;
    private String Sage;
    private String Ssc;

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getSpass() {
        return Spass;
    }

    public void setSpass(String spass) {
        Spass = spass;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        Sclass = sclass;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSage() {
        return Sage;
    }

    public void setSage(String sage) {
        Sage = sage;
    }

    public String getSsc() {
        return Ssc;
    }

    public void setSsc(String ssc) {
        Ssc = ssc;
    }

    public Student(int sno, String spass, String sname, String sclass,
                   String ssex, String sage, String ssc) {
        Sno = sno;
        Spass = spass;
        Sname = sname;
        Sclass = sclass;
        Ssex = ssex;
        Sage = sage;
        Ssc = ssc;
    }
    public Student(){
        super();
    }
}