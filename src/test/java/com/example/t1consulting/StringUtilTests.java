package com.example.t1consulting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilTests {

  StringService stringService;

  @BeforeEach
  public void setUp() {
    stringService = new StringService();
  }

  @Test
  public void testCharFrequency() {
    Map<Character, Integer> freq = stringService.charFrequence("test");
    assertEquals(2, freq.get('t'));
    assertEquals(1, freq.get('e'));
    assertEquals(1, freq.get('s'));
  }

  @Test
  public void testCharFrequencyWithEmptyString() {
    assertThrows(IllegalArgumentException.class, () -> stringService.charFrequence(""));
  }

  @Test
  public void testCharFrequencyWithNull() {
    assertThrows(NullPointerException.class, () -> stringService.charFrequence(null));
  }
}
