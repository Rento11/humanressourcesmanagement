package com.med.humanressourcesmanagement.web;

import com.med.humanressourcesmanagement.dao.entities.Position;
import com.med.humanressourcesmanagement.service.PositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PositionController {
    @Autowired
    private PositionManager positionManager;

    @GetMapping("positionsList")
    public String getRooms(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "taille", defaultValue = "3") int taille, @RequestParam(name = "search", defaultValue = "") String keyword){
        Page<Position> positions = positionManager.searchPositions(keyword,page, taille);
        model.addAttribute("positions", positions.getContent());
        int[] pages = new int[positions.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "positionsList";
    }

    @GetMapping("/addPosition")
    public String addRoomGet(Model model) {
        model.addAttribute("position", new Position());
        return "addPosition";
    }

//    @PostMapping("/addPosition")
//    public String addPositionPost(Model model, @Valid Position position, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "addPosition";
//        }
//        positionManager.addPosition(position);
//        return "redirect:/positionsList";
//    }

    @GetMapping("/deletePosition")
    public String deletePositionAction(@RequestParam(name = "id") Integer id, Integer page, String search) {
        if (positionManager.deletePositionById(id)) {
            return "redirect:/positionsList";
        } else {
            return "error";
        }
    }

    @GetMapping("/updatePosition")
    public String updatePositionGet(Model model, @RequestParam(name = "id") Integer id) {
        Position position = positionManager.findPositionById(id);
        if (position != null) {
            model.addAttribute("position", position);
            return "updatePosition";
        } else {
            return "error";
        }
    }

//    @PostMapping("/updatePosition")
//    public String updatePositionPost(Model model, @RequestParam(name = "id") Integer id, @RequestParam(name = "positionNumber") String positionNumber, @RequestParam(name = "pricePerNight") double pricePerNight, @RequestParam(name = "isAvailable") boolean isAvailable, @RequestParam(name = "capacity") int capacity) {
//        Position position = positionManager.findPositionById(id);
//        position.setPositionNumber(positionNumber);
//        position.setPricePerNight(pricePerNight);
//        position.setAvailable(isAvailable);
//        position.setCapacity(capacity);
//        if (position != null) {
//            positionManager.updatePosition(position);
//            return "redirect:/positionsList";
//        } else {
//            return "error";
//        }
//    }
}
