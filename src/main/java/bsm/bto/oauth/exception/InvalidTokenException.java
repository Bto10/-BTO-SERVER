// 유효하지 않은 토큰을 사용할 때 발생하는 예외입니다.

package bsm.bto.oauth.exception;

public class InvalidTokenException extends OAuthException {
    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
