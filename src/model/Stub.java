package model;
import java.time.Duration;

public class Stub
{
    Company company = new Company("Polytech Tours", "Emmanuel", "Neron");

    Employee employee_1 = new Employee("Pauline", "Henri", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
    Employee employee_2 = new Employee("Pauline", "Mourlon", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
    Employee employee_3 = new Employee("Pauline", "Occelli", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
    Employee employee_4 = new Employee("Samuel", "Souville", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
    Employee employee_5 = new Employee("Olivier", "Millochau", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));
    Employee employee_6 = new Employee("Mathieu", "Guillot", false, java.time.Duration.ofHours(8), java.time.Duration.ofHours(18));

    employee_1 = Manager(employee_1);

    Department department_1 = new Department("Amenagement et Environnement", );
