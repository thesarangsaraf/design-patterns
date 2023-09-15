package decorator;

import decorator.abstraction.EmployeeSalaryChangeListener;

import java.io.File;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
        this.informSalaryChangeListeners(salary);
    }

    private void informSalaryChangeListeners(long updatedSalary) {
        String packageName = System.getProperty("user.dir") + "/src/decorator";
        ArrayList<File> files = this.listFiles(packageName, null);
        for (File file : files) {
            String fileName = file.getAbsolutePath();
            fileName = fileName.substring(fileName.lastIndexOf("decorator")).replace("\\", ".").replace(".java", "");
            try {
                Class<?> clazz = Class.forName(fileName);
                boolean isAssignable = EmployeeSalaryChangeListener.class.isAssignableFrom(clazz);
                if (isAssignable && clazz != EmployeeSalaryChangeListener.class) {
                    EmployeeSalaryChangeListener o = (EmployeeSalaryChangeListener) clazz.getConstructors()[0].newInstance();
                    o.listen(updatedSalary);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private ArrayList<File> listFiles(String path, ArrayList<File> files) {
        if (files == null) {
            files = new ArrayList<>();
        }
        File file = new File(path);
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles == null) {
                return files;
            }
            for (File subFile : subFiles) {
                files = listFiles(subFile.getAbsolutePath(), files);
            }
        } else {
            files.add(file);
        }
        return files;
    }
}