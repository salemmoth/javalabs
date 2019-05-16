import java.util.Objects;

public class Doctor extends Employee implements ICanTakeHeal {
    private String mSciencePost;

    @Override
    void printHumanInfo() {
        super.printHumanInfo();
        System.out.println("Научная должность:" + mSciencePost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(mSciencePost, doctor.mSciencePost) && Objects.equals(getFIO(), doctor.getFIO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mSciencePost);
    }

    public String getSciencePost() {
        return mSciencePost;
    }

    public void setSciencePost(String sciencePost) {
        mSciencePost = sciencePost;
    }

    @Override
    public boolean canHeal() {
        return false;
    }
}
