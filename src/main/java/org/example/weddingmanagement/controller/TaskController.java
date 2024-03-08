package org.example.weddingmanagement.controller;

import org.example.weddingmanagement.model.DTO.Statistical;
import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.model.entity.Task;
import org.example.weddingmanagement.service.ICategoryService;
import org.example.weddingmanagement.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> listProvinces(){
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView listTask(@PageableDefault(size = 5) Pageable pageable){
        Page<Task> tasks = taskService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/task/index");
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("task", new Task());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("task") Task task, RedirectAttributes redirectAttributes){
        taskService.save(task);
        redirectAttributes.addFlashAttribute("message", "create new task successfully!");
        return "redirect:/tasks";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id){
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/task/update");
            modelAndView.addObject("tasks", task.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("task") Task task, RedirectAttributes redirectAttributes){
        taskService.save(task);
        redirectAttributes.addFlashAttribute("success", "update task successfully");
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        taskService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete task successfully");
        return "redirect:/tasks";
    }


    @GetMapping("/search")
    public ModelAndView listCustomersSearch(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Task> tasks;
        if(search.isPresent()){
            tasks = taskService.findAllByName(pageable, search.get());
        } else {
            tasks = taskService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/task/index");
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

}
