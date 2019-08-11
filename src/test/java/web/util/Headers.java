package web.util;

public enum Headers {

  WHO_WE_SERVE ("WHO WE SERVE"),
  SUBJECTS ("SUBJECTS"),
  ABOUT ("ABOUT");

  private String header;

  Headers(String header) {
    this.header = header;
  }

  public String getValue() {
    return header;
  }
}