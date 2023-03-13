package com.example.helloworld.api.controller;

import com.example.helloworld.api.service.JavaLearn1Service;
import com.example.helloworld.api.service2.JavaLearn2Service;
import com.example.helloworld.model.CalculationRequest;
import com.example.helloworld.model.CalculationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JavaLearn1Controller {
    @Autowired
    private JavaLearn1Service javaLearn1Service;

    @Autowired
    private JavaLearn2Service javaLearn2Service;


    @GetMapping("/square/number")
    public ResponseEntity<Object> squareFromNumber(
            @RequestParam(name = "number", required = true) Integer number
    ) {
        if (number == null) {
            return ResponseEntity.badRequest().body("Invalid Parameter");
        } else {
            return ResponseEntity.ok().body(javaLearn1Service.square(number)+javaLearn2Service.cubic(number));
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResult> calculate(@RequestBody CalculationRequest request) {
        // Perform the required calculations
        int doubleItResult = request.getDoubleIt() * 2;
        int setToMinusResult = -request.getSetToMinus();

        // Create the response object
        CalculationResult result = new CalculationResult();
        result.setDoubleItResult(doubleItResult);
        result.setSetToMinusResult(setToMinusResult);

        // Return the response object in the response body
        return ResponseEntity.ok(result);
    }

    @PostMapping("/myEndpoint")
    public ResponseEntity<Object> myEndpoint(@RequestBody Map<String, List<Map<String, Integer>>> input) {

        List<Map<String, Integer>> list_of_x = input.get("list_of_x");
        List<Map<String, Integer>> list_of_y = new ArrayList<>();

        for (Map<String, Integer> map : list_of_x) {
            Map<String, Integer> yMap = new HashMap<>();
            yMap.put("y", map.get("x") * map.get("x"));
            list_of_y.add(yMap);
        }

        Map<String, List<Map<String, Integer>>> output = new HashMap<>();
        output.put("list_of_y", list_of_y);

        return ResponseEntity.ok(output);
    }

}





