public class Doctor extends Employee implements ICanTakeHeal{
    private String mSciencePost;

    @Override
    void printHumanInfo() {
        super.printHumanInfo();
        System.out.println("Научная должность:"+mSciencePost);
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
