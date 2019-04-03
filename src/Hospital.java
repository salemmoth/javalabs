public class Hospital {
    private String mNameOfHospital;
    private String mFIOofDirector;// ФИО заведующего
    private String mCity;
    private String mAddress;

    public Hospital(String nameOfHospital, String fioOfDirector, String city, String address){
        mNameOfHospital=nameOfHospital;
        mFIOofDirector=fioOfDirector;
        mCity=city;
        mAddress= address;
    }

    public Hospital() {
    }

    @Override
    public String toString(){
        return "Название больницы: "+mNameOfHospital+"; \n"+
                "Ф.И.О заведующего : "+mFIOofDirector+
                "Город: "+mCity+"; \n"+
                "Адресс:"+mAddress+"; \n";
    }

    public String getNameOfHospital(){ return mNameOfHospital; }

    public void setNameOfHospital(String nameOfHospital) {
        mNameOfHospital = nameOfHospital;
    }
    public String getFIOofDirector(){
        return mFIOofDirector;
    }
    public void setFIOofDirector(String fiOofDirector){
        mFIOofDirector=fiOofDirector;
    }
    public String getCity(){
        return mCity;
    }
    public void setCity(String city){
        mCity=city;
    }
    public String getaddress(){
        return mAddress;
    }
    public void setaddress(String address){
        mAddress=address;
    }
}
