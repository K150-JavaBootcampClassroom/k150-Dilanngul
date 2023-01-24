
import java.util.Date;

public class Ucus {
    int ucusNo;
    Ucak ucak;
    Date kalkisSaat;
    Date varisSaat;
    UcusDurum durum;
    float sure;

    public int getUcusNo() {
        return ucusNo;
    }

    public void setUcusNo(int ucusNo) {
        this.ucusNo = ucusNo;
    }
    

    public Ucak getUcak() {
        return ucak;
    }

    public void setUcak(Ucak ucak) {
        this.ucak = ucak;
    }

    public Date getKalkisSaat() {
        return kalkisSaat;
    }

    public void setKalkisSaat(Date kalkisSaat) {
        this.kalkisSaat = kalkisSaat;
    }

    public Date getVarisSaat() {
        return varisSaat;
    }

    public void setVarisSaat(Date varisSaat) {
        this.varisSaat = varisSaat;
    }

    public UcusDurum getDurum() {
        return durum;
    }

    public void setDurum(UcusDurum durum) {
        this.durum = durum;
    }

    public float getSure() {
        return sure;
    }

    public void setSure(float sure) {
        this.sure = sure;
    }


}
