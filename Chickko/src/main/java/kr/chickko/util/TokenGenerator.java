package kr.chickko.util;
import java.util.UUID;
public class TokenGenerator {
	public String getToken() {
		return UUID.randomUUID().toString();
	}
}