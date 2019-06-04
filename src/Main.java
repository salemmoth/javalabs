
import org.w3c.dom.traversal.DocumentTraversal;

import java.io.*;
import java.util.*;

import java.util.List;


public class Main implements Serializable {
    final static String[] NAMES = {"Албегонов Игорь", "Алборов Мухсен", "Зурыков Георгий", "Беззубов Баракуда"};
    final static String[] POSTS = {"Преподаватель", "Ученый", "Профессор", "Доцент"};
    final static String[] CITIES = {"Владикавказ", "Москва", "Санкт-Петербург", "Новокузнецк", "Липецк"};
    final static String[] DEPARTMENTS = {"Терапия", "Неврология", "Кардиология", "Гастроэнтерология", "Аллергологическое отделение", "Отделение реанимации и интенсивной терапии для больных с инфарктом миокарда"};
    final static String[] DIAGNOSIS = {"Простуда", "Депрессия", "Грип", "Диссециативное расстройство личности", "Биполярное расстройство", "Отравление", "Перелом", "Расстяжение"};


    static Hospital hospital;
    static List<Department> departments;
    static List<Patient> patients;
    static List<Doctor> doctors;
    static Scanner scanner;

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        scanner = new Scanner(System.in);

        fillData();
        System.out.println("1) Сортировка по стоимости лечения");
        System.out.println("2) Список наиболее дорогостоящих операций");
        System.out.println("3) По каждому врачу получить список пациентов");
        System.out.println("4) Cохранение объектов из коллекции в текстовый файл");
        System.out.println("5) Загрузка объектов из текстового файла в коллекцию");
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                //сортировка по стоимости лечения
                patients.sort(Comparator.comparingInt(Patient::getMedicalCost).reversed());
                System.out.println("Самые дорогостоящие операции");
                patients.forEach(System.out::println);
            case 2:
                //список наиболее дорогостоящих операций
            {
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
            }
            //список пациентов
            case 3:
                doctors.forEach(doctor -> {
                    List<Patient> founded = new ArrayList<>();
                    patients.forEach(patient -> {
                        Doctor healDoctor = patient.getHealingDoctor();
                        if (healDoctor.equals(doctor))
                            founded.add(patient);
                    });
                    System.out.println("Доктор " + doctor.getFIO() + ", кол-во пациентов: " + founded.size());
                });
                //задание лабораторной работы 4
            case 4:
                FileOutputStream fos = new FileOutputStream("saved.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(hospital);

                oos.flush();
                oos.close();
                break;

            case 5:
                FileInputStream fis = new FileInputStream("saved.out");
                ObjectInputStream ois = new ObjectInputStream(fis);

                hospital = (Hospital) ois.readObject();



                hospital.getDepartments().forEach(System.out::println);
                hospital.getDoctors().forEach(System.out::println);
                hospital.getPatients().forEach(System.out::println);

                System.out.println(hospital);
                System.out.println("Кол-во " + hospital.getDepartments().size() + " отделений");
                System.out.println("Кол-во " + hospital.getDoctors().size() + " докторов");
                System.out.println("Кол-во " + hospital.getPatients().size() + " пациентов");
                ois.read();
                ois.close();
                break;

        }
    }

      static void fillData() {
        hospital = new Hospital("ФГБОУ Клиническая больница №15 rus", NAMES[0], CITIES[0], "ул.Николаева 12");
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        departments = new ArrayList<>();
        Random random = new Random();

        System.out.print("Кол-во департаментов: ");
        int depCount = scanner.nextInt();
        System.out.print("Кол-во докторов: ");
        int doctorsCount = scanner.nextInt();
        System.out.print("Кол-во пациентов: ");
        int patientsCount = scanner.nextInt();


        for (int i = 0; i < depCount; i++) {
            Department department = new Department();
            department.setCity(CITIES[random.nextInt(CITIES.length)]);
            department.setFIOofDirector(NAMES[random.nextInt(NAMES.length)]);
            department.setCorpus(random.nextInt(10) + 1);
            department.setFloor(random.nextInt(5) + 1);
            department.setNameOfHospital("ФГБОУ Клиническая больница №" + random.nextInt(100));
            department.setaddress("Неизвестен");
            department.setNameOfDepartment(DEPARTMENTS[random.nextInt(DEPARTMENTS.length)]);
            departments.add(department);
        }

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
            patient.setInsurancesPolicy(random.nextLong());
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

        hospital.setPatients(patients);
        hospital.setDepartments(departments);
        hospital.setDoctors(doctors);

        departments.forEach(System.out::println);
        doctors.forEach(System.out::println);
        patients.forEach(System.out::println);
    }
}

