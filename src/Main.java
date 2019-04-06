import jdk.swing.interop.SwingInterOpUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    static Hospital[] hospital;
    static Department[] department;
    static Patient[] patient;
    static Doctor[] doctor;

    public static void main(String[] args){
        addDoctors();
    }


    public static void printHospitals() {
        for (int i = 0; i < hospital.length; i++) {
            String message = hospital[i].toString();
            System.out.println(message);
        }
    }

    public static void addHospitals() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Больницы.");
        System.out.print("Количество больниц:");
        int n = scanner.nextInt();

        hospital = new Hospital[n];
        for (int i = 0; i < n; i++) {
            hospital[i] = new Hospital();
            System.out.print("Название: ");
            hospital[i].setNameOfHospital(scanner.next());
            System.out.print("Город: ");
            hospital[i].setCity(scanner.next());
            System.out.print("Адрес: ");
            hospital[i].setaddress(scanner.next());
            System.out.print("ФИО директора: ");
            hospital[i].setFIOofDirector(scanner.next());
        }
    }

    public static void printDepartment() {
        for (int i = 0; i < department.length; i++) {
            String message = department[i].toString();
            System.out.println(message);
        }
    }

    public static void addDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Отделения.");
        System.out.print("Количество:");
        int n = scanner.nextInt();

        department = new Department[n];
        for (int i = 0; i < n; i++) {
            department[i] = new Department();
            System.out.print("Название больницы: ");
            department[i].setNameOfHospital(scanner.next());
            System.out.print("Город: ");
            department[i].setCity(scanner.next());
            System.out.print("Адрес: ");
            department[i].setaddress(scanner.next());
            System.out.print("ФИО директора: ");
            department[i].setFIOofDirector(scanner.next());
            System.out.println("Название отделения:");
            department[i].setNameOfDepartment(scanner.next());
            System.out.println("Корпус:");
            department[i].setCorpus(scanner.nextInt());
            System.out.println("Этаж:");
            department[i].setFloor(scanner.nextInt());

        }

    }

    public static void printPatient() {
        for (int i = 0; i < patient.length; i++) {
            String message = patient[i].toString();
            System.out.println(message);
        }
    }

    public static void addPatient() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пациенты.");
        System.out.print("Количество:");

        DateFormat formater = new SimpleDateFormat("dd.mm.yyyy");

        int n = scanner.nextInt();

        patient = new Patient[n];
        for (int i = 0; i < n; i++) {
            patient[i] = new Patient();
            System.out.print("Название больницы: ");
            patient[i].setNameOfHospital(scanner.next());
            System.out.print("Город: ");
            patient[i].setCity(scanner.next());
            System.out.print("Адрес: ");
            patient[i].setaddress(scanner.next());
            System.out.print("ФИО директора: ");
            patient[i].setFIOofDirector(scanner.next());
            System.out.println("Название отделения:");
            patient[i].setNameOfDepartment(scanner.next());
            System.out.println("Корпус:");
            patient[i].setCorpus(scanner.nextInt());
            System.out.println("Этаж:");
            patient[i].setFloor(scanner.nextInt());
            System.out.println("Ф.И.О.: ");
            patient[i].setFIO(scanner.next());
            System.out.println("Полис страхования:");
            patient[i].setInsurancesPolicy(scanner.nextLong());
            System.out.println("Дата поступления:");
            patient[i].setArrivalDate(formater.parse(scanner.next()));
            System.out.println("Дата выписки:");
            patient[i].setStatementDate(formater.parse(scanner.next()));
            System.out.println("Диагноз:");
            patient[i].setDiagnosis(scanner.next());
            System.out.println("Дата операции:");
            patient[i].setDateOfOperation(formater.parse(scanner.next()));
            System.out.println("Название операции:");
            patient[i].setNameOfOperation(scanner.next());
            System.out.println("Цена лечения:");
            patient[i].setMedicalCost(scanner.nextInt());
        }
    }

    public static void printDoctor() {
        for (int i = 0; i < doctor.length; i++) {
            String message = doctor[i].toString();
            System.out.println(message);
        }
    }

    public static void addDoctors() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доктора.");
        System.out.print("Количество:");

        DateFormat formater = new SimpleDateFormat("dd.mm.yyyy");

        int n = scanner.nextInt();

        doctor = new Doctor[n];
        for (int i = 0; i < n; i++) {
            doctor[i] = new Doctor();
            System.out.print("Название больницы: ");
            doctor[i].setNameOfHospital(scanner.next());
            System.out.print("Город: ");
            doctor[i].setCity(scanner.next());
            System.out.print("Адрес: ");
            doctor[i].setaddress(scanner.next());
            System.out.print("ФИО директора: ");
            doctor[i].setFIOofDirector(scanner.next());
            System.out.println("Название отделения:");
            doctor[i].setNameOfDepartment(scanner.next());
            System.out.println("Корпус:");
            doctor[i].setCorpus(scanner.nextInt());
            System.out.println("Этаж:");
            doctor[i].setFloor(scanner.nextInt());
            System.out.println("Ф.И.О.: ");
            doctor[i].setFIO(scanner.next());
            System.out.println("должность:");
            doctor[i].setPost(scanner.next());
            System.out.println("Стаж работы:");
            doctor[i].setWorkExperience(scanner.nextInt());
            System.out.println("Научная должность:");
            doctor[i].setSciencePost(scanner.next());

        }
    }
}

