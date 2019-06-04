import javax.print.Doc;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Hospital implements Comparable<Hospital>, Serializable {
    private String mNameOfHospital;
    private String mFIOofDirector;// ФИО заведующего
    private String mCity;
    private String mAddress;
    private List<Patient> mPatients;
    private List<Doctor> mDoctors;
    private List<Department> mDepartments;

    public List<Department> getDepartments() {
        return mDepartments;
    }

    public void setDepartments(List<Department> departments) {
        mDepartments = departments;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public List<Patient> getPatients() {
        return mPatients;
    }

    public void setPatients(List<Patient> patients) {
        mPatients = patients;
    }

    public List<Doctor> getDoctors() {
        return mDoctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        mDoctors = doctors;
    }

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
        return String.format("Больница\n\tНазвание:%s,ФИО директора:%s,Город:%s,",getNameOfHospital(),getFIOofDirector(),getCity());
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
