//토큰이 만료되었을 때 발생하는 예외입니다.

package bsm.bto.oauth.exception;

public class TokenExpiredException extends OAuthException {
    public TokenExpiredException(String message) {
        super(message);
    }

    public TokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
