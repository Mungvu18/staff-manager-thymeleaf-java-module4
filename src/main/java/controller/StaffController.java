package controller;

import model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IStaffService;

import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private IStaffService staffService;
    @GetMapping("")
    public ModelAndView showListStaff(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("staff",new Staff());
        List<Staff> staffList = staffService.findAll();
        modelAndView.addObject("list",staffList);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("staff",new Staff());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Staff staff){
        ModelAndView modelAndView = new ModelAndView("redirect:/staffs");
        int id = (int) (Math.random()*1000);
        staff.setId(id);
        staffService.create(staff);
        return modelAndView;
    }
    @GetMapping("delete")
    public ModelAndView delete(@RequestParam int id){
       staffService.delete(id);
       return showListStaff();
    }
    @GetMapping("edit")
    public ModelAndView showFormEdit(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Staff staff = staffService.findById(id);
        modelAndView.addObject("staff",staff);
        return modelAndView;
    }
    @PostMapping("edit")
    public ModelAndView edit(@RequestParam int id, Staff staff){
        ModelAndView modelAndView = new ModelAndView("redirect:/staffs");
        staff.setId(id);
        staffService.edit(id,staff);
        return modelAndView;
    }
    @PostMapping("search")
    public ModelAndView showFormSearch(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("detail");
        Staff staff = staffService.findById(id);
        modelAndView.addObject(staff);
        return modelAndView;
    }

}
