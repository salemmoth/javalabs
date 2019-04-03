public class Patient extends Human implements ICanTakeHeal,ICanFirstAid{
    private long mInsurancesPolicy;
    private String mArrivalDate; // дата поступления
    private String mStatementDate; // дата выписки
    private String mDiagnosis;
    private String mDateOfOperation;
    private String mNameOfOperation;
    private int mMedicalCost; // стоимость лечения
    void printHumanInfo() {
        System.out.println("Ф.И.О.="+getFIO()+
                "mInsurancesPolicy=" +mInsurancesPolicy +
                ", mArrivalDate='" + mArrivalDate + '\'' +
                ", mStatementDate='" + mStatementDate + '\'' +
                ", mDiagnosis='" + mDiagnosis + '\'' +
                ", mDateOfOperation='" + mDateOfOperation + '\'' +
                ", mNameOfOperation='" + mNameOfOperation + '\'' +
                ", mMedicalCost=" + mMedicalCost);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "mInsurancesPolicy=" + mInsurancesPolicy +
                ", mArrivalDate='" + mArrivalDate + '\'' +
                ", mStatementDate='" + mStatementDate + '\'' +
                ", mDiagnosis='" + mDiagnosis + '\'' +
                ", mDateOfOperation='" + mDateOfOperation + '\'' +
                ", mNameOfOperation='" + mNameOfOperation + '\'' +
                ", mMedicalCost=" + mMedicalCost +
                '}';
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
