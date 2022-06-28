package com.flower.controller;

import com.flower.model.Flower;
import com.flower.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@SessionAttributes("orderList")
public class FlowerShopController {
    @Autowired
    private FlowerService flowerService;

    @ModelAttribute("orderList")
    public Map<Flower, Integer> orderList() {
        return new LinkedHashMap<>();
    }

    @GetMapping("/")
    public String showFlowerShop(@RequestParam(name = "page", defaultValue = "0") int page,
                                 Model model,
                                 @ModelAttribute("orderList") Map<Flower, Integer> flowerList) {
        model.addAttribute("flowerList", flowerService.findAll(PageRequest.of(page, 4)));
        model.addAttribute("sessionFlowerList", flowerList);
        return "flower-list";
    }

    @GetMapping("/order/{id}")
    public String order(@PathVariable("id") int id, Model model) {
        model.addAttribute("flower", flowerService.findByID(id));
        return "flower-order";
    }

    @GetMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id,
                      @ModelAttribute("orderList") Map<Flower, Integer> flowerList,
                      RedirectAttributes redirectAttributes) {
        Flower flower = flowerService.findByID(id);
        boolean flag = false;
        for (Map.Entry<Flower, Integer> entry : flowerList.entrySet()) {
            if (entry.getKey().getId() == id) {
                entry.setValue(entry.getValue() + 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            flowerList.put(flower, 1);
        }
        redirectAttributes.addFlashAttribute("msg", "Thêm vào giỏ hàng thành công");
        return "redirect:/";
    }

    @GetMapping("/order-list")
    public String orderList(@ModelAttribute("orderList") Map<Flower, Integer> flowerList, Model model) {
        model.addAttribute("flowerList", flowerList);
        int total = 0;
        for (Map.Entry<Flower, Integer> entry : flowerList.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        model.addAttribute("total", total);
        return "order-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,
                         @ModelAttribute("orderList") Map<Flower, Integer> flowerList) {
        Flower flower = null;
        for (Map.Entry<Flower, Integer> entry : flowerList.entrySet()) {
            if (entry.getKey().getId() == id) {
                flower = entry.getKey();
                break;
            }
        }
        flowerList.remove(flower);
        return "redirect:/order-list";
    }
}
