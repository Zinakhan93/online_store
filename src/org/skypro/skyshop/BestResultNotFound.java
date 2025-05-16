package org.skypro.skyshop;

public class BestResultNotFound extends Exception{

  public BestResultNotFound(String message) {
    super( "Не найден подходящий объект  для поиска запроса " + message);
  }
}
