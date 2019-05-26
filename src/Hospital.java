import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Hospital implements Comparable<Hospital>, Serializable {
    private String mNameOfHospital;
    private String mFIOofDirector;// ФИО заведующего
    private String mCity;
    private String mAddress;

    public Hospital(String nameOfHospital, String fioOfDirector, String city, String address) {
        mNameOfHospital = nameOfHospital;
        mFIOofDirector = fioOfDirector;
        mCity = city;
        mAddress = address;
    }

    public Hospital() {
    }

    @Override
    public String toString() {
        return "Название больницы: " + mNameOfHospital + "; \n" +
                "Ф.И.О заведующего : " + mFIOofDirector +
                "Город: " + mCity + "; \n" +
                "Адресс:" + mAddress + "; \n";
    }

    public String getNameOfHospital() {
        return mNameOfHospital;
    }

    public void setNameOfHospital(String nameOfHospital) {
        mNameOfHospital = nameOfHospital;
    }

    public String getFIOofDirector() {
        return mFIOofDirector;
    }

    public void setFIOofDirector(String fiOofDirector) {
        mFIOofDirector = fiOofDirector;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getaddress() {
        return mAddress;
    }

    public void setaddress(String address) {
        mAddress = address;
    }

    @Override
    public int compareTo(Hospital o) {
        int nameDiff = this.mNameOfHospital.compareTo(o.mNameOfHospital);
        if (nameDiff == 0)
            return mCity.compareTo(o.mCity);
        else
            return nameDiff;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(mNameOfHospital, hospital.mNameOfHospital) &&
                Objects.equals(mFIOofDirector, hospital.mFIOofDirector) &&
                Objects.equals(mCity, hospital.mCity) &&
                Objects.equals(mAddress, hospital.mAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mNameOfHospital, mFIOofDirector, mCity, mAddress);
    }
}
