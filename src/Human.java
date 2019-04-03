abstract class Human extends Department {
    private String mFIO;

    abstract void printHumanInfo();

    @Override
    public String toString() {
        printHumanInfo();
        return super.toString();
    }

    public String getFIO() {
        return mFIO;
    }

    public void setFIO(String FIO) {
        mFIO = FIO;
    }
}
