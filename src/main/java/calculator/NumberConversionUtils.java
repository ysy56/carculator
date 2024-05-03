package calculator;

public class NumberConversionUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Number> T convertNumberToType(Number result, Class<T> type) {
        if (type == Integer.class) {
            return (T) Integer.valueOf(result.intValue());
        } else if (type == Double.class) {
            return (T) Double.valueOf(result.doubleValue());
        } else if (type == Long.class) {
            return (T) Long.valueOf(result.longValue());
        } else {
            throw new IllegalArgumentException("지원하지 않는 타입입니다. " + type);
        }
    }
}
