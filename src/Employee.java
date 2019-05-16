public class Employee extends Human implements ICanFirstAid {
    private String mPost;
    private int mWorkExperience;

    @Override
    void printHumanInfo() {
        System.out.println("Фамилия Имя Отчество="+getFIO()+
                "mPost='" + mPost + '\'' +
                ", mWorkExperience=" + mWorkExperience);
    }



    public String getPost() {
        return mPost;
    }

    public void setPost(String post) {
        mPost = post;
    }

    public int getWorkExperience() {
        return mWorkExperience;
    }

    public void setWorkExperience(int workExperience) {
        mWorkExperience = workExperience;
    }

    @Override
    public boolean canFirstAid() {
        return mWorkExperience>0;
    }
}
