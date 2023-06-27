package bookstore;

public class BookUtil {
  private static final String IMAGE_FILE_SAVE_PATH = "bookstore/imageFileSave";
  private static final int FILE_UPLOAD_MAX_SIZE = 1024 * 1024 * 10;

  public static String getBookKindName(String bookKind) {
    String bookKindName = null;

    switch (bookKind) {
      case "100":
        bookKindName = "문학";
        break;
      case "200":
        bookKindName = "외국어";
        break;
      case "300":
        bookKindName = "컴퓨터";
        break;
      case "all":
        bookKindName = "전체";
        break;
    }

    return bookKindName;
  }

  public static String getSavePath() {
    return IMAGE_FILE_SAVE_PATH;
  }

  public static int getFileUploadMaxSize() {
    return FILE_UPLOAD_MAX_SIZE;
  }

  public static int calcDiscountPrice(int price, int discountRate) {
    return (int) (price * ((float) (100 - discountRate) / 100));
  }
}
