package org.example.weddingmanagement.controller;

import org.example.weddingmanagement.model.DTO.Statistical;
import org.example.weddingmanagement.model.entity.Category;
import org.example.weddingmanagement.model.entity.Task;
import org.example.weddingmanagement.service.ICategoryService;
import org.example.weddingmanagement.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/index");
        Iterable<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("categories", new Category());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("categories") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "create new category successfully !");
        return "redirect:/categories";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/update");
            modelAndView.addObject("categories", category.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("categories") Category category, RedirectAttributes redirectAttributes ){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "update category successfully!");
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Long id, RedirectAttributes redirectAttributes){
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete category successfully!");
        return "redirect:/categories";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView view(@PathVariable("id") Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()){
            return new ModelAndView("/error_404");
        }
        Iterable<Task> tasks = taskService.findAllByCategory(categoryOptional.get());
        ModelAndView modelAndView = new ModelAndView("/task/index");
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @GetMapping("/statistical")
    public ModelAndView statistical(){
        ModelAndView modelAndView = new ModelAndView("category/statistical");
        Iterable<Statistical> statisticals = categoryService.statistical();
        modelAndView.addObject("statisticals", statisticals);
        return modelAndView;
    }
}
