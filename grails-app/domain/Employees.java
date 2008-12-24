import com.google.gdata.data.spreadsheet.ListEntry;

import java.util.ArrayList;
import java.util.List;

public class Employees extends ArrayList<Employee> {
    public Employees() {

    }

    public Employees(List<ListEntry> entries) {
        for (ListEntry entry : entries) {
            String realName = entry.getCustomElements().getValue("name").trim();
            String yahooId = Util.defaultString(entry.getCustomElements().getValue("ymid"));
            Employee employee = Employee.get(realName, yahooId);
            this.add(employee);
        }
    }

    public static Employees get() {
        try {
            GDocService speadService = new GDocService("zee.ho.81@gmail.com", "Multiscan200ES");
            List<ListEntry> allContacts = speadService.entries("TW China Contact List", "Contact Details");
            return new Employees(allContacts);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
