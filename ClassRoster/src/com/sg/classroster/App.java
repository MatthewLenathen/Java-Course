package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.*;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import com.sg.classroster.ui.*;
public class App
{
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(myIo);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoImpl();
        ClassRosterServiceLayer service = new ClassRosterServiceLayerImpl(dao,myAuditDao);
        ClassRosterController controller = new ClassRosterController(service,view);
        controller.run();
    }
}
