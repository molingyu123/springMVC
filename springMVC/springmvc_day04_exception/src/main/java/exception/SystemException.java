package exception;

/**
 *  自定义异常类
 */
public class SystemException extends Exception {

    // 异常的消息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // 构造方法，使用这个对象就必须传入一个参数
    public SystemException(String message) {
        this.message = message;
    }
}
