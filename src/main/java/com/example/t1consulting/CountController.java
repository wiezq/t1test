package com.example.t1consulting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("/api/v1")
public class CountController {

  private final StringService stringService;

  public CountController(StringService stringService) {
    this.stringService = stringService;
  }

  @GetMapping(value = "/count", produces = "application/json")
  public ResponseEntity<Map<Character, Integer>> getChars(@RequestParam String s) {
    return ResponseEntity.ok(stringService.charFrequence(s));
  }
}
