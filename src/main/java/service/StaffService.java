package service;

import model.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffService implements IStaffService{
    private static Map<Integer, Staff> staffMap = new HashMap<>();
    static {
        staffMap.put(1,new Staff(1,"Hung","Nam Dinh",18));
        staffMap.put(2,new Staff(2,"Mung","Nam Dinh",18));
        staffMap.put(3,new Staff(3,"Binh","Nam Dinh",18));
        staffMap.put(4,new Staff(4,"Doanh","Nam Dinh",18));
        staffMap.put(5,new Staff(5,"Thiep","Nam Dinh",18));
    }
    @Override
    public List<Staff> findAll() {
        return new ArrayList<>(staffMap.values());
    }

    @Override
    public boolean create(Staff staff) {
        staffMap.put(staff.getId(),staff);
        return false;
    }

    @Override
    public boolean delete(int id) {
        staffMap.remove(id);
        return false;
    }

    @Override
    public boolean edit(int id, Staff staff) {
        staffMap.replace(id,staff);
        return false;
    }

    @Override
    public Staff findById(int id) {
       return staffMap.get(id);
    }

    @Override
    public Staff findByName(String name) {
        return null;
    }
}
