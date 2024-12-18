package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BurgerController {
    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }
    @PostMapping
    public Burger saveBurger(Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }

    @GetMapping("/id")
    public Burger getBurgerById(@PathVariable  long id) {
        return burgerDao.findById(id);
    }

    @GetMapping("breadType/{breadType}")
    public List<Burger> getBurgerByBreadType(@PathVariable("breadType") String breadType) {
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(bt);
    }
    @GetMapping("/price/{price}")
    public List<Burger> getBurgerByPrice(@PathVariable("price") Integer price) {
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/content/{content}")
    public List<Burger> getBurgerByContent(@PathVariable("content") String content) {
        return burgerDao.findByContent(content);
    }
    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable long id) {

        return burgerDao.remove(id);
    }
}
