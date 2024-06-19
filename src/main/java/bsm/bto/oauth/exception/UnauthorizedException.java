//권한이 없을 때 발생하는 예외입니다.

package bsm.bto.oauth.exception;

public class UnauthorizedException extends OAuthException {
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
