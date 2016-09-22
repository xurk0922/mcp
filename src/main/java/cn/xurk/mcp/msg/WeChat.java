package cn.xurk.mcp.msg;

public class WeChat {
	private String signature;	// 微信加密签名
	
	private Long timestamp;	// 时间戳
	
	private int nonce;		// 随机数
	
	private String echostr;	// 随机字符串

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
