import jdk.swing.interop.SwingInterOpUtils;

import javax.print.Doc;
import java.awt.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    final static String[] NAMES = {"Албегонов Игорь", "Алборов Мухсен", "Зурыков Георгий", "Беззубов Баракуда"};
    final static String[] POSTS = {"Преподаватель", "Ученый", "Профессор", "Доцент"};
    final static String[] CITIES = {"Владикавказ", "Москва", "Санкт-Петербург", "Новокузнецк", "Липецк"};
    final static String[] DEPARTMENTS = {"Терапия", "Неврология", "Кардиология", "Гастроэнтерология", "Аллергологическое отделение", "Отделение реанимации и интенсивной терапии для больных с инфарктом миокарда"};
    final static String[] DIAGNOSIS = {"Простуда", "Депрессия", "Грип", "Диссециативное расстройство личности", "Биполярное расстройство", "Отравление", "Перелом", "Расстяжение"};


    static List<Hospital> hospitals;
    static List<Department> departments;
    static List<Patient> patients;
    static List<Doctor> doctors;
    static Scanner scanner;

    static class Diagnose {
        private int mCount;
        private int mCost;

        public Diagnose(int count, int cost) {
            mCount = count;
            mCost = cost;
        }

        public int getCount() {
            return mCount;
        }

        public void setCount(int count) {
            mCount = count;
        }

        public int getCost() {
            return mCost;
        }

        public void setCost(int cost) {
            mCost = cost;
        }
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        fillData();
        System.out.println("1) Дорогостоящие операции");
        System.out.println("2) Диагнозы стоимость и количество");
        System.out.println("3) По каждому врачу получить список пациентов");
        int choose = scanner.nextInt();
        if (choose == 1) {
            patients.sort(Comparator.comparingInt(Patient::getMedicalCost).reversed());
            System.out.println("Самые дорогостоящие операции");
            patients.forEach(System.out::println);
        } else if (choose == 2) {
            HashMap<String, Diagnose> hash = new HashMap<>();


            patients.forEach(patient -> {
                if (hash.containsKey(patient.getDiagnosis())) {
                    Diagnose diagnose = hash.get(patient.getDiagnosis());
                    diagnose.setCost(diagnose.getCost() + patient.getMedicalCost());
                    diagnose.setCount(diagnose.getCount() + 1);
                    hash.put(patient.getDiagnosis(), diagnose);

                } else {
                    hash.put(patient.getDiagnosis(), new Diagnose(1, patient.getMedicalCost()));
                }
            });
            hash.keySet().forEach(key -> {
                Diagnose diagnose = hash.get(key);
                System.out.println("Диагноз: " + key);
                System.out.println("Цена: " + diagnose.getCost());
                System.out.println("Кол-во пациентов: " + diagnose.getCount());
            });
        } else if (choose == 3) {
            doctors.forEach(doctor -> {
                List<Patient> founded = new ArrayList<>();
                patients.forEach(patient -> {
                    Doctor healDoctor = patient.getHealingDoctor();
                    if (healDoctor.equals(doctor))
                        founded.add(patient);
                });
                System.out.println("Доктор " + doctor.getFIO() + ", кол-во пациентов: " + founded.size());
            });
        }

    }

    static void fillData() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        Random random = new Random();
        System.out.print("Кол-во докторов: ");
        int doctorsCount = scanner.nextInt();
        System.out.print("Кол-во пациентов: ");
        int patientsCount = scanner.nextInt();

        for (int i = 0; i < doctorsCount; i++) {
            Doctor doctor = new Doctor();
            doctor.setFIO(NAMES[random.nextInt(NAMES.length)]);
            doctor.setSciencePost(POSTS[random.nextInt(POSTS.length)]);
            doctor.setCity(CITIES[random.nextInt(CITIES.length)]);
            doctor.setFIOofDirector(NAMES[random.nextInt(NAMES.length)]);
            doctor.setCorpus(random.nextInt(10) + 1);
            doctor.setFloor(random.nextInt(5) + 1);
            doctor.setNameOfHospital("ФГБОУ Клиническая больница №" + random.nextInt());
            doctor.setWorkExperience(random.nextInt(30));
            doctor.setaddress("Неизвестен");
            doctor.setNameOfDepartment(DEPARTMENTS[random.nextInt(DEPARTMENTS.length)]);
            doctors.add(doctor);
        }
        for (int i = 0; i < patientsCount; i++) {
            Patient patient = new Patient();
            patient.setFIO(NAMES[random.nextInt(NAMES.length)]);
            patient.setCity(CITIES[random.nextInt(CITIES.length)]);
            patient.setFIOofDirector(NAMES[random.nextInt(NAMES.length)]);
            patient.setCorpus(random.nextInt(10) + 1);
            patient.setFloor(random.nextInt(5) + 1);
            patient.setNameOfHospital("ФГБОУ Клиническая больница №" + random.nextInt());
            patient.setaddress("Неизвестен");
            patient.setNameOfDepartment(DEPARTMENTS[random.nextInt(DEPARTMENTS.length)]);
            patient.setHealingDoctor(doctors.get(random.nextInt(doctors.size())));
            patient.setDiagnosis(DIAGNOSIS[random.nextInt(DIAGNOSIS.length)]);
            patient.setNameOfOperation("Операция #" + random.nextInt(1000));
            patient.setMedicalCost(random.nextInt(1000) + 100);
            patients.add(patient);
        }

        doctors.forEach(System.out::println);
        patients.forEach(System.out::println);
    }
}

