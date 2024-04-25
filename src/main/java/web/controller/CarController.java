//package web.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import web.carDao.CarDaoImpl;
//
//@Controller
////@RequestMapping(value = "/cars")
//public class CarController {
//
//    CarDaoImpl carDao = new CarDaoImpl();
//
//    @GetMapping(value = "/cars")
//    public String printCar(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
//        model.addAttribute("cars", carDao.getCarsList());
//        model.addAttribute("cars", carDao.carsCount(count));
//        return "cars";
//    }
//}
