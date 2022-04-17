package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Admin;

import org.springframework.stereotype.Repository;
@Repository
public class AdminImpl implements AdminDAO {

    private static List<Admin> admins;
    {
        admins = new ArrayList<>();
        admins.add(new Admin(1, "Admin 1", "adm1@gmail.com","1100001"));
        admins.add(new Admin(2, "Admin 2", "adm2@gmail.com","1100002"));
        admins.add(new Admin(3, "Admin 3", "adm3@gmail.com","1100003"));
    }
    @Override
    public List list() {
        // TODO Auto-generated method stub
        return admins;
    }

    @Override
    public Admin get(long id) {
        // TODO Auto-generated method stub
        for (Admin admin : admins) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin create(Admin admin) {
        // TODO Auto-generated method stub
        admins.add(admin);
        return admin;
    }

    @Override
    public Admin update(Long id, Admin admin) {
        // TODO Auto-generated method stub

            for(Admin p : admins) {
                if(p.getId() == id) {
                    admin.setId(p.getId());
                    admins.remove(p);
                    admins.add(admin);
                    return p;
                }
            }
        return null;
    }

    @Override
    public Long delete(Long id) {
        // TODO Auto-generated method stub
        for (Admin admin : admins) {
            if (admin.getId() == id) {
                admins.remove(admin);
                return id;
            }
        }
        return null;
    }

}
    