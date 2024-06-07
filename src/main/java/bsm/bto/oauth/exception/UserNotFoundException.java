//사용자를 찾을 수 없는 경우에 발생하는 예외입니다.

package bsm.bto.oauth.exception;

public class UserNotFoundException extends OAuthException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
