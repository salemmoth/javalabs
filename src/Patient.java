import java.util.Date;

public class Patient extends Human implements ICanTakeHeal,ICanFirstAid{
    private long mInsurancesPolicy;
    private Date mArrivalDate; // дата поступления
    private Date mStatementDate; // дата выписки
    private String mDiagnosis; // Диагноз
    private Date mDateOfOperation;
    private String mNameOfOperation;
    private int mMedicalCost; // стоимость лечения
    void printHumanInfo() {
        System.out.println("Ф.И.О.="+getFIO()+
                "Insurances Policy=" +mInsurancesPolicy +
                ", Arrival Date='" + mArrivalDate + '\'' +
                ", Statement Date='" + mStatementDate + '\'' +
                ", Diagnosis='" + mDiagnosis + '\'' +
                ", Date Of Operation='" + mDateOfOperation + '\'' +
                ", Name Of Operation='" + mNameOfOperation + '\'' +
                ", Medical Cost=" + mMedicalCost);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Insurances Policy=" + mInsurancesPolicy +
                ", Arrival Date='" + mArrivalDate + '\'' +
                ", Statement Date='" + mStatementDate + '\'' +
                ", Diagnosis='" + mDiagnosis + '\'' +
                ", Date Of Operation='" + mDateOfOperation + '\'' +
                ", Name Of Operation='" + mNameOfOperation + '\'' +
                ", Medical Cost=" + mMedicalCost +
                '}';
    }

    public long getInsurancesPolicy() {
        return mInsurancesPolicy;
    }

    public void setInsurancesPolicy(long mInsurancesPolicy) {
        this.mInsurancesPolicy = mInsurancesPolicy;
    }

    public Date getArrivalDate() {
        return mArrivalDate;
    }

    public void setArrivalDate(Date mArrivalDate) {
        this.mArrivalDate = mArrivalDate;
    }

    public Date getStatementDate() {
        return mStatementDate;
    }

    public void setStatementDate(Date mStatementDate) {
        this.mStatementDate = mStatementDate;
    }

    public String getDiagnosis() {
        return mDiagnosis;
    }

    public void setDiagnosis(String mDiagnosis) {
        this.mDiagnosis = mDiagnosis;
    }

    public Date getDateOfOperation() {
        return mDateOfOperation;
    }

    public void setDateOfOperation(Date mDateOfOperation) {
        this.mDateOfOperation = mDateOfOperation;
    }

    public String getNameOfOperation() {
        return mNameOfOperation;
    }

    public void setNameOfOperation(String mNameOfOperation) {
        this.mNameOfOperation = mNameOfOperation;
    }

    public int getMedicalCost() {
        return mMedicalCost;
    }

    public void setMedicalCost(int mMedicalCost) {
        this.mMedicalCost = mMedicalCost;
    }

    @Override
    public boolean canHeal() {
        return true;
    }

    @Override
    public boolean canFirstAid() {
        return mDiagnosis == null || mDiagnosis.isEmpty();
    }
}
