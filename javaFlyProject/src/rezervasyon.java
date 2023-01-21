package havalimani.odev;
public class UcusRezervasyonu {
    private String rezervasyonNo;
    private Ucus ucusNo;
    private UcusKoltugu koltukNo;
    private Yolcu yolcu;
    private RezervasyonDurum durum;

    public String getRezervasyonNo() {
        return rezervasyonNo;
    }

    public void setRezervasyonNo(String rezervasyonNo) {
        this.rezervasyonNo = rezervasyonNo;
    }

    public Ucus getUcusNo() {
        return ucusNo;
    }

    public void setUcusNo(Ucus ucusNo) {
        this.ucusNo = ucusNo;
    }

    public UcusKoltugu getKoltukNo() {
        return koltukNo;
    }

    public void setKoltukNo(UcusKoltugu koltukNo) {
        this.koltukNo = koltukNo;
    }

    public Yolcu getYolcu() {
        return yolcu;
    }

    public void setYolcu(Yolcu yolcu) {
        this.yolcu = yolcu;
    }

    public RezervasyonDurum getDurum() {
        return durum;
    }

    public void setDurum(RezervasyonDurum durum) {
        this.durum = durum;
    }

    public static List<Yolcu> getirYolcu() throws FileNotFoundException, IOException{
        File file=new File("C:\\javademos\\javaFlyProject\\src\\kişi");
        if(file.exists()){
            file.createNewFile();}

        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        List<Yolcu>yolcuList  = new ArrayList<Yolcu>();

        while ((line = br.readLine()) != null)

            String[] strArray;

            //converting using String.split() method with whitespace as a delimiter

            strArray = line.split(";");
            Yolcu yolcu= new Yolcu();

            yolcu.setKisiTc(strArray[0]);
            yolcu.setAdSoyad (strArray[1]);
            Date dogumTarihi = new Date();
            try {
                yolcu.setDogumTarihi(new SimpleDateFormat("yyyy-MM-dd").parse(strArray[2]+"-"+strArray[3]+"-"+strArray[4] ));
            } catch (ParseException e) {
            }
            yolcu.setKategori(strArray[5]);
            yolcuList.add(yolcu);
        }
        br.close();
        return yolcuList;
    }

    public static List<UcusRezervasyonu> getirRezervasyonlar(){


        List<UcusRezervasyonu>ucusRezervasyonusList  = new ArrayList<UcusRezervasyonu>();

        File file=new File("C:\\Users\\ESİLA\\Desktop\\Files\\rezervasyonlar.txt");
        if(file.exists()){
            file.createNewFile();}

        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) { //bana belirtilen bir dosyadaki tüm satırları içeren String[] dizisini döndürmelidir.

            String[] strArray;


            strArray = line.split(";");

            Yolcu yolcu= new Yolcu();
            yolcu.setYolcuNo(Integer.parseInt(strArray[0]));
            yolcu.setKisiTc(strArray[1]);
            yolcu.setAdSoyad(strArray[2]);

            UcusRezervasyonu ucusRezervasyonu=new UcusRezervasyonu();
            ucusRezervasyonu.setRezervasyonNo(strArray[3]);

            Ucus ucus=new Ucus();
            ucus.setSure(Float.parseFloat(strArray[4]));
            Havalimani kalkisHavalimani= new Havalimani();
            kalkisHavalimani.setHavalimaniAd(strArray[5]);
            ucus.setKalkis(kalkisHavalimani);

            Havalimani varisHavalimani= new Havalimani();
            varisHavalimani.setHavalimaniAd(strArray[6]);
            ucus.setVaris(varisHavalimani);

            ucus.setUcusNo(Integer.parseInt(strArray[7]));

            Koltuk koltuk= new Koltuk();
            koltuk.setKoltukNo(strArray[8]);
            switch (strArray[9]) {
                case "ECONOMY" -> koltuk.setSinif(KoltukSinifi.ECONOMY);
                case "BUSINESS" -> koltuk.setSinif(KoltukSinifi.BUSINESS);
            }
            UcusKoltugu ucusKoltugu=new UcusKoltugu();
            ucusKoltugu.setUcret(Float.parseFloat(strArray[10]));

            switch (strArray[11]) {
                case "1" -> ucus.setDurum(UcusDurum.PLANLANDI);
                case "2" -> ucus.setDurum(UcusDurum.ERTELENDI);
                case "3" -> ucus.setDurum(UcusDurum.AYRILDI);
                case "4" -> ucus.setDurum(UcusDurum.TAMAMLANDI);
                case "5" -> ucus.setDurum(UcusDurum.IPTAL);
            }
        }
        br.close();
        return ucusRezervasyonusList;

    }

    public static boolean  ekleRezervasyon(){
        try{
            File file = new File("C:\\Users\\ESİLA\\Desktop\\Files\\rezervasyonlar.txt");
            if (!file.exists())
                file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            Yolcu yolcu = new Yolcu();
            UcusRezervasyonu ucusRezervasyonu=new UcusRezervasyonu();
            Ucus ucus=new Ucus();
            Koltuk koltuk=new Koltuk();
            UcusKoltugu  ucusKoltugu=new UcusKoltugu();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(ucus.getKalkisSaat());
            bWriter.write(yolcu.getYolcuNo()+";"
                    +yolcu.getKisiTc()+";"
                    +yolcu.getAdSoyad()+";"
                    +ucusRezervasyonu.getRezervasyonNo()+";"
                    +calendar.get(Calendar.HOUR)+":"
                    +calendar.get(Calendar.MINUTE)+";"
                    +ucus.getKalkis()+";"
                    +ucus.getVaris()+";"
                    +ucus.getUcusNo()+";"
                    +koltuk.getKoltukNo()+";"
                    +koltuk.getSinif()+";"
                    +ucusKoltugu.getirUcret()+";"
                    +ucus.getDurum()
            );
            bWriter.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static boolean   guncelleRezervasyonDurum( String rezervasyonNo,RezervasyonDurum durum) throws FileNotFoundException, IOException{
        UcusRezervasyonu ucusRezervasyonu= new UcusRezervasyonu();
        File file=new File("C:\\Users\\ESİLA\\Desktop\\Files\\rezervasyonlar.txt");
        if(file.exists()){
            file.createNewFile();}

        FileReader fileReader = new FileReader(file);
        String line;
        ArrayList<String>rezervasyonList=new ArrayList<>();
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            rezervasyonList.add(line);

        }

        br.close();
        for(int i=0;i<=rezervasyonList.size();i++){

            if(rezervasyonList.get(i).contains(rezervasyonNo) ){
                String[] strArray;
                strArray = line.split(";");
                strArray[11]= durum.toString();

                rezervasyonList.set(i, String.join(";", strArray ));

            }
        }

        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        for(int i=0 ; i<rezervasyonList.size();i++){
            rezervasyonList.get(i);

            bWriter.write(
                    rezervasyonList.get(i)


            );
            bWriter.close();
        }
        return false;

    }
}



