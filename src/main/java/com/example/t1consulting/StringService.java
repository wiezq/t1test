package com.example.t1consulting;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StringService {

  public  Map<Character, Integer> charFrequence(String s) {
    if (s.isEmpty()) throw new IllegalArgumentException("String is empty");
    Map<Character, Integer> frequencies = new HashMap<>();
    for (char ch : s.toCharArray()) frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
    return frequencies;
  }
}
