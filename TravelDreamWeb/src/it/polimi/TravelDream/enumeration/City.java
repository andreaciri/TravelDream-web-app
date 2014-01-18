package it.polimi.TravelDream.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum City {
	Rome, Paris, Amsterdam, Barcelona, Dublin, London, 
	Monaco, Oslo, Copenhagen, Athens, Budapest, Stockholm;


	private static final List<City> VALUES =
    Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static City randomCity()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }



}
