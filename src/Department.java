

class Department  extends Hospital {
    private String mNameOfDepartment;
    private int mCorpus;
    private int mFloor;

    public Department(String nameOfDepartment, int corpus,int floor){
        mNameOfDepartment=nameOfDepartment;
        mCorpus=corpus;
        mFloor=floor;
    }

    public Department() {
    }

    @Override
    public String toString(){
        return super.toString()+"Название отделения: "+mNameOfDepartment+"; \n"+
                "Корпус: "+mCorpus+"; \n"+
                "Этаж: "+mFloor+"; \n";
}

    public String getNameOfDepartment() {
        return mNameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        mNameOfDepartment = nameOfDepartment;
    }

    public int getCorpus() {
        return mCorpus;
    }

    public void setCorpus(int corpus) {
        mCorpus = corpus;
    }

    public int getFloor() {
        return mFloor;
    }

    public void setFloor(int floor) {
        mFloor = floor;
    }
}
